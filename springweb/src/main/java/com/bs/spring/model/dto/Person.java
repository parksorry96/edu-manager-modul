package com.bs.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private String name;
    private int age;
    private String mbti;
    private int salary;
    private Animal animal;

    public void  initTest(){
        System.out.println(this+"생성함");
    }

    public void destroyTest(){
        System.out.println(this+"소멸함");
    }
}

