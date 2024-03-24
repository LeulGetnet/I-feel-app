package com.example.feelappbackend.Music;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MusicModel")
public class MusicMOdel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "intensity", nullable = false)
    Intensity intensity;
    @Column(name = "mood", nullable = false)
    Mood mood;
    @Column(name = "length", nullable = false)
    length length;

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
    public void setLength(length length) {
        this.length = length;
    }
    public length getLength() {
        return length;
    }
    public void setMood(Mood mood) {
        this.mood = mood;
    }
    public Mood getMood() {
        return mood;
    }

}

enum Intensity{calm,balanced,strong}
enum Mood{sleep,rest,reboot,launch}
enum length{quick,Short,medium,Lng, overnight}
