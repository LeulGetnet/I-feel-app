package com.example.feelappbackend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feelappbackend.models.AudioModel;


public interface audioRepository extends JpaRepository<AudioModel, Long>{
    
}
