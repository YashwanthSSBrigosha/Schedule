package com.example.schedule.ApiPackage;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */
public class ShowCreateSchedule {
    public String type;
    public String message;

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
