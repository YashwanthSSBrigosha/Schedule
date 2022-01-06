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
import com.example.schedule.ApiPackage.Completed;
import com.example.schedule.ApiPackage.GetScheduleHomePageResponse;
import com.example.schedule.ApiPackage.Ongoing;
import com.example.schedule.ApiPackage.Schedule;
import com.example.schedule.ApiPackage.Scheduled;

import java.util.ArrayList;

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
                    Toast.makeText(getApplicationContext(), String.valueOf(response.code()), Toast.LENGTH_LONG).show();
                    return;
                }
                GetScheduleHomePageResponse getScheduleHomePageResponse = response.body();
                ArrayList<Scheduled> scheduledArrayList = (ArrayList<Scheduled>) getScheduleHomePageResponse.schedules.getScheduled();
                for (Scheduled s
                        : scheduledArrayList) {
                    scheduleClassArrayList.add(new ScheduleClass(s.getTeacher().getName(),
                            s.getStandards().get(0).getStd(),
                            s.getSubject().getName(),
                            s.getStandards().get(0).getSection(),
                            s.getStandards().get(0).getStream(),
                            s.getStartTime().substring(0,s.getStartTime().length()-3),
                            s.getEndTime().substring(0,s.getEndTime().length()-3),
                            s.getTeacher().getImage(),
                            s.getSubject().getIcon(),
                            R.drawable.lab_broadcast));
                }
                layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                adapter = new ScheduleAdapter(scheduleClassArrayList,MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GetScheduleHomePageResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error :(", Toast.LENGTH_SHORT).show();

            }
        });
    }
}