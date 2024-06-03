package com.student.application.student_application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "firstName is required a field")
    //@Length(min=3, max=100, message = "firstName length must be between 3 and 100")
    @Size(min=3, max=100, message = "firstName length must be between 3 and 100" )
    private String firstName;

    @NotBlank(message = "lastName is required a field")
    //@Column(name="last_name", length=100)
    private String lastName;

    @NotBlank(message = "gender is required a field")
    private String gender;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="Invalid Email Address")
    @NotBlank(message = "emailId is required a field")
    @Column(name="email_id", nullable = false, unique = true)
    private String emailId;
    @NotBlank(message = "phoneNumber is required a field")
    @Pattern(regexp = "^[+]{1}(?:[0-9\\-\\(\\)\\/\\.]\\s?){6,15}[0-9]{1}$", message="Invalid phoneNumber")
    private String phoneNumber;

    @Past(message = "Date of birth must be past date")
    //@Future()
    private ZonedDateTime dateOfBirth;

    private Boolean active;

    private String password;

    //@JoinColumn(name = "address_id", referencedColumnName = "id")
    @NotNull(message = "Address is a required field")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @JsonIgnore
    private  Address address;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


    @JsonIgnore
    @OneToMany(mappedBy = "user",  cascade = CascadeType.REMOVE)
    private List<Post> posts;
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User() {
    }



    public User(String firstName, String lastName, String gender, String emailId, String phoneNumber, Integer age, ZonedDateTime dateOfBirth, Boolean active, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.active = active;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ZonedDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(ZonedDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
