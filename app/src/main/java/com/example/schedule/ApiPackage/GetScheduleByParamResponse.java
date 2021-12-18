package com.example.schedule.ApiPackage;

import java.util.List;

public class GetScheduleByParamResponse {

        public List<Object> scheduled;
        public List<Object> ongoing;
        public List<Object> completed;
        public List<Object> cancelled;

    public GetScheduleByParamResponse(List<Object> scheduled, List<Object> ongoing, List<Object> completed, List<Object> cancelled) {
        this.scheduled = scheduled;
        this.ongoing = ongoing;
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public List<Object> getScheduled() {
        return scheduled;
    }

    public List<Object> getOngoing() {
        return ongoing;
    }

    public List<Object> getCompleted() {
        return completed;
    }

    public List<Object> getCancelled() {
        return cancelled;
    }
}

