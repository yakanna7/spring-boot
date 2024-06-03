package com.student.application.student_application.service;

import com.student.application.student_application.dto.CourseDTO;
import com.student.application.student_application.dto.CourseStudentDTO;
import com.student.application.student_application.entity.Course;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


public interface CourseService {

     void saveCourse(CourseDTO courseDTO);
    CourseDTO getCourseById(Long id);

    CourseStudentDTO getCourseAndStudentsById( Long courseId);

    //String updateCourseDetails(Long id, Course courseRequest);

    //String deleteCourseById(Long id);
}
