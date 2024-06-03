package com.student.application.student_application.controller;

import com.student.application.student_application.dto.PostDTO;
import com.student.application.student_application.dto.UserDTO;
import com.student.application.student_application.dto.UserData;
import com.student.application.student_application.dto.UserResponse;
import com.student.application.student_application.entity.Address;
import com.student.application.student_application.entity.Post;
import com.student.application.student_application.entity.User;
import com.student.application.student_application.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

 /*   @GetMapping("/{age}")
    public List<User> getUsersByAgeLessThan(@PathVariable Integer age) {
        return userService.getUsersByAgeLessThan(age);
    }*/


    @GetMapping("/age_in")
    public List<User> getUsersByAgeIn(@RequestParam("ages") List<Integer> ageList) {
        return userService.getAllUsersByAgeIn(ageList);
    }

    @GetMapping("/dob_after")
    public List<User> getAllUsersByDateOfBirthAfter(@RequestParam("dateOfBirth") String dateOfBirth) {
        return userService.getAllUsersByDateOfBirthAfter(dateOfBirth);
    }

 /*   @GetMapping("/gender_and_age")
    public List<User> getAllUsersByGenderAndAge(@RequestParam String gender, @RequestParam Integer age) {
        return userService.getAllUsersByGenderOrAgeLessThan(gender, age);
    }*/

    @GetMapping("/gender_and_first_name_oder_by_asc")
    public List<User> getAllCandidatesByGenderOrderByFirstNameAscendingOrder(String gender) {
        return userService.getAllCandidatesByGenderOrderByFirstNameAscendingOrder(gender);
    }

    @GetMapping("/by_email")
    public UserDTO getUserByEmailId(@RequestParam("email") String emailId) {
        return userService.getUserByEmailId(emailId);
    }

    @GetMapping("/posts/by_email")
    public UserDTO getUserPostByEmailId(@RequestParam("email") String emailId) {
        return userService.getUserPostByEmailId(emailId);
    }


    //@GetMapping("/posts/pagination/by_email")
    /*public UserPostDTO getUserPostByEmailIdPagination(@RequestParam("email") String emailId, @RequestParam(defaultValue = "0", required = false ) int pageNo, @RequestParam(defaultValue = "10", required = false) int pageSize) {
       Page<UserPostDTO> page = userService.getUserPostByEmailId(emailId, pageNo, pageSize);
        return userService.getUserPostByEmailId(emailId);
    }*/

    @GetMapping("/gender")
    public UserResponse getAllUsersByGenderOrAge(@RequestParam String gender) {
        return userService.getAllUsersByGender(gender);
    }


    @GetMapping("/sort_by_name")
    public List<User> getAllUsersOrderByFirstName() {
        return userService.getAllUsersOrderByFirstName();
    }

    @GetMapping("/sort_by_age")
    public List<User> getAllUsersOrderByAge() {
        return userService.getAllUsersOrderByGae();
    }

    @GetMapping("/specific/{id}")
    List<Object> getSpecificValues(@PathVariable Long id) {
        return userService.getSpecificValues(id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping
    public Page<User> getAllUsers(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize) {
        return userService.getAllUsers(pageNo, pageSize);
    }

    @PostMapping("/save")
    public void saveUser( @Valid @RequestBody UserDTO userRequestDTO){
        userService.saveUser(userRequestDTO);
    }

    @PostMapping("/save/record")
    public void saveUserData( @Valid @RequestBody UserData userRequest){
        userService.saveUser(userRequest);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable(name="id")  Long userId){
        return userService.findUserById(userId);
    }

    @GetMapping("/record/{id}")
    public UserData getUserByIdAsRecord(@PathVariable(name="id")  Long userId){
        return userService.findUserByIdAsRecord(userId);
    }

    @PostMapping("/save_multiple")
    public void saveMultipleUsers(@NotEmpty(message = "Request should  not be empty") @Valid  @RequestBody List<User> users){
        userService.saveMultipleUsers(users);
    }

    @GetMapping("/address/{id}")
    public Address getAddressById(@PathVariable(name="id")  Long userId){
        return userService.findAddressById(userId);
    }

    @PostMapping("/posts/save/{userId}")
    public void saveUserPost(@PathVariable(name="userId")  Long userId,  @RequestBody Post post){
        userService.savePost(userId, post);
    }


    @GetMapping("/posts/{userId}")
    public List<PostDTO> getPostsByUser(@PathVariable Long userId) {
        return userService.getPostsByUser(userId);
    }

}
