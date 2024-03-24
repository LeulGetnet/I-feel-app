package com.example.feelappbackend.Account;


import java.util.Optional;
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

    public Localuser createProfle(@RequestBody Localuser localuser){

         Localuser user = new Localuser();

         user.setUsername(localuser.getUsername());
         user.setFirstname(localuser.getFirstname());
         user.setLastname(localuser.getLastname());
         user.setAdress(localuser.getAdress());
         user.setPassword(encryptionService.encryptPassword(localuser.getPassword()));
         user.setEmail(localuser.getEmail());

         return user;

    }

    public String login(@RequestBody loginbody loginbody){
        Optional<Localuser> user = accountRepository.findByUsername(loginbody.getUsername());
        if(user.isPresent() && encryptionService.verifyPassword(loginbody.getPassword(), user.get().getPassword())){
            return jwtServises.generateJWT(user.get());
        }
        else{
            return "error";
        }
    }

    public Localuser getProfile(@AuthenticationPrincipal Localuser user){
        return user;
    }

    
}

class loginbody{
    private String username, password;
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }public void setUsername(String username) {
        this.username = username;
    }public String getUsername() {
        return username;
    }

}