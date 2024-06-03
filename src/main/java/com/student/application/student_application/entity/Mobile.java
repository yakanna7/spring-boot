package com.student.application.student_application.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "mobiles")
@Data
public class Mobile extends Product {
    String brand;
    String model;
    String os;
    String ram;
}
