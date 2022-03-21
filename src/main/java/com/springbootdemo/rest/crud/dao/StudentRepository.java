package com.springbootdemo.rest.crud.dao;

import com.springbootdemo.rest.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByFirstName(String firstName);

}
