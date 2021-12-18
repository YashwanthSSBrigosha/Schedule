package com.example.schedule.ApiPackage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @Headers({
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjM2LCJwaG9uZSI6Iis5MTkwMzY0NTc2NjQiLCJ1cmwiOiJ0ZXN0LnRoZWNsYXNzcm9vbS5iaXoiLCJvcmdJZCI6IjRjYjI1MDlkLTcwZjUtNDM1ZS04NzkyLWQyNDkzNzc0M2I1MyIsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE5MDM2NDU3NjY0NjM2Nzk1OTU3NTQtNThmOC00OWIyLTgwOGYtMWU3ZmNhNjI1Y2ZjIiwiZGV2aWNlTG9naW5Db2RlIjpudWxsLCJpYXQiOjE2Mzk4MDQ0OTh9.8G237wFJg8CrLzlr416RmCE5O2F0vZc7beOfIzNAJVw",
            "orgurl:test.theclassroom.biz"})
    @GET("/api/schedule-new/")
    Call<GetScheduleHomePageResponse> scheduleHomeCall();

    @Headers({
            "orgurl:test.theclassroom.biz",
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjM2LCJwaG9uZSI6Iis5MTkwMzY0NTc2NjQiLCJ1cmwiOiJ0ZXN0LnRoZWNsYXNzcm9vbS5iaXoiLCJvcmdJZCI6IjRjYjI1MDlkLTcwZjUtNDM1ZS04NzkyLWQyNDkzNzc0M2I1MyIsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE5MDM2NDU3NjY0NjM2Nzk1OTU3NTQtNThmOC00OWIyLTgwOGYtMWU3ZmNhNjI1Y2ZjIiwiZGV2aWNlTG9naW5Db2RlIjpudWxsLCJpYXQiOjE2Mzk4MDQ0OTh9.8G237wFJg8CrLzlr416RmCE5O2F0vZc7beOfIzNAJVw",
    })

    @POST("/api/schedule-new/")
    Call<CreateScheduleResponse> createScheduleCall(@Body CreateScheduleRequest createScheduleRequest);

    @Headers({
            "orgurl:test.theclassroom.biz",
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjM2LCJwaG9uZSI6Iis5MTkwMzY0NTc2NjQiLCJ1cmwiOiJ0ZXN0LnRoZWNsYXNzcm9vbS5iaXoiLCJvcmdJZCI6IjRjYjI1MDlkLTcwZjUtNDM1ZS04NzkyLWQyNDkzNzc0M2I1MyIsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE5MDM2NDU3NjY0NjM2Nzk1OTU3NTQtNThmOC00OWIyLTgwOGYtMWU3ZmNhNjI1Y2ZjIiwiZGV2aWNlTG9naW5Db2RlIjpudWxsLCJpYXQiOjE2Mzk4MDQ0OTh9.8G237wFJg8CrLzlr416RmCE5O2F0vZc7beOfIzNAJVw",
    })

    @POST("/api/schedule-new/")
    Call<UpdateScheduleResponse> updateScheduleCall(@Body UpdateScheduleRequest updateScheduleRequest);

    @Headers({
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjM2LCJwaG9uZSI6Iis5MTkwMzY0NTc2NjQiLCJ1cmwiOiJ0ZXN0LnRoZWNsYXNzcm9vbS5iaXoiLCJvcmdJZCI6IjRjYjI1MDlkLTcwZjUtNDM1ZS04NzkyLWQyNDkzNzc0M2I1MyIsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE5MDM2NDU3NjY0NjM2Nzk1OTU3NTQtNThmOC00OWIyLTgwOGYtMWU3ZmNhNjI1Y2ZjIiwiZGV2aWNlTG9naW5Db2RlIjpudWxsLCJpYXQiOjE2Mzk4MDQ0OTh9.8G237wFJg8CrLzlr416RmCE5O2F0vZc7beOfIzNAJVw",
            "orgurl:test.theclassroom.biz"})
    @GET("/api/schedule-new/filter-schedule?date=2021-11-18")
    Call<GetScheduleByParamResponse> scheduleByParamCall();


    @Headers({
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjM2LCJwaG9uZSI6Iis5MTkwMzY0NTc2NjQiLCJ1cmwiOiJ0ZXN0LnRoZWNsYXNzcm9vbS5iaXoiLCJvcmdJZCI6IjRjYjI1MDlkLTcwZjUtNDM1ZS04NzkyLWQyNDkzNzc0M2I1MyIsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE5MDM2NDU3NjY0NjM2Nzk1OTU3NTQtNThmOC00OWIyLTgwOGYtMWU3ZmNhNjI1Y2ZjIiwiZGV2aWNlTG9naW5Db2RlIjpudWxsLCJpYXQiOjE2Mzk4MDQ0OTh9.8G237wFJg8CrLzlr416RmCE5O2F0vZc7beOfIzNAJVw",
            "orgurl:test.theclassroom.biz"})
    @GET("/api/schedule-new/teacher-list")
    Call<List<GetTeacherListResponse>> teacherResListCall();

    @Headers({
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjM2LCJwaG9uZSI6Iis5MTkwMzY0NTc2NjQiLCJ1cmwiOiJ0ZXN0LnRoZWNsYXNzcm9vbS5iaXoiLCJvcmdJZCI6IjRjYjI1MDlkLTcwZjUtNDM1ZS04NzkyLWQyNDkzNzc0M2I1MyIsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE5MDM2NDU3NjY0NjM2Nzk1OTU3NTQtNThmOC00OWIyLTgwOGYtMWU3ZmNhNjI1Y2ZjIiwiZGV2aWNlTG9naW5Db2RlIjpudWxsLCJpYXQiOjE2Mzk4MDQ0OTh9.8G237wFJg8CrLzlr416RmCE5O2F0vZc7beOfIzNAJVw",
            "orgurl:test.theclassroom.biz"})
    @GET("/api/schedule-new/timetable?view=web&classId=44")
    Call<List<GetTimetableResponse>> timtableListCall();

    @Headers({
            "orgurl:test.theclassroom.biz",
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjM2LCJwaG9uZSI6Iis5MTkwMzY0NTc2NjQiLCJ1cmwiOiJ0ZXN0LnRoZWNsYXNzcm9vbS5iaXoiLCJvcmdJZCI6IjRjYjI1MDlkLTcwZjUtNDM1ZS04NzkyLWQyNDkzNzc0M2I1MyIsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE5MDM2NDU3NjY0NjM2Nzk1OTU3NTQtNThmOC00OWIyLTgwOGYtMWU3ZmNhNjI1Y2ZjIiwiZGV2aWNlTG9naW5Db2RlIjpudWxsLCJpYXQiOjE2Mzk4MDQ0OTh9.8G237wFJg8CrLzlr416RmCE5O2F0vZc7beOfIzNAJVw",
    })

    @PATCH("/api/schedule-new/edit-occurance")
    Call<EditOccurenceResponse> editOccrCall(@Body EditOccurenceRequest editOccurenceRequest);


    @Headers({
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjM2LCJwaG9uZSI6Iis5MTkwMzY0NTc2NjQiLCJ1cmwiOiJ0ZXN0LnRoZWNsYXNzcm9vbS5iaXoiLCJvcmdJZCI6IjRjYjI1MDlkLTcwZjUtNDM1ZS04NzkyLWQyNDkzNzc0M2I1MyIsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE5MDM2NDU3NjY0NjM2Nzk1OTU3NTQtNThmOC00OWIyLTgwOGYtMWU3ZmNhNjI1Y2ZjIiwiZGV2aWNlTG9naW5Db2RlIjpudWxsLCJpYXQiOjE2Mzk4MDQ0OTh9.8G237wFJg8CrLzlr416RmCE5O2F0vZc7beOfIzNAJVw",
            "orgurl:test.theclassroom.biz"})
    @DELETE("/api/schedule-new/")
    Call<DeleteScheduleResponse> deleteScheduleCall(@Query("scheduleId") int scheduleId);


    @Headers({
            "orgurl:test.theclassroom.biz",
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjM2LCJwaG9uZSI6Iis5MTkwMzY0NTc2NjQiLCJ1cmwiOiJ0ZXN0LnRoZWNsYXNzcm9vbS5iaXoiLCJvcmdJZCI6IjRjYjI1MDlkLTcwZjUtNDM1ZS04NzkyLWQyNDkzNzc0M2I1MyIsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE5MDM2NDU3NjY0NjM2Nzk1OTU3NTQtNThmOC00OWIyLTgwOGYtMWU3ZmNhNjI1Y2ZjIiwiZGV2aWNlTG9naW5Db2RlIjpudWxsLCJpYXQiOjE2Mzk4MDQ0OTh9.8G237wFJg8CrLzlr416RmCE5O2F0vZc7beOfIzNAJVw",
    })

    @PATCH("/api/schedule-new/cancel?id=293")
    Call<CancelScheduleResponse> cancelScheduleCall(@Query("id") int id);


    @Headers({
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjM2LCJwaG9uZSI6Iis5MTkwMzY0NTc2NjQiLCJ1cmwiOiJ0ZXN0LnRoZWNsYXNzcm9vbS5iaXoiLCJvcmdJZCI6IjRjYjI1MDlkLTcwZjUtNDM1ZS04NzkyLWQyNDkzNzc0M2I1MyIsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE5MDM2NDU3NjY0NjM2Nzk1OTU3NTQtNThmOC00OWIyLTgwOGYtMWU3ZmNhNjI1Y2ZjIiwiZGV2aWNlTG9naW5Db2RlIjpudWxsLCJpYXQiOjE2Mzk4MDQ0OTh9.8G237wFJg8CrLzlr416RmCE5O2F0vZc7beOfIzNAJVw",
            "orgurl:test.theclassroom.biz"})
    @GET("/api/schedule-new/summary-data?type=week")
    Call<List<GetSummaryDataResponse>> summaryDataCall();

    @Headers({
            "orgurl:test.theclassroom.biz",
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjM2LCJwaG9uZSI6Iis5MTkwMzY0NTc2NjQiLCJ1cmwiOiJ0ZXN0LnRoZWNsYXNzcm9vbS5iaXoiLCJvcmdJZCI6IjRjYjI1MDlkLTcwZjUtNDM1ZS04NzkyLWQyNDkzNzc0M2I1MyIsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE5MDM2NDU3NjY0NjM2Nzk1OTU3NTQtNThmOC00OWIyLTgwOGYtMWU3ZmNhNjI1Y2ZjIiwiZGV2aWNlTG9naW5Db2RlIjpudWxsLCJpYXQiOjE2Mzk4MDQ0OTh9.8G237wFJg8CrLzlr416RmCE5O2F0vZc7beOfIzNAJVw",
    })

    @PATCH("/api/schedule-new/join-class?id=385")
    Call<JoinClassResponse> joinClassCall();

}
