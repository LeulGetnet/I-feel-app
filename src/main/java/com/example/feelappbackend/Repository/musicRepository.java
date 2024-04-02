package com.example.feelappbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feelappbackend.models.MusicModel;

public interface musicRepository extends JpaRepository<MusicModel, Long>{
    MusicModel findByIntensityAndMoodAndLength(String string, String string2, String string3);
}
