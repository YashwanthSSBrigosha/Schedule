package com.example.schedule;

public class Schedule {

    String subject,classAndBranch,profileName;
    int infoImage;

    public Schedule(String subject, String classAndBranch, String profileName, int infoImage) {
        this.subject = subject;
        this.classAndBranch = classAndBranch;
        this.profileName = profileName;
        this.infoImage = infoImage;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassAndBranch() {
        return classAndBranch;
    }

    public void setClassAndBranch(String classAndBranch) {
        this.classAndBranch = classAndBranch;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public int getInfoImage() {
        return infoImage;
    }

    public void setInfoImage(int infoImage) {
        this.infoImage = infoImage;
    }
}
