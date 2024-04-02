package com.example.feelappbackend.doa;

public class RegisterBody {

    private String username, firstname, lastname, email, password;
    

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
}