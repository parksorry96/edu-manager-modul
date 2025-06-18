package com.bs.spring.config;

import com.bs.spring.common.interceptor.BasicInterceptor;
import com.bs.spring.common.propertyData.PropertyData;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

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

    @Bean
    DataSource dataSource(@Autowired PropertyData data){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(data.getDbUrl());
        return dataSource;
    }

    //ExceptionHandler 등록하기
    @Bean
    public HandlerExceptionResolver handlerExceptionResolver() {
        Properties prop=new Properties();
//        prop.setProperty(IllegalArgumentException.class.getName(), "common/error/error1");
        prop.setProperty(NullPointerException.class.getName(), "common/error/error2");
//        prop.setProperty(MyException.class.getName(), "common/error/error3");
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        exceptionResolver.setExceptionMappings(prop);

        return exceptionResolver;
    }

    //국제화 메세지처리하기
    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
