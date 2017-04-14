import com.ideamart.livecricket.client.Invoke;
import com.ideamart.livecricket.exception.LiveCricketException;
import com.ideamart.livecricket.model.match.Match;
import com.ideamart.livecricket.model.match.MatchResponse;
import com.ideamart.livecricket.model.score.ScoreResponse;
import org.junit.Test;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.ArrayList;

/**
 * Created by yasith on 1/27/17.
 */
public class InvokeTest {

    final static String TEAM_NAME = "Sri Lanka";
    @Test
    public void sendPostTest() throws LiveCricketException {
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

        if(scoreResponse != null){
            System.out.println(scoreResponse.getInningsRequirement());
            System.out.println(scoreResponse.getType());
            System.out.println(scoreResponse.getTeam1());
            System.out.println(scoreResponse.getTeam2());
            System.out.println(scoreResponse.getMatchStarted());
            if(scoreResponse.getScore() != null){
                System.out.println(scoreResponse.getScore());
            }
        }
    }

    @Test
    public void urlCheck(){
        String template = "http://www.wso2telco.com/something/{msisdn}";
        UriBuilder builder = UriBuilder.fromPath(template);
        URI output = builder.build("94771353682");
        //System.out.println(output.toString());
    }
}
