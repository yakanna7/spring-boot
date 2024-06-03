package com.student.application.student_application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.student.application.student_application.entity.User;

import java.time.ZonedDateTime;

public record UserData(
        long id,
        String firstName,
        String lastName,
        String gender,
        String emailId,
        String phoneNumber,
        Integer age,
        ZonedDateTime dateOfBirth,
        Boolean active,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        String password
) {

    public UserData (User user){
        this(user.getId(),  user.getFirstName(), user.getLastName(), user.getGender(), user.getEmailId(), user.getPhoneNumber(), 0, user.getDateOfBirth(), user.getActive(), user.getPassword());
    }

}
