
package com.student.application.student_application;

import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static  void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Ravi", 21);
        map.put("Vijay", 22);
        map.put("Gopi", 20);
        map.put("Naveen", 19);

      Map<String, Integer> orderedMap =  map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

      orderedMap.forEach((k,v) -> System.out.println(k + " " + v));


    }
}

/*
@RestController
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
@Eitity
@Table
@RequestBody
@RequestParam

@Transactioanl

@Repository

@Autowired

@Service

@Component


@ControllerAdvice

@ExceptionHandler

@ResponseEntity

@EnableWebSecurity

@EnableBatchProcessing


 */



