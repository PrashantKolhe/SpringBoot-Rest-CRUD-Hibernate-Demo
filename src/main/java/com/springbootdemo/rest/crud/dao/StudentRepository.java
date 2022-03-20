package com.springbootdemo.rest.crud.dao;

import com.springbootdemo.rest.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {

}
