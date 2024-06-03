package com.student.application.student_application.repository;

import com.student.application.student_application.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long >{
    public Student findByEmailId(String emailId);
    public Student findByName(String name);
    List<Student> findByGenderIsNot(String name);
    public List<Student> findByNameStartingWith(String name);

    List<Student> findByNameEndingWith(String suffix);

    List<Student> findByNameContaining(String infix);

    List<Student> findByEmailIdLike(String likePattern);



}
