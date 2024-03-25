package com.example.feelappbackend.Account;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import jakarta.annotation.PostConstruct;

@Lazy
@Service
public class JWTServises {
    
    @Value("${jwt.algorithm.key}")
    public String algorithmkey;
    
    @Value("${jwt.issuer}")
    public String issuer;
    @Value("${jwt.expiryInSecond}")
    public int expiryInSecond;

    public Algorithm algorithm;

    private static final String USERNAME_KEY = "USERNAME";

    @PostConstruct
    public void postConstruct() {
        algorithm = Algorithm.HMAC256(algorithmkey);
    }

    public String generateJWT(Localuser user) {
    return JWT.create()
        .withClaim(USERNAME_KEY, user.getUsername())
        .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * expiryInSecond)))
        .withIssuer(issuer)
        .sign(algorithm);
    }

    public String getUsername(String token){
    return JWT.decode(token).getClaim(USERNAME_KEY).asString();
    }


}
