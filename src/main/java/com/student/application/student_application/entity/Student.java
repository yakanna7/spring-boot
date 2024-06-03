package com.student.application.student_application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;



@NoArgsConstructor
@Data
@Entity
@Table(name = "student")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long studentId;

    private  String name;

   private String gender;

 private String emailId;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"))

  private Set<Course> courses;

}
