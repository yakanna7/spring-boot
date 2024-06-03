package com.student.application.student_application.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class StudentDTO {

    private Long studentId;
    private String name;
    private String gender;
    private String emailId;

}
