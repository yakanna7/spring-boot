package com.student.application.student_application.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.student.application.student_application.entity.Address;
import com.student.application.student_application.entity.Post;
import jakarta.persistence.Transient;

import java.time.ZonedDateTime;
import java.util.List;

@JsonPropertyOrder({"id", "emailId", "gender","firstName", "lastName",  "phoneNumber", "dateOfBirth", "active"})

public class UserDTO {

    @JsonProperty(value = "userId")
    private long id;

    private String firstName;

    private String lastName;

    private String gender;

    private String emailId;

    private String phoneNumber;

    private ZonedDateTime dateOfBirth;

    private boolean active;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Transient
    private String retypedPassword;

    public Address getAddress() {
        return address;
    }

    private Address address;



    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String gender, String emailId, String phoneNumber, Integer age, ZonedDateTime dateOfBirth, Boolean active, String password , String retypedPassword, Address address) {

        if(!password.equals(retypedPassword)){
            throw new IllegalArgumentException("Password and retypedPassword did not match");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.active = active;
        this.password = password;
        this.retypedPassword = retypedPassword;
        this.address = address;

    }


    public UserDTO(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.gender = userDTO.getGender();
        this.emailId = userDTO.getEmailId();
        this.phoneNumber = userDTO.getPhoneNumber();
        this.dateOfBirth = userDTO.getDateOfBirth();
        this.active = userDTO.getActive();
        this.password = userDTO.getPassword();
        this.retypedPassword = userDTO.getRetypedPassword();
        this.address = userDTO.getAddress();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ZonedDateTime getDateOfBirth() {
        return dateOfBirth;
    }


    public Boolean getActive() {
        return active;
    }

    public String getPassword() {
        return password;
    }

    public long getId( ) {
        return id;
    }


    public String getRetypedPassword() {
        return retypedPassword;
    }


}
