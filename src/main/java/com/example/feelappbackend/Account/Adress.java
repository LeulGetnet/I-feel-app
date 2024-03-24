package com.example.feelappbackend.Account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column( name="id", nullable = false)
    private long id;

    @Column( name="adressLine1", nullable = false)
    private String adressLine1;

    @Column( name="adressLine2")
    private String adressLine2;

    @Column(name= "city")
    private String city;

    @Column(name = "country")
    private String country;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Localuser user;

    public String getAdressLine1() {
        return adressLine1;
    }
    public void setAdressLine1(String adressLine1) {
        this.adressLine1 = adressLine1;
    }
    public String getAdressLine2() {
        return adressLine2;
    }
    public void setAdressLine2(String adressLine2) {
        this.adressLine2 = adressLine2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Localuser getUser() {
        return user;
    }
    public void setUser(Localuser user) {
        this.user = user;
    }


    
}
