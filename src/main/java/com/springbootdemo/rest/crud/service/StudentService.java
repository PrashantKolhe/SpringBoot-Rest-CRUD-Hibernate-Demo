package com.springbootdemo.rest.crud.service;


import com.springbootdemo.rest.crud.entity.Student;
import com.springbootdemo.rest.crud.dto.StudentRequest;
import com.springbootdemo.rest.crud.dto.StudentResponse;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Map;

public interface StudentService {

    public StudentResponse create(@NonNull final StudentRequest studentRequest);
    public StudentResponse update(@NonNull final StudentRequest studentRequest, @NonNull final  int id);

    public List<Student> getAll();
    public void delete(  @NonNull final int id);

    }
