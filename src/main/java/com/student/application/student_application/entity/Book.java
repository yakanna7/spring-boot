package com.student.application.student_application.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "books")
@Data
public class Book extends Product {
    String author;
    String publisher;
    Integer noOfPages;
}
