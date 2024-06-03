package com.student.application.student_application.dto;

import lombok.Getter;

import java.util.Set;

@Getter

public class StudentCourseDTO extends StudentDTO {
    private Set<CourseDTO> courses;
}
