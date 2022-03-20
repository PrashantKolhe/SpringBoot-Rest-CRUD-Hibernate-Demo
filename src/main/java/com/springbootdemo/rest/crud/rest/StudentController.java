package com.springbootdemo.rest.crud.rest;

import com.springbootdemo.rest.crud.dto.StudentRequest;
import com.springbootdemo.rest.crud.service.StudentService;
import com.springbootdemo.rest.crud.entity.Student;
import com.springbootdemo.rest.crud.dto.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("/")
    public List<Student> getAll(){
        return studentService.getAll();
    }


    @PostMapping("/")
    public StudentResponse create(@RequestBody StudentRequest studentRequest){
        return studentService.create(studentRequest);

    }


    @PutMapping("/{id}")
    public StudentResponse update(@RequestBody StudentRequest studentRequest, @PathVariable("id") int id){
        return studentService.update(studentRequest,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        //delete person
        studentService.delete(id);

    }

}
