package com.example.schedule.ApiPackage;

public class CreateScheduleResponse{
    public ShowCreateSchedule show;

    public CreateScheduleResponse(ShowCreateSchedule show) {
        this.show = show;
    }

    public ShowCreateSchedule getShow() {
        return show;
    }
}


