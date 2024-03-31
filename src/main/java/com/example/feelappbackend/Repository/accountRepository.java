package com.example.feelappbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feelappbackend.models.Localuser;

import java.util.Optional;




/**
 * accountRepository
 */
public interface accountRepository extends JpaRepository<Localuser, Long>{

    public Optional<Localuser> findByUsername(String username);
    public Optional<Localuser> findByEmail(String email);
   

    
} 