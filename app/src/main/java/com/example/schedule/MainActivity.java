package com.example.schedule;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schedule.ApiPackage.ApiClient;
import com.example.schedule.ApiPackage.ApiService;
import com.example.schedule.ApiPackage.CancelScheduleResponse;
import com.example.schedule.ApiPackage.Cancelled;
import com.example.schedule.ApiPackage.Completed;
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
import com.example.schedule.ApiPackage.Scheduled;
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
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<ScheduleClass> scheduleClassArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recViewForCard);
        scheduleClassArrayList = new ArrayList<>();

        apiInIt();
        getScheduleHome();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void apiInIt() {

        retrofit = ApiClient.getRetrofit();
        apiService = ApiClient.getLoginService();
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
                GetScheduleHomePageResponse getScheduleHomePageResponse = response.body();
                ArrayList<Ongoing> ongoingArrayList = (ArrayList<Ongoing>) getScheduleHomePageResponse.schedules.getOngoing();
                for (Ongoing o
                :ongoingArrayList) {
                    Log.i("Teacher Name",o.getTeacher().getName());
                    scheduleClassArrayList.add(new ScheduleClass(o.getTeacher().getName(),
                            o.getStandards().get(0).getStd(),
                            o.getSubject().getName(),
                            o.getStandards().get(0).getSection(),
                            o.getStandards().get(0).getStream(),o.getStartTime(),o.getEndTime(),R.drawable.lab_broadcast));
                }
                layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                adapter = new ScheduleAdapter(scheduleClassArrayList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GetScheduleHomePageResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error :(", Toast.LENGTH_SHORT).show();

            }
        });
    }
}