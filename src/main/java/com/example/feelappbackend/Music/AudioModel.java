package com.example.feelappbackend.Music;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AudioModel {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private MusicMOdel musicmodel;
    private String fileName;
    private String fileType;
    private long size;

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setMusicmodel(MusicMOdel musicmodel) {
        this.musicmodel = musicmodel;
    }
    public MusicMOdel getMusicmodel() {
        return musicmodel;
    }
    public void setSize(long size) {
        this.size = size;
    }
    public long getSize() {
        return size;
    }


}
