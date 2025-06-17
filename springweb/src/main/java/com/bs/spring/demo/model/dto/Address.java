package com.bs.spring.demo.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String zipCode;
    private String sido;
    private String gungu;
    private String dong;
}
