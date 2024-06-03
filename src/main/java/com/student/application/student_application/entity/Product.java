package com.student.application.student_application.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String name;
    private String description;
    private Double price;
}
