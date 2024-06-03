package com.student.application.student_application.dto;


import java.util.Set;

public class CourseStudentDTO extends CourseDTO {
    Set<StudentDTO> students;

    public Set<StudentDTO> getStudents(){
        return students;
    }
}
