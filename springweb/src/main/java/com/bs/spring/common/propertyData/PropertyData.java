package com.bs.spring.common.propertyData;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Component
@PropertySource("classpath:myresources.properties")
public class PropertyData {
    @Value("${app.name}")
    private String appName;
    @Value("${dbUrl}")
    private String dbUrl;
    @Value("${data.students}")
    private String students;
//    @Value("${user}")
//    private String user;
//    @Value("${pw}")
//    private String pw;
//
}
