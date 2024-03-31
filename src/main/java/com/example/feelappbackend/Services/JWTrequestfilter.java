package com.example.feelappbackend.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.example.feelappbackend.Repository.accountRepository;
import com.example.feelappbackend.models.Localuser;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTrequestfilter extends OncePerRequestFilter{

   
    private accountRepository accountRepository;
    @Autowired
    private JWTServises jwtServises;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        final String tokenheader = request.getHeader("Authorization");
        if(tokenheader != null && tokenheader.startsWith("Bearer ")){
            String token = tokenheader.substring(7);
            try{

                String username = jwtServises.getUsername(token);
                Optional<Localuser> user = accountRepository.findByUsername(username);
                if (user.isPresent()){

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.get(), null, new ArrayList());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                }

            }
            catch(JWTDecodeException e){
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.getWriter().write("{\"error\": \"Token expired\"}");
                return;
            }
           

        }


       filterChain.doFilter(request, response);
    }

    
    
}
