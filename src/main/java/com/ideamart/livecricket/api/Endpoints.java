package com.ideamart.livecricket.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ideamart.livecricket.exception.LiveCricketException;
import com.ideamart.livecricket.process.Process;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by yasith on 1/18/17.
 */

@Path("/livecricket")
public class Endpoints {

    final static Logger log = LoggerFactory.getLogger(Endpoints.class);

    @GET
    @Path("/version")
    public String printVersion(){
        return "v1.0";
    }

    @POST
    @Path("/smsreceive")
    public Response smsReceive(String jsonBody){
        if(log.isInfoEnabled())
            log.info("jsonBody : " + jsonBody);

        /**

         {
             "message": "my testing message from app1",
             "sourceAddress": "tel:94777123456",
             "requestId": "APP_000001",
             "encoding": "0",
             "version": "1.0"
         }

         */

        String message = null;
        String sourceAddress = null;
        String requestId = null;
        String encoding = null;
        String version = null;

        String jsonPayload;

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(jsonBody).getAsJsonObject();

        JsonElement sourceAddressElement = jsonObject.get("sourceAddress");
        if(!(sourceAddressElement instanceof JsonNull)) sourceAddress = sourceAddressElement.getAsString();

        Process process = new Process();

        try {
            process.doProcess(sourceAddress);
        } catch (LiveCricketException e) {
            return Response.status(HttpServletResponse.SC_BAD_REQUEST).build();
        }

        return Response.status(HttpServletResponse.SC_OK).build();
    }
}
