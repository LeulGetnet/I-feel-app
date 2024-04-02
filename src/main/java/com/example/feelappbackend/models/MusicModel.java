package com.example.feelappbackend.models;

import java.util.List;

import com.example.feelappbackend.doa.Intensity;
import com.example.feelappbackend.doa.Mood;
import com.example.feelappbackend.doa.elength;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "MusicModel")
public class MusicModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "intensity", nullable = false)
    @Enumerated(EnumType.STRING)
    private Intensity intensity;

    @Column(name = "mood", nullable = false)
    @Enumerated(EnumType.STRING)
    private Mood mood;

    @Column(name = "length", nullable = false)
    @Enumerated(EnumType.STRING)
    private elength length;

    @OneToMany(mappedBy = "musicmodel", cascade = CascadeType.ALL)
    private List<AudioModel> audios;

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }
    public Intensity getIntensity() {
        return intensity;
    }
    public void setLength(elength length) {
        this.length = length;
    }
    public elength getLength() {
        return length;
    }
    public void setMood(Mood mood) {
        this.mood = mood;
    }
    public Mood getMood() {
        return mood;
    }

    public List<AudioModel> getAudios() {
        return audios;
    }
    public void setAudios(List<AudioModel> audios) {
        this.audios = audios;
    }

}



