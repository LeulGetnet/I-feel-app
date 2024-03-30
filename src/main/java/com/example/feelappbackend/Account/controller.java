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
import java.util.List;


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
    @GetMapping("listusers/")
    public List<Localuser> userList() {
        return accountService.userList();
    }
    

    @PostMapping("createProfile/")
    public String createProfle(@RequestBody RegisterBody newuser) {
        try{
            accountService.createProfle(newuser);
            //return ResponseEntity.ok().build();
            return "success";

        } catch(Exception e){
        //    return ResponseEntity.status(HttpStatus.CONFLICT).build();
            return "error" + e;
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
    
}