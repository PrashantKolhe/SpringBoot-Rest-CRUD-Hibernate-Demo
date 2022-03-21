package com.springbootdemo.rest.crud.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentRequest {
    String firstName;
    String lastName;
    String email;

}
