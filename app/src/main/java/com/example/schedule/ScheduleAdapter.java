package com.example.schedule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    ArrayList<Schedule> scheduleArrayList;

    public ScheduleAdapter(ArrayList<Schedule> scheduleArrayList) {
        this.scheduleArrayList = scheduleArrayList;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_card, parent, false);
        ScheduleViewHolder svh = new ScheduleViewHolder(view);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        Schedule currentSchedule = scheduleArrayList.get(position);

        holder.subject.setText(currentSchedule.getSubject());
        holder.classAndBranch.setText(currentSchedule.getClassAndBranch());
        holder.name.setText(currentSchedule.getProfileName());
        holder.imgInfo.setImageResource(currentSchedule.getInfoImage());

    }

    @Override
    public int getItemCount() {
        return scheduleArrayList.size();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {

        TextView subject, classAndBranch, name;
        ImageView imgInfo;


        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);

            subject = itemView.findViewById(R.id.txtSubject);
            classAndBranch = itemView.findViewById(R.id.txtClass);
            name = itemView.findViewById(R.id.profileName);
            imgInfo = itemView.findViewById(R.id.infoImg);
        }
    }
}
