package com.example.schedule;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    ArrayList<ScheduleClass> scheduleClassArrayList;
    Context context;
    private static final String baseUrlForImages = "https://s3.ap-south-1.amazonaws.com/test.files.classroom.digital/";

    public ScheduleAdapter(ArrayList<ScheduleClass> scheduleClassArrayList,Context context) {
        this.scheduleClassArrayList = scheduleClassArrayList;
        this.context  = context;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_card_new, parent, false);
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
        holder.startTime.setText(currentScheduleClass.getStartTime());
        holder.endTime.setText(currentScheduleClass.getEndTime());

        Glide.with(context).load(baseUrlForImages+currentScheduleClass.getImgUrl()).into(holder.teacherImg);
        Utils.fetchSvg(context,baseUrlForImages+currentScheduleClass.getIconUrl(), holder.subIcon);
//        Glide.with(context).load(baseUrlForImages+currentScheduleClass.getIconUrl()).into(holder.subIcon);
//        Picasso.with(context)
//        .load(baseUrlForImages+currentScheduleClass.getIconUrl())
//        .into(holder.subIcon);
//        Picasso.with(context)
//        .load(baseUrlForImages+currentScheduleClass.getImgUrl())
//        .into(holder.teacherImg);

    }

    @Override
    public int getItemCount() {
        return scheduleClassArrayList.size();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {

        TextView teacherName, subjectName, className, section, stream, startTime, endTime;
        ImageView imgInfo, teacherImg, subIcon;


        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);

            teacherName = itemView.findViewById(R.id.profileName);
            subjectName = itemView.findViewById(R.id.txtSubject);
            className = itemView.findViewById(R.id.txtClass);
            section = itemView.findViewById(R.id.section);
            stream = itemView.findViewById(R.id.stream);
            imgInfo = itemView.findViewById(R.id.infoImg);
            startTime = itemView.findViewById(R.id.startTimeText);
            endTime = itemView.findViewById(R.id.endTimeText);
            teacherImg = itemView.findViewById(R.id.imageProfile);
            subIcon = itemView.findViewById(R.id.imgSubject);
        }
    }
}
