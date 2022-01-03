package com.example.schedule;

public class ScheduleClass {

    String teacherName, className, subjectName, section, stream, startTime, endTime, imgUrl, iconUrl;
    int infoImg;

    public ScheduleClass(String teacherName, String className, String subjectName, String section, String stream, String startTime, String endTime, String imgUrl, String iconUrl, int infoImg) {
        this.teacherName = teacherName;
        this.className = className;
        this.subjectName = subjectName;
        this.section = section;
        this.stream = stream;
        this.startTime = startTime;
        this.endTime = endTime;
        this.infoImg = infoImg;
        this.imgUrl = imgUrl;
        this.iconUrl = iconUrl;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getInfoImg() {
        return infoImg;
    }

    public void setInfoImg(int infoImg) {
        this.infoImg = infoImg;
    }
}
