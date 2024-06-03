package com.student.application.student_application.service;

import com.student.application.student_application.dto.StudentCourseDTO;
import com.student.application.student_application.dto.StudentDTO;
import com.student.application.student_application.entity.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void saveStudent(StudentDTO studentDTO);

    Student getStudentById(Long id);

    String updateStudentDetails(Long id, Student student);

    String deleteStudentRecord(Long id);

    String updateStudentEmailId( Long id, String emailId);

    Student getStudentByEmailId(String emailId);

    List<Student> getStudentsByNameStartsWith(String name);

    List<Student> getStudentsByGenderIsNot(String gender);

    List<Student> getStudentsByNameContaining(String infix);

    List<Student> getStudentByEmailIdLike(String likePattern);

    void registerForCourse(Long studentId, Long courseId);

    StudentCourseDTO getStudentCourseDetails(Long studentId);

}

