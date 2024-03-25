package com.example.feelappbackend.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.ipc.http.HttpSender.Response;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * controller
 */


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class controller {

    @Autowired
    private final AccountService accountService;

    public controller(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("createProfile/")
    public ResponseEntity createProfle(@RequestBody RegisterBody newuser) {
        try{
            accountService.createProfle(newuser);
            return ResponseEntity.ok().build();

        } catch(Exception e){
           return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        
    }

    @PostMapping("login/")
    public String logn(@RequestBody LoginBody loginbody){
        return accountService.login(loginbody);
    }
    
    @GetMapping("profile")
    public Localuser getMethodName(@AuthenticationPrincipal Localuser user) {
        return accountService.getProfile(user);
    }
    
}