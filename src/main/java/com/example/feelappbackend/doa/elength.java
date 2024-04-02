package com.example.feelappbackend.doa;


public enum elength{
    quick,Short,medium,Lng, overnight;

    public static elength fromString(String length){
        switch (length.toLowerCase()) {
            case "quick":
                return quick;
            case "short":
                return Short;
            case "medium":
                return medium;
            case "long":
                return Lng;
            case "overnight":
                return overnight;
        
            default:
                throw new IllegalArgumentException("illegal length argument");
                
        }
    }


}
