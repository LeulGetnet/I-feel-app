package com.example.feelappbackend.Account;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


/**
 * accountRepository
 */
public interface accountRepository extends JpaRepository<Localuser, Long>{

    public Optional<Localuser> findByUsername(String username);

    
} 