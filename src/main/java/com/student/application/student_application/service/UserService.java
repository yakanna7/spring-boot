package com.student.application.student_application.service;

import com.student.application.student_application.dto.*;
import com.student.application.student_application.entity.Address;
import com.student.application.student_application.entity.Post;
import com.student.application.student_application.entity.User;
import com.student.application.student_application.exceptions.NoUserFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    List<User> getUsersByAgeLessThan(Integer age);
    List<User> getAllUsersByAgeIn(List<Integer> ageList);
    List<User> getAllUsersByDateOfBirthAfter(String dateTime);
   // List<User> getAllUsersByGenderOrAgeLessThan(String gender, Integer age);
    List<User> getAllCandidatesByGenderOrderByFirstNameAscendingOrder(String gender);
    UserDTO getUserByEmailId(String emailId);
    UserResponse getAllUsersByGender(String gender);

    List<User> getAllUsersOrderByFirstName();
    List<User> getAllUsersOrderByGae();
    List<Object> getSpecificValues(Long id);

    void deleteById(Long id);
    Page<User> getAllUsers(Integer pageNo, Integer pageSize);

    void saveUser(UserDTO userRequestDTO);
    void saveUser(UserData userRequest);

    UserDTO findUserById(Long userId) throws NoUserFoundException;

    UserData findUserByIdAsRecord(Long userId) throws NoUserFoundException;

    void saveMultipleUsers(List<User> users);

    Address findAddressById(Long id);

    void savePost(Long userId, Post post);

    List<PostDTO> getPostsByUser(Long userId);

    UserPostDTO getUserPostByEmailId(String emailId);
}
