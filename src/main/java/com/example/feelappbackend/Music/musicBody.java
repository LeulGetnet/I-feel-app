package com.example.feelappbackend.Music;



public class musicBody {
   
    private String intensity;
   
    private String mood;
   
    private length length;
    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }
    public String getIntensity() {
        return intensity;
    }
    public void setLength(length length) {
        this.length = length;
    }
    public length getLength() {
        return length;
    }
    public void setMood(String mood) {
        this.mood = mood;
    }
    public String getMood() {
        return mood;
    }
}
