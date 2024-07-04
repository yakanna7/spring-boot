package com.student.application.student_application.repository;

import com.student.application.student_application.entity.MyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository

public interface MyProductRepository extends JpaRepository<MyProduct, Long>, JpaSpecificationExecutor<MyProduct> {

}
