package com.student.application.student_application.filters;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductFilter {
    private String category;
    private String name;
    private Double minCost;
    private Double maxCost;
    private String color;
    private String model;
    private Double rating;
}
