package com.ideamart.livecricket.process;

import com.ideamart.livecricket.api.Endpoints;
import com.ideamart.livecricket.client.Invoke;
import com.ideamart.livecricket.exception.LiveCricketException;
import com.ideamart.livecricket.model.match.Match;
import com.ideamart.livecricket.model.match.MatchResponse;
import com.ideamart.livecricket.model.score.ScoreResponse;
import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created by yasith on 2/7/17.
 */
public class Process {
    final static Logger log = LoggerFactory.getLogger(Process.class);

    final static String TEAM_NAME = "Sri Lanka";
    public void doProcess(String sourceAddress) throws LiveCricketException {

        Invoke invoker = new Invoke();
        MatchResponse matchResponse = invoker.getAllMatches();
        ArrayList<Match> matches = (ArrayList<Match>) matchResponse.getMatches();
        ScoreResponse scoreResponse = null;

        for (Match match : matches) {
            int uniqueId = match.getUniqueId();
            String team1 = match.getTeam1();
            String team2 = match.getTeam2();
            if(team1.equals(TEAM_NAME) || team2.equals(TEAM_NAME)){
                scoreResponse = invoker.getScore(uniqueId);
                break;
            }
        }

        StringBuilder sb =  new StringBuilder();
        if(scoreResponse != null){
            if(scoreResponse.getMatchStarted()){
                sb.append(scoreResponse.getTeam1()+ " vs " + scoreResponse.getTeam2());
                sb.append(" Match Started ");
                sb.append(scoreResponse.getInningsRequirement() + "  ");
                sb.append(scoreResponse.getScore());
            }else{
                sb.append(scoreResponse.getTeam1()+ " vs " + scoreResponse.getTeam2());
                sb.append(" " + scoreResponse.getType()+ " ");
                sb.append(" Match is not yet started ");
                sb.append(scoreResponse.getInningsRequirement() + "  ");
                sb.append(scoreResponse.getDateTimeGMT());
            }
        }
        String results = StringEscapeUtils.escapeJava(sb.toString());
        if(log.isDebugEnabled()){
            log.debug(results);
        }
        invoker.sendSms(sourceAddress, results);
    }
}
