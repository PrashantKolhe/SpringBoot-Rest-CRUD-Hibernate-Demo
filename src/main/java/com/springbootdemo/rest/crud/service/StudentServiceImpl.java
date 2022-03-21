package com.springbootdemo.rest.crud.service;

import com.springbootdemo.rest.crud.dao.StudentRepository;
import com.springbootdemo.rest.crud.dto.StudentRequest;
import com.springbootdemo.rest.crud.dto.StudentResponse;
import com.springbootdemo.rest.crud.entity.Student;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private Map<Integer, Student> studentMap = new HashMap<>();

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse create(@NonNull final StudentRequest studentRequest) {
        ModelMapper modelMapper = new ModelMapper();
        Student student = modelMapper.map(studentRequest, Student.class);

        studentRepository.save(student);
        StudentResponse studentResponse = modelMapper.map(student, StudentResponse.class);

        return studentResponse;
    }

    @Override
    public StudentResponse update(@NonNull final StudentRequest studentRequest, @NonNull final int id) {


        Student student = studentRepository.getById(id);

        if (StringUtils.isNotBlank(studentRequest.getFirstName()))
            student.setFirstName(studentRequest.getFirstName());
        if (StringUtils.isNotBlank(studentRequest.getLastName()))
            student.setLastName(studentRequest.getLastName());
        if (StringUtils.isNotBlank(studentRequest.getEmail()))
            student.setEmail(studentRequest.getEmail());

        studentRepository.save(student);

        ModelMapper modelMapper = new ModelMapper();
        StudentResponse studentResponse = modelMapper.map(student, StudentResponse.class);

        return studentResponse;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll(Sort.by("id").descending());
    }

    @Override
    public void delete(@NonNull final int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }
}
