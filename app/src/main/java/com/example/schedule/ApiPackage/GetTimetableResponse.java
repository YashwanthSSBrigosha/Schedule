package com.example.schedule.ApiPackage;

public class GetTimetableResponse {
    public Sunday sunday;
    public Monday monday;
    public Tuesday tuesday;
    public Wednesday wednesday;
    public Thursday thursday;
    public Friday friday;
    public Saturday saturday;
    public String time;

    public GetTimetableResponse(Sunday sunday, Monday monday, Tuesday tuesday, Wednesday wednesday, Thursday thursday, Friday friday, Saturday saturday, String time) {
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.time = time;
    }

    public Sunday getSunday() {
        return sunday;
    }

    public Monday getMonday() {
        return monday;
    }

    public Tuesday getTuesday() {
        return tuesday;
    }

    public Wednesday getWednesday() {
        return wednesday;
    }

    public Thursday getThursday() {
        return thursday;
    }

    public Friday getFriday() {
        return friday;
    }

    public Saturday getSaturday() {
        return saturday;
    }

    public String getTime() {
        return time;
    }
}

