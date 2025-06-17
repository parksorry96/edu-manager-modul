package com.bs.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Snack implements InitializingBean {
    private String name;
    private int price;
    private double discount;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("snack객체 생성");
    }
}
