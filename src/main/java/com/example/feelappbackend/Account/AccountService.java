package com.example.feelappbackend.Account;


import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * services
 */
@Service
public class AccountService {

    @Autowired
    private accountRepository accountRepository;
    
   
    private JWTServises jwtServises;

   
    private EncryptionService encryptionService;

    public AccountService(accountRepository userInterface, EncryptionService encryptionService, JWTServises jwtServices){
        this.accountRepository = userInterface;
        this.encryptionService = encryptionService;
        this.jwtServises = jwtServices;
    }


    public List<Localuser> userList(){
        return accountRepository.findAll();
    }

    public Localuser createProfle(@RequestBody RegisterBody RegisterBody) throws Exception{

         Localuser user = new Localuser();

         if(accountRepository.findByEmail(RegisterBody.getEmail()).isPresent() || accountRepository.findByUsername(RegisterBody.getUsername()).isPresent() ){
            throw new Exception("user already exist");
         }

         user.setUsername(RegisterBody.getUsername());
         user.setFirstname(RegisterBody.getFirstname());
         user.setLastname(RegisterBody.getLastname());
        
         user.setPassword(encryptionService.encryptPassword(RegisterBody.getPassword()));
         user.setEmail(RegisterBody.getEmail());
         user.setIsPremium(false);

         accountRepository.save(user);

         return user;

    }

    public String login(@RequestBody LoginBody loginbody){
        Optional<Localuser> user = accountRepository.findByUsername(loginbody.getUsername());
        System.err.println(user.get().getEmail());
        if(user.isPresent() && encryptionService.verifyPassword(loginbody.getPassword(), user.get().getPassword())){
            return jwtServises.generateJWT(user.get());
        }
        else{
            return "error";
        }
    }


    
}




 