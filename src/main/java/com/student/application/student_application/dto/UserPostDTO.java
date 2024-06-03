package com.student.application.student_application.dto;

import com.student.application.student_application.entity.Post;

import java.util.List;

public class UserPostDTO extends UserDTO {

    private List<Post> posts;

    public UserPostDTO(){
        super();
    }
    public UserPostDTO(UserDTO userDTO, List<Post> posts) {
        super(userDTO);
        this.posts = posts;
    }

   public List<Post> getPosts(){
         return posts;
    }
}
