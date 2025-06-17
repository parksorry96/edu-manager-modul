package com.bs.spring.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Animal {
    private String name;
    private int age;
    private String gender;
    private double weight;


}
