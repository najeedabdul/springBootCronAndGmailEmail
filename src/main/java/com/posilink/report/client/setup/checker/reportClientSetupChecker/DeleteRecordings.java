package com.posilink.report.client.setup.checker.reportClientSetupChecker;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("recordings")
public class DeleteRecordings {

    private String deleteRecordingsEndpoint = "/api/cdvr/v1/recordings/";
    private String host = "http://internal-a4f9c59b0b83a11e8bc780ab401aeb85-1266363647.us-east-1.elb.amazonaws.com/";
    private String getRecordingsEndpoint = "api/cdvr/v1/users/";

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity getBook(@PathVariable String id) {

        RestTemplate restTemplate = new RestTemplate();

        String getRecordings = host + getRecordingsEndpoint + id + "/recordings?status=ALL";
        ResponseEntity<String> subscriberRecordings = restTemplate.getForEntity(getRecordings, String.class);


       //JSONObject json = (JSONObject) parser.parse(stringToParse);
        JSONArray subscriberRecordingsJson = new JSONArray(subscriberRecordings.getBody());
        //JSONArray subscriberRecordingsJson = subscriberRecordingsJson.ge;

        for (int i = 0; i < subscriberRecordingsJson.length(); i++)
        {
            JSONObject subscriberRecordingJson = subscriberRecordingsJson.getJSONObject(i);
            restTemplate.delete(host + deleteRecordingsEndpoint + id +"/"+ subscriberRecordingJson.get("key"));

            System.out.println("Deleted recording " + subscriberRecordingJson.get("key") + " id");
        }

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
