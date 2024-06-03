package com.student.application.student_application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "street is a required field")
    private String street;

    @NotBlank(message = " city is a required field")
    private String city;

    @NotBlank(message = "state is a required field")
    private String state;

    @NotBlank(message = "country is a required field")
    private String country;

    @NotBlank(message = "zipcode is a required field")
    private String zipcode;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
   @OneToOne(mappedBy = "address")
   @JsonIgnore
   private User user;

    public Address() {
    }

    public Address(long id, String street, String city, String state, String country, String zipcode, User user) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
