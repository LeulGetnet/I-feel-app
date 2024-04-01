package com.example.feelappbackend.models;


import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.exceptions.StreamingNotifiable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "audio")
public class AudioModel {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "MusicModel_id", nullable = false)
    private MusicModel musicmodel;
    private String fileName;
    private String fileType;
    private long size;
    private Boolean isPremium;
    private String uniqueFileName;
   

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
    public void setMusicmodel(MusicModel musicmodel) {
        this.musicmodel = musicmodel;
    }
    public MusicModel getMusicmodel() {
        return musicmodel;
    }
    public void setSize(long size) {
        this.size = size;
    }
    public long getSize() {
        return size;
    }
    public void setUniqueFileName(String uniqueFileName) {
        this.uniqueFileName = uniqueFileName;
    }
    public String getUniqueFileName() {
        return uniqueFileName;
    }
    public Boolean getIsPremium() {
        return isPremium;
    }
    public void setIsPremium(Boolean isPremium) {
        this.isPremium = isPremium;
    }
 


}
