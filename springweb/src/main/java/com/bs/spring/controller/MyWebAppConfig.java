package com.bs.spring.controller;

import com.bs.spring.common.interceptor.BasicInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration //설정클래스를 선언하는 어노테이션 ==springbean-configuration.xml
@EnableWebMvc   // mvc:annotaion-driven 설정과 동일
public class MyWebAppConfig  implements WebMvcConfigurer {
    //화면전환용 매핑메소드 한번에 적용하기

    @Autowired
    BasicInterceptor basicInterceptor;
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/enrollmember.do").setViewName("member/memberEnroll");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(basicInterceptor).addPathPatterns("/loginend.do");
    }
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;


    }
}
