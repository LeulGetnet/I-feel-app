package com.example.feelappbackend.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
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
    public Localuser createProfle(@RequestBody Localuser user){
        return accountService.createProfle(user);
    }

    @PostMapping("login/")
    public String logn(@RequestBody loginbody loginbody){
        return accountService.login(loginbody);
    }
    
    @GetMapping("profile")
    public Localuser getMethodName(@AuthenticationPrincipal Localuser user) {
        return accountService.getProfile(user);
    }
    
}