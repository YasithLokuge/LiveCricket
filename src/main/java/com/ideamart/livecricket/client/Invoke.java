package com.ideamart.livecricket.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideamart.livecricket.exception.LiveCricketException;
import com.ideamart.livecricket.exception.ErrorCodes;
import com.ideamart.livecricket.model.match.MatchResponse;
import com.ideamart.livecricket.model.score.ScoreResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

/**
 * Created by yasith on 1/26/17.
 */
public class Invoke {

    final static Logger log = LoggerFactory.getLogger(Invoke.class);
    final static String MATCH_PATH = "matches";
    final static String CRICKET_SCORE = "cricketScore";

    String remoteUrl = null;
    String apikey = null;

    String dialogUrl = null;
    String appId = null;
    String password = null;

    public Invoke(){
        //ConfigReader configReader = ConfigReader.getInstance();
        //Map<Object,Object> dialog = (Map<Object, Object>) configReader.getApplicationConfiguration().getDialog();
        //Map<Object,Object> remote = (Map<Object, Object>) configReader.getApplicationConfiguration().getRemote();

//        remoteUrl = (String) remote.get("url");
//        apikey = (String) remote.get("apikey");
//
//        appId = (String) dialog.get("appId");
//        password = (String) dialog.get("password");
//        dialogUrl = (String) dialog.get("url");

        remoteUrl = "http://cricapi.com/api/";
        apikey = "8eRChM1x6UXeKBhkAbqo9J8Rnhh2";

        appId = "APP_033377";
        password = "185a2f3e8674d34c56d3c275a2980014";
        dialogUrl = "https://api.dialog.lk/sms/send";
    }

    public MatchResponse getAllMatches() throws LiveCricketException {

        JSONObject requestJson = new JSONObject();
        requestJson.put("apikey",apikey);

        if (log.isDebugEnabled()) {
            log.debug("Request JSON : " + requestJson.toString());
        }

        UriBuilder builder = UriBuilder.fromPath(remoteUrl + MATCH_PATH);
        URI callUrl = builder.build();

        if (log.isDebugEnabled()) {
            log.debug("Remote Call URL : " + callUrl);
        }

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(callUrl);
        HttpResponse response;
        MatchResponse matchResponse;

        StringEntity stringEntity = new StringEntity(requestJson.toString(), ContentType.APPLICATION_JSON);
        post.setEntity(stringEntity);
        post.setHeader("Content-type", "application/json");

        try {
            response = client.execute(post);
            String responseJsonString = EntityUtils.toString(response.getEntity());
            ObjectMapper mapper = new ObjectMapper();
            matchResponse = mapper.readValue(responseJsonString, MatchResponse.class);

            if(log.isDebugEnabled()){
                log.debug("Response Code : " + response.getStatusLine().getStatusCode());
            }

        } catch (IOException e) {
            log.error("IO exception while calling remote URL : " + callUrl);
            log.error("IO exception while calling remote URL : " , e);
            throw new LiveCricketException(ErrorCodes.IO_EXCEPTION.getCode() , e);
        }
        return matchResponse;
    }


    public ScoreResponse getScore(int unique_id) throws LiveCricketException {

        JSONObject requestJson = new JSONObject();
        requestJson.put("apikey",apikey);
        requestJson.put("unique_id",unique_id);

        if (log.isDebugEnabled()) {
            log.debug("Request JSON : " + requestJson.toString());
        }

        UriBuilder builder = UriBuilder.fromPath(remoteUrl + CRICKET_SCORE);
        URI callUrl = builder.build();

        if (log.isDebugEnabled()) {
            log.debug("Remote Call URL : " + callUrl);
        }

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(callUrl);
        HttpResponse response;
        ScoreResponse scoreResponse;

        StringEntity stringEntity = new StringEntity(requestJson.toString(), ContentType.APPLICATION_JSON);
        post.setEntity(stringEntity);
        post.setHeader("Content-type", "application/json");

        try {
            response = client.execute(post);
            String responseJsonString = EntityUtils.toString(response.getEntity());
            ObjectMapper mapper = new ObjectMapper();
            scoreResponse = mapper.readValue(responseJsonString, ScoreResponse.class);

            if(log.isDebugEnabled()){
                log.debug("Response Code : " + response.getStatusLine().getStatusCode());
            }

        } catch (IOException e) {
            log.error("IO exception while calling remote URL : " + callUrl);
            log.error("IO exception while calling remote URL : " , e);
            throw new LiveCricketException(ErrorCodes.IO_EXCEPTION.getCode() , e);
        }
        return scoreResponse;
    }


    public void sendSms(String address, String message) throws LiveCricketException {

        String json = "{  \"message\": \"{message}\",  \"destinationAddresses\": [\"{msisdn}\"],  \"password\": \"185a2f3e8674d34c56d3c275a2980014\",  \"applicationId\": \"APP_033377\"}";
        String requestJson = json.replace("{msisdn}",address).replace("{message}",message);

        if(log.isDebugEnabled())
            log.debug(requestJson);

        if (log.isDebugEnabled()) {
            log.debug("Remote Call URL : " + dialogUrl);
        }

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(dialogUrl);
        HttpResponse response;
        ScoreResponse scoreResponse;

        StringEntity stringEntity = new StringEntity(requestJson, ContentType.APPLICATION_JSON);
        post.setEntity(stringEntity);
        post.setHeader("Content-type", "application/json");

        try {
            response = client.execute(post);
            String responseJsonString = EntityUtils.toString(response.getEntity());

            if(log.isDebugEnabled()){
                log.debug("Response Code : " + response.getStatusLine().getStatusCode());
                log.debug("response Json : " + responseJsonString);
            }

        } catch (IOException e) {
            log.error("IO exception while calling remote URL : " + dialogUrl);
            log.error("IO exception while calling remote URL : " , e);
            throw new LiveCricketException(ErrorCodes.IO_EXCEPTION.getCode() , e);
        }
    }
}
