package com.example.feelappbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.example.feelappbackend.Repository.accountRepository;
import com.example.feelappbackend.Services.AccountService;
import com.example.feelappbackend.Services.MusicService;
import com.example.feelappbackend.doa.LoginBody;
import com.example.feelappbackend.doa.RegisterBody;
import com.example.feelappbackend.doa.audioBody;
import com.example.feelappbackend.models.AudioModel;
import com.example.feelappbackend.models.Localuser;

import io.micrometer.core.ipc.http.HttpSender.Response;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;



@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class controller {

    @Autowired
    accountRepository accountRepository;

    @Autowired
    MusicService musicService;

    @Autowired
    private final AccountService accountService;

   

    public controller(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("createProfile/")
    public Localuser createProfle(@RequestBody RegisterBody newuser) throws Exception {
        try{
            
            //return ResponseEntity.ok().build();
            return accountService.createProfle(newuser);

        } catch(Exception e){
        //    return ResponseEntity.status(HttpStatus.CONFLICT).build();
            throw new Exception("exception " + e);
        }
        }

    @PostMapping("login/")
    public String logn(@RequestBody LoginBody loginbody){
        return accountService.login(loginbody);
    }
    
    @GetMapping("profile/")
    public Localuser getProfle(@AuthenticationPrincipal Localuser user) {
        return user;
    }

    @GetMapping("users/")
    public List<Localuser> users() {
        return accountRepository.findAll();
    }
    
    @PostMapping("addmusic/")
    public AudioModel addMusic(@RequestBody audioBody audio) throws IllegalArgumentException{
        try {
            return musicService.addMusic(audio);
        } catch (IllegalArgumentException e) {
            // TODO: handle exception
            throw new IllegalArgumentException(e);
        }
        
    }

  
    
}