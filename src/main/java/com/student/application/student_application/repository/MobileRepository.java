package com.student.application.student_application.repository;

import com.student.application.student_application.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository  extends JpaRepository<Mobile,Long>  {
}
