package com.student.application.student_application.service;

import com.student.application.student_application.dto.CourseDTO;
import com.student.application.student_application.dto.CourseStudentDTO;
import com.student.application.student_application.entity.Course;
import com.student.application.student_application.repository.CourseRepository;
import com.student.application.student_application.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    //@Autowired
   // private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCourse(CourseDTO courseDTO) {
        Course course = modelMapper.map(courseDTO, Course.class);
        courseRepository.save(course);
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course  = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Course not found"));;
        return modelMapper.map(course, CourseDTO.class);
    }

    @Override
    public CourseStudentDTO getCourseAndStudentsById(Long courseId) {
        Course course =  courseRepository.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Course not found"));
        return modelMapper.map(course, CourseStudentDTO.class);
    }


}
