package com.student.application.student_application.repository;

import com.student.application.student_application.entity.Post;
import com.student.application.student_application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository  extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);

}
