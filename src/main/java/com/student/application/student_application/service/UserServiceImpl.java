package com.student.application.student_application.service;

import com.student.application.student_application.dto.*;
import com.student.application.student_application.entity.Address;
import com.student.application.student_application.entity.Post;
import com.student.application.student_application.entity.User;
import com.student.application.student_application.exceptions.NoUserFoundException;
import com.student.application.student_application.exceptions.UserAlreadyExistsException;
import com.student.application.student_application.repository.AddressRepository;
import com.student.application.student_application.repository.PostRepository;
import com.student.application.student_application.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public List<User> getUsersByAgeLessThan(Integer age) {
        //return userRepository.findByAgeLessThan(age);
        return null;
    }

    @Override
    public List<User> getAllUsersByAgeIn(List<Integer> ageList) {
        //return userRepository.findByAgeIn(ageList);
        return null;
    }

    @Override
    public List<User> getAllUsersByDateOfBirthAfter(String dateOfBirth) {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateOfBirth, DateTimeFormatter.ISO_DATE_TIME);
        return userRepository.findByDateOfBirthAfter(zonedDateTime);
    }

 /*   @Override
    public List<User> getAllUsersByGenderOrAgeLessThan(String gender, Integer age) {
        return userRepository.findByGenderOrAgeLessThan(gender, age);
    }*/

    @Override
    public List<User> getAllCandidatesByGenderOrderByFirstNameAscendingOrder(String gender) {
        return userRepository.findByGenderOrderByFirstNameAsc(gender);
    }

    @Override
    public UserDTO getUserByEmailId(String emailId) {

        User user = userRepository.findByEmail(emailId);

        if (user != null) {
            return modelMapper.map(user, UserDTO.class);

        } else {
            throw new NoUserFoundException("No user found with email " + emailId);
        }
    }

    @Override
    public UserPostDTO getUserPostByEmailId(String emailId) {

        User user = userRepository.findByEmail(emailId);


        if (user != null) {
            return modelMapper.map(user, UserPostDTO.class);

        } else {
            throw new NoUserFoundException("No user found with email " + emailId);
        }
    }

    @Override
    public UserResponse getAllUsersByGender(String gender) {
        List<User> userList = userRepository.getByGender(gender);
        List<UserDTO> userDtoList = userList.stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();

        return new UserResponse(userDtoList, 200, "SUCCESS");

    }


    @Override
    public List<User> getAllUsersOrderByFirstName() {
        return userRepository.findAllUsers(Sort.by(Sort.Direction.DESC, "firstName"));
    }

    @Override
    public List<User> getAllUsersOrderByGae() {
        return userRepository.findAllUsers(Sort.by(Sort.Direction.ASC, "age"));
    }

    @Override
    public List<Object> getSpecificValues(Long id) {
        return userRepository.getSpecificValues(id);
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoUserFoundException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public Page<User> getAllUsers(Integer pageNo, Integer pageSize) {
        if (pageNo > 0) {
            pageNo = pageNo - 1;
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("gender").and(Sort.by("firstName")));
        return userRepository.getAllUsers(pageable);
    }

    @Override
    public void saveUser(UserDTO userRequestDTO) {

        User user = modelMapper.map(userRequestDTO, User.class);

        User existingUser = userRepository.findByEmail(user.getEmailId());
        if (existingUser != null) {
            throw new UserAlreadyExistsException("User already exists with email id " + user.getEmailId());
        } else {
            userRepository.save(user);
        }
    }


    @Override
    public void saveUser(UserData userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        User existingUser = userRepository.findByEmail(user.getEmailId());
        if (existingUser != null) {
            throw new UserAlreadyExistsException("User already exists with email id " + user.getEmailId());
        } else {
            userRepository.save(user);
        }
    }

    @Override
    public UserDTO findUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return modelMapper.map(user, UserDTO.class);
        } else {
            throw new NoUserFoundException("No user found by id " + userId);
        }
    }


    @Override
    public UserData findUserByIdAsRecord(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new UserData(user);
        } else {
            throw new NoUserFoundException("No user found by id " + userId);
        }
    }

    @Override
    public void saveMultipleUsers(List<User> users) {

     /*   if(users.isEmpty()){
            throw new RuntimeException("Request should not be empty");
        }*/

        List<String> usersEmails = users.stream().map(User::getEmailId).toList(); //

        List<String> existingUsers = userRepository.findByEmailIdIn(usersEmails);

        if (!existingUsers.isEmpty()) {
            throw new UserAlreadyExistsException("User/Users already exists with  email/email Ids " + existingUsers.toString());
        }

   /*     for(User user : users){
             if(userRepository.findByEmail(user.getEmailId()) != null){
                 throw new UserAlreadyExistsException("User already exists with  email " + user.getEmailId());
             }
        }*/

        userRepository.saveAll(users);

    }


    @Override
    public Address findAddressById(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);

        if (optionalAddress.isPresent()) {
            return  optionalAddress.get();
        } else {
            throw new NoUserFoundException("No address found by id " + id);
        }
    }

    @Override
    public void savePost(Long userId, Post post) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        post.setUser(user);
        //user.getPosts().add(post);
        postRepository.save(post);
    }

 @Override
    public List<PostDTO> getPostsByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        List<Post> posts =  postRepository.findByUser(user);

       return posts.stream().map(post -> modelMapper.map(post, PostDTO.class)).toList();

    }

}
