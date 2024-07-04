package com.student.application.student_application.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Entity
@Table(name = "my_products")
@AllArgsConstructor
public class MyProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    private String category;
    private String productName;
    private Double cost;
    private String color;
    private String model;
    private Double rating;

    public MyProduct(){

    }

}
