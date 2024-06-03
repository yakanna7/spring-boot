package com.student.application.student_application.repository;

import com.student.application.student_application.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /*List<User> findByAgeLessThan(Integer age);*/
    //List<User> findByAgeIn(List<Integer> ageList);
    @Query(value="SELECT u.emailId  FROM User u WHERE emailId IN :usersEmailIds")
    List<String> findByEmailIdIn(List<String> usersEmailIds);

    List<User> findByDateOfBirthAfter(ZonedDateTime dateTime);

   // List<User> findByGenderOrAgeLessThan(String gender, Integer age);

    List<User> findByGenderOrderByFirstNameAsc(String name);

    @Query(value="SELECT u FROM User  u WHERE u.emailId = :email" )
    User findByEmail(@Param("email") String emailId);

    @Query(value="SELECT * FROM Users  u WHERE u.gender=?1" ,  nativeQuery = true )
    List<User> getByGender(String gender);

/*    @Query(value="SELECT * FROM Users  u WHERE u.gender1=?1 OR u.age1>=?2 OR first_name1 = ?3" , nativeQuery = true )
    List<User> getByGenderOrAgeOrFirstName(String gender, Integer age, String firstName);*/

    @Query(value = "SELECT u FROM User u")
    List<User> findAllUsers(Sort sort);

    @Query(value = "SELECT u.firstName, u.lastName FROM User u where u.id =:id")
    List<Object> getSpecificValues(Long id);


    @Modifying
    @Query(value ="DELETE from User u WHERE u.id =:id")
    void deleteById(Long id);

    @Query(value = "SELECT  u FROM User u")
    Page<User> getAllUsers(Pageable pageable);

}
