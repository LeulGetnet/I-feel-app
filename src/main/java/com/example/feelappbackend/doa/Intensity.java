package com.example.feelappbackend.doa;
public enum Intensity{
    calm,balanced,strong;
    public static  Intensity fromString(String intensity){
        switch (intensity.toLowerCase()) {
            case "calm":
                return calm;
            case "balanced":
                return balanced;
            case "strong":
                return strong;
    
            default:
                throw new IllegalArgumentException("illegal Intensity Argument");
        }
    }

}

 
