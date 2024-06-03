package com.student.application.student_application.dto;

public class PostDTO {
    Long id;

    String title;

    String description;

    public PostDTO(){}

    public PostDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
