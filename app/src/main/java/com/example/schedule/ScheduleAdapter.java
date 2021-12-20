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

    ArrayList<ScheduleClass> scheduleClassArrayList;

    public ScheduleAdapter(ArrayList<ScheduleClass> scheduleClassArrayList) {
        this.scheduleClassArrayList = scheduleClassArrayList;
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
        ScheduleClass currentScheduleClass = scheduleClassArrayList.get(position);

        holder.imgInfo.setImageResource(currentScheduleClass.getInfoImg());
        holder.subjectName.setText(currentScheduleClass.getSubjectName());
        holder.className.setText(currentScheduleClass.getClassName());
        holder.section.setText(currentScheduleClass.getSection());
        holder.stream.setText(currentScheduleClass.getStream());
        holder.teacherName.setText(currentScheduleClass.getTeacherName());

    }

    @Override
    public int getItemCount() {
        return scheduleClassArrayList.size();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {

        TextView teacherName,subjectName,className,section,stream;
        ImageView imgInfo;


        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);

            teacherName = itemView.findViewById(R.id.profileName);
            subjectName = itemView.findViewById(R.id.txtSubject);
            className = itemView.findViewById(R.id.txtClass);
            section = itemView.findViewById(R.id.section);
            stream = itemView.findViewById(R.id.stream);
            imgInfo = itemView.findViewById(R.id.infoImg);
        }
    }
}
