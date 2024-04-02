package com.example.feelappbackend.doa;

public enum Mood{
    
    sleep,rest,reboot,launch;
    public static Mood fromString(String mood){
        switch (mood.toLowerCase()) {
            case "sleep":
                
                return sleep;
            case "rest":
                return rest;
            case "reboot":
                return reboot;
            case "launch":
                return launch;
            default:
                throw new IllegalArgumentException("illegal mood argument");
        }
    }
}