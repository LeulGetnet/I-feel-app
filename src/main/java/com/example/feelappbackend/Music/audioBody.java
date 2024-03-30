package com.example.feelappbackend.Music;

public class audioBody {
    private musicBody musicmodel;
    private String fileName;
    private String fileType;
    private long size;
    private Boolean isPremium;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public String getFileType() {
        return fileType;
    }
    public void setIsPremium(Boolean isPremium) {
        this.isPremium = isPremium;
    }
    public Boolean getIsPremium() {
        return isPremium;
    }
    public void setMusicmodel(musicBody musicmodel) {
        this.musicmodel = musicmodel;
    }
    public musicBody getMusicmodel() {
        return musicmodel;
    }
    public void setSize(long size) {
        this.size = size;
    }
    public long getSize() {
        return size;
    }
}
