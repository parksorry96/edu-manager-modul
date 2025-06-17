package com.bs.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Scanner;

@Configuration
public class ConfigTest {
    @Bean
    Scanner scanner(){
        return new Scanner(System.in);
    }
    @Bean
    Date date(){
        return new Date();
    }
}
