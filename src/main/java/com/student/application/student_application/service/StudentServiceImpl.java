package com.student.application.student_application.service;

import com.student.application.student_application.dto.StudentCourseDTO;
import com.student.application.student_application.dto.StudentDTO;
import com.student.application.student_application.entity.Course;
import com.student.application.student_application.entity.Student;
import com.student.application.student_application.repository.CourseRepository;
import com.student.application.student_application.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository ;

    @Autowired
    private CourseRepository    courseRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
         Optional<Student> optionalStudent = studentRepository.findById(id);
         if(optionalStudent.isPresent()){
             return optionalStudent.get();
         }else{
             return null;
         }
    }

    @Override
    public String updateStudentDetails(Long id, Student studentRequest) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student existingStudent = optionalStudent.get();

            if(studentRequest.getName() != null && !existingStudent.getName().equals(studentRequest.getName())){
                existingStudent.setName(studentRequest.getName());
            }

            if(studentRequest.getGender() !=null && !existingStudent.getGender().equals(studentRequest.getGender())){
                existingStudent.setGender(studentRequest.getGender());
            }

            if(studentRequest.getCourses() !=null && !existingStudent.getCourses().equals(studentRequest.getCourses())){
                existingStudent.setCourses(studentRequest.getCourses());
            }

            if(studentRequest.getEmailId() !=null && !existingStudent.getEmailId().equals(studentRequest.getEmailId())){
                existingStudent.setEmailId(studentRequest.getEmailId());
            }


            studentRepository.save(existingStudent);
            return "Updated successfully";

        }else{
            return "No student exists with id " + id;
        }
    }

    @Override
    public String deleteStudentRecord(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return "Student record deleted successfully.";
        }else
        {
            return "No student found with id " + id;
        }
    }

    @Override
    public String updateStudentEmailId(Long id, String emailId) {

        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            if(emailId != null && emailId != "" && !student.getEmailId().equals(emailId)) {
                student.setEmailId(emailId);
                studentRepository.save(student);
                return "Student record update successfully.";
            }else{
                return "Unable to update since email is empty or same.";
            }
        }else
        {
            return "Update failed since no student found with id " + id;
        }
    }

    @Override
    public Student getStudentByEmailId(String emailId) {
        return studentRepository.findByEmailId(emailId);
    }

    @Override
    public List<Student> getStudentsByNameStartsWith(String name) {
       return  studentRepository.findByNameStartingWith(name);
    }

    @Override
    public  List<Student> getStudentsByGenderIsNot(String gender){
        return studentRepository.findByGenderIsNot(gender);
    }

    @Override
    public List<Student> getStudentsByNameContaining(String name) {
        return studentRepository.findByNameContaining(name);
    }

    @Override
    public List<Student> getStudentByEmailIdLike(String likePattern) {
        return studentRepository.findByEmailIdLike(likePattern);
    }

    @Override
    public void registerForCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        Course course =  courseRepository.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Course not found"));
       if( student.getCourses().contains(course))
       {
             throw new IllegalArgumentException("Student already registered for this course");
       }
        student.getCourses().add(course);
        studentRepository.save(student);
    }


    @Override
    public StudentCourseDTO getStudentCourseDetails(Long studentId){
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student not found"));        StudentCourseDTO studentCourseDTO = new StudentCourseDTO();
        return modelMapper.map(student, StudentCourseDTO.class);
    }
}
