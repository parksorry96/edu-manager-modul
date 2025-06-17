package com.bs.spring.demo.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Demo {
    private String devName;
    private int devAge;
    public String devGender;
    private String devEmail;
    private String[] devLang;
    private Date birthDay;
    private Address address;

}
