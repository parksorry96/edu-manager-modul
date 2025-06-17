package com.bs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        // ApplicationContext를 이용해서  spring-bean으로 등록된 객체 가져오기
        // 1. xml을 이용해서 bean등록하기 -> spring-bean configuration 파일

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        String[] beanNames = context.getBeanDefinitionNames();

        Arrays.stream(beanNames).forEach(System.out::println);
        //등록된 spring-bean 가져오기
        //getBean()메소드를 이용
        Object o = context.getBean("p");
        System.out.println(o);
        TestClass tc = context.getBean("p", TestClass.class);
        System.out.println(tc);
        //bean으로 등록된 객체는  sington패턴으로 생성 -> 객체가 1개임

        tc.setName("유병승");
        System.out.println(tc);
        System.out.println(o);
        TestClass tc2 = context.getBean("p2", TestClass.class);
        System.out.println(tc2);

        //어노테이션으로 bean등록하기
        System.out.println("===어노테이션으로 등록한 bean 불러오기===");
        context = new AnnotationConfigApplicationContext("com.bs.test");
        beanNames = context.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(System.out::println);

        AnnoBeanTest abt = context.getBean("annoBeanTest", AnnoBeanTest.class);
        System.out.println(abt);
        abt.setHeight(180.5);
        context.getBean(TestClass.class).setName("점심시간");
        abt.test();

    }
}
