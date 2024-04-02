package com.example.feelappbackend.doa;

public class musicBody {
   
    private String intensity;
   
    private String mood;
   
    private String length;
    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }
    public String getIntensity() {
        return intensity;
    }
    public void setLength(String length) {
        this.length = length;
    }
    public String getLength() {
        return length;
    }
    public void setMood(String mood) {
        this.mood = mood;
    }
    public String getMood() {
        return mood;
    }
}
