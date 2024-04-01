package com.example.feelappbackend.Services;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.feelappbackend.Repository.accountRepository;
import com.example.feelappbackend.doa.LoginBody;
import com.example.feelappbackend.doa.RegisterBody;
import com.example.feelappbackend.models.Localuser;
/**
 * services
 */
@Service
public class AccountService {

    @Autowired
    private accountRepository accountRepository;
    @Autowired
    private JWTServises jwtServises;
    @Autowired
    private EncryptionService encryptionService;

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




 