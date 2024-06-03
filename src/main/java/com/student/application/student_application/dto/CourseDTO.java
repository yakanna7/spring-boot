package com.student.application.student_application.dto;

public class CourseDTO {
    private Long courseId;
    private String courseName;

    public CourseDTO(){}

    public CourseDTO(Long courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}
