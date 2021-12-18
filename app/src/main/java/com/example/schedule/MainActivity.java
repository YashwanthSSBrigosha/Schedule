package com.example.schedule;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schedule.ApiPackage.ApiClient;
import com.example.schedule.ApiPackage.ApiService;
import com.example.schedule.ApiPackage.CancelScheduleResponse;
import com.example.schedule.ApiPackage.CreateScheduleRequest;
import com.example.schedule.ApiPackage.CreateScheduleResponse;
import com.example.schedule.ApiPackage.DeleteScheduleResponse;
import com.example.schedule.ApiPackage.EditOccurenceRequest;
import com.example.schedule.ApiPackage.EditOccurenceResponse;
import com.example.schedule.ApiPackage.GetScheduleByParamResponse;
import com.example.schedule.ApiPackage.GetScheduleHomePageResponse;
import com.example.schedule.ApiPackage.GetSummaryDataResponse;
import com.example.schedule.ApiPackage.GetTeacherListResponse;
import com.example.schedule.ApiPackage.GetTimetableResponse;
import com.example.schedule.ApiPackage.JoinClassResponse;
import com.example.schedule.ApiPackage.Ongoing;
import com.example.schedule.ApiPackage.UpdateScheduleRequest;
import com.example.schedule.ApiPackage.UpdateScheduleResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    ApiService apiService;
    GetScheduleHomePageResponse getScheduleHomePageResponse;
    CreateScheduleRequest createScheduleRequest;
    CreateScheduleResponse createScheduleResponse;
    UpdateScheduleRequest updateScheduleRequest;
    UpdateScheduleResponse updateScheduleResponse;
    GetScheduleByParamResponse getScheduleByParamResponse;
    List<GetTeacherListResponse> getTeacherListResponse;
    List<GetTimetableResponse> getTimetableResponse;
    EditOccurenceRequest editOccurenceRequest;
    EditOccurenceResponse editOccurenceResponse;
    DeleteScheduleResponse deleteScheduleResponse;
    CancelScheduleResponse cancelScheduleResponse;
    List<GetSummaryDataResponse> getSummaryDataResponse;
    JoinClassResponse joinClassResponse;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    ArrayList<Schedule> scheduleArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCard();
        buildRecyclerView();
        apiInIt();
        getScheduleHome();
//        createSchedule();
//        updateSchedule();
//        getScheduleParam();
//        getTeacherList();
//        getTimetableList();
//        editOccurence();
//        deleteSchedule();
//        cancelSchedule();
//        getSummaryData();
//        joinClass();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void createCard() {

        scheduleArrayList = new ArrayList<>();
        scheduleArrayList.add(new Schedule("Botany", "XII - A: Commerce", "Joel E. Rice", R.drawable.lab_offline));
        scheduleArrayList.add(new Schedule("Accountancy", "XI - A: Commerce", "Dorothy H. Allie", R.drawable.lab_broadcast));
        scheduleArrayList.add(new Schedule("Social Science", "XI - C", "Ariene J. Neely", R.drawable.lab_zoom40));
        scheduleArrayList.add(new Schedule("Social Science", "XI - C", "Dorothy h. Allie", R.drawable.lab_conference));
    }

    public void buildRecyclerView() {
        recyclerView = findViewById(R.id.recViewForCard);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ScheduleAdapter(scheduleArrayList);
        recyclerView.setAdapter(adapter);
    }

    public void apiInIt() {

        retrofit = ApiClient.getRetrofit();
        apiService = ApiClient.getLoginService();
    }

    public void joinClass() {
        Call<JoinClassResponse> call = apiService.joinClassCall();
        call.enqueue(new Callback<JoinClassResponse>() {
            @Override
            public void onResponse(Call<JoinClassResponse> call, Response<JoinClassResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                joinClassResponse = response.body();
                Toast.makeText(getApplicationContext(),joinClassResponse.getShow().message, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<JoinClassResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error :(", Toast.LENGTH_LONG).show();

            }
        });
    }


    public void getSummaryData() {
        Call<List<GetSummaryDataResponse>> call = apiService.summaryDataCall();
        call.enqueue(new Callback<List<GetSummaryDataResponse>>() {
            @Override
            public void onResponse(Call<List<GetSummaryDataResponse>> call, Response<List<GetSummaryDataResponse>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                getSummaryDataResponse=response.body();
                GetSummaryDataResponse response1 = getSummaryDataResponse.get(4);
                Toast.makeText(getApplicationContext(), response1.date, Toast.LENGTH_LONG).show();            }

            @Override
            public void onFailure(Call<List<GetSummaryDataResponse>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error get summary", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void getTeacherList() {
        Call<List<GetTeacherListResponse>> call = apiService.teacherResListCall();
        call.enqueue(new Callback<List<GetTeacherListResponse>>() {
            @Override
            public void onResponse(Call<List<GetTeacherListResponse>> call, Response<List<GetTeacherListResponse>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
                }
                getTeacherListResponse = response.body();
                GetTeacherListResponse response1 = getTeacherListResponse.get(0);
                Toast.makeText(getApplicationContext(), response1.name, Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<List<GetTeacherListResponse>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error :(", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void updateSchedule() {
        List<Integer> classID = new ArrayList<>();
        List<String> weekDays = new ArrayList<>();
        classID.add(44);
        weekDays.add("tuesday");
        updateScheduleRequest = new UpdateScheduleRequest(115, 10, 33, classID, weekDays, "22:00", "23:00", "Broadcast", "2021-11-17", "2021-11-17");
        Call<UpdateScheduleResponse> call = apiService.updateScheduleCall(updateScheduleRequest);
        call.enqueue(new Callback<UpdateScheduleResponse>() {
            @Override
            public void onResponse(Call<UpdateScheduleResponse> call, Response<UpdateScheduleResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                updateScheduleResponse = response.body();
                Toast.makeText(getApplicationContext(), updateScheduleResponse.getShow().message, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UpdateScheduleResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error :(", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void cancelSchedule() {
        Call<CancelScheduleResponse> call = apiService.cancelScheduleCall(293);
        call.enqueue(new Callback<CancelScheduleResponse>() {
            @Override
            public void onResponse(Call<CancelScheduleResponse> call, Response<CancelScheduleResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                cancelScheduleResponse = response.body();
                Toast.makeText(getApplicationContext(), cancelScheduleResponse.show.message, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<CancelScheduleResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error :(", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void deleteSchedule() {
        Call<DeleteScheduleResponse> call = apiService.deleteScheduleCall(115);
        call.enqueue(new Callback<DeleteScheduleResponse>() {
            @Override
            public void onResponse(Call<DeleteScheduleResponse> call, Response<DeleteScheduleResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                deleteScheduleResponse = response.body();
                Toast.makeText(getApplicationContext(), deleteScheduleResponse.getShow().message, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<DeleteScheduleResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error delete schedule:(", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void editOccurence() {
        List<Integer> classID = new ArrayList<>();

        classID.add(44);
        classID.add(95);


        editOccurenceRequest = new EditOccurenceRequest(63,"04:00","05:00",194,7,"Conference",classID);
        Call<EditOccurenceResponse> call = apiService.editOccrCall(editOccurenceRequest);
        call.enqueue(new Callback<EditOccurenceResponse>() {
            @Override
            public void onResponse(Call<EditOccurenceResponse> call, Response<EditOccurenceResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                editOccurenceResponse = response.body();
                Toast.makeText(getApplicationContext(), editOccurenceResponse.show.message, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<EditOccurenceResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error :(", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void getTimetableList() {

        Call<List<GetTimetableResponse>> call = apiService.timtableListCall();
        call.enqueue(new Callback<List<GetTimetableResponse>>() {
            @Override
            public void onResponse(Call<List<GetTimetableResponse>> call, Response<List<GetTimetableResponse>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
                }
                getTimetableResponse = response.body();
                GetTimetableResponse response1 = getTimetableResponse.get(0);
                Toast.makeText(getApplicationContext(), response1.time, Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<List<GetTimetableResponse>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error :(", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void getScheduleParam() {

        Call<GetScheduleByParamResponse> call = apiService.scheduleByParamCall();
        call.enqueue(new Callback<GetScheduleByParamResponse>() {
            @Override
            public void onResponse(Call<GetScheduleByParamResponse> call, Response<GetScheduleByParamResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                getScheduleByParamResponse = response.body();
                Toast.makeText(getApplicationContext(), getScheduleByParamResponse.scheduled.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<GetScheduleByParamResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error Failure", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void createSchedule() {
        List<Integer> classID = new ArrayList<>();
        List<String> weekDays = new ArrayList<>();
        classID.add(95);
        weekDays.add("tuesday");
        weekDays.add("wednesday");
        weekDays.add("thursday");
        createScheduleRequest = new CreateScheduleRequest(335, 115, classID, weekDays, "22:00", "23:00", "Broadcast", "2022-01-16", "2022-02-16");
        Call<CreateScheduleResponse> call = apiService.createScheduleCall(createScheduleRequest);
        call.enqueue(new Callback<CreateScheduleResponse>() {
            @Override
            public void onResponse(Call<CreateScheduleResponse> call, Response<CreateScheduleResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                createScheduleResponse = response.body();
                Toast.makeText(getApplicationContext(), createScheduleResponse.show.message, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<CreateScheduleResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error :(", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void getScheduleHome() {

        Call<GetScheduleHomePageResponse> call = apiService.scheduleHomeCall();
        call.enqueue(new Callback<GetScheduleHomePageResponse>() {
            @Override
            public void onResponse(Call<GetScheduleHomePageResponse> call, Response<GetScheduleHomePageResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                getScheduleHomePageResponse = response.body();

                //ongoingList.add(getScheduleHomePageResponse.schedules.ongoing.get(1));
                //Toast.makeText(getApplicationContext(),getScheduleHomePageResponse.schedules.completed.get(0).teacher.getName(), Toast.LENGTH_LONG).show();
                Log.i("inside ongoing", String.valueOf(getScheduleHomePageResponse.schedules.completed.size()));
            }

            @Override
            public void onFailure(Call<GetScheduleHomePageResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error Failure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}