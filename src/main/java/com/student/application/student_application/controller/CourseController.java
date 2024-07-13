package com.student.application.student_application.controller;


import com.student.application.student_application.dto.CourseDTO;
import com.student.application.student_application.dto.CourseStudentDTO;
import com.student.application.student_application.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping("/save")
    public void saveCourse(@RequestBody CourseDTO courseDto){
        courseService.saveCourse(courseDto);
    }

    @GetMapping("/{courseId}")
    public CourseDTO getCourseById(@PathVariable Long courseId){
         return  courseService.getCourseById(courseId);
    }

    @GetMapping("/students/{courseId}")
    public CourseStudentDTO getCourseAndStudentsById(@PathVariable Long courseId){
        return  courseService.getCourseAndStudentsById(courseId);
    }


}
