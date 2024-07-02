package com.student.application.student_application.controller;

import com.student.application.student_application.dto.StudentCourseDTO;
import com.student.application.student_application.dto.StudentDTO;
import com.student.application.student_application.entity.Student;
import com.student.application.student_application.entity.User;
import com.student.application.student_application.service.AccountService;
import com.student.application.student_application.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@Slf4j
public class StudentController {


    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
     public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping(value = "/get-by-email")
    public Student getStudentByEmailId(@RequestParam String emailId){
         return studentService.getStudentByEmailId(emailId);
    }

    @GetMapping("/get-by-name-starts-with")
    public List<Student> getStudentsByNameStartsWith(@RequestParam String name){
        return studentService.getStudentsByNameStartsWith(name);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        log.info("Logger Info message");
        log.debug("Logger Debug message");
        log.trace("Trace Message");
        log.error("Error message");
        log.warn("Warn message");
        return studentService.getAllStudents();
    }


    @GetMapping(value = "/gender-not")
    List<Student> getStudentsByGenderIsNot(@RequestParam("gnd")  String gender){
         return studentService.getStudentsByGenderIsNot(gender);
    }


    @GetMapping(value = "/name-contains")
    List<Student> getStudentsByNameContaining(@RequestParam("name") String name){
        return studentService.getStudentsByNameContaining(name);
    }


    @GetMapping(value = "/email-like")
    public List<Student> getStudentByEmailIdLike(@RequestParam("pattern")  String likePattern) {
        return studentService.getStudentByEmailIdLike(likePattern);
    }


    @PostMapping("/save")
    public void saveStudent(@RequestBody StudentDTO studentDTO) {
         studentService.saveStudent(studentDTO);
    }

    @PutMapping("/update/{id}")
    public String updateStudentDetails(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudentDetails(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentRecord(@PathVariable  Long id){
        return studentService.deleteStudentRecord(id);
    }

    @PatchMapping("update/{id}")
    public String updateStudentEmailId(@PathVariable Long id , @RequestParam String emailId){
          return studentService.updateStudentEmailId(id, emailId);
    }
    @PutMapping("register/{studentId}/{courseId}")
   public  void registerForCourse(@PathVariable  Long studentId, @PathVariable Long courseId){
        studentService.registerForCourse(studentId, courseId);
    }


    @GetMapping("courses/{studentId}")
    public StudentCourseDTO getStudentCourseDetails(@PathVariable Long studentId){
        return studentService.getStudentCourseDetails(studentId);
    }

}
