package com.springbootdemo.rest.crud.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentRequest {
    String first_name;
    String last_name;
    String email;

}
