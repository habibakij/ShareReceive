package com.example.shareapprcv.Model;

public class DataModel {
    private String email, currentTime;

    public DataModel(String email, String currentTime) {
        this.email = email;
        this.currentTime = currentTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
