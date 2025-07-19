package com.edumanager.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * EduManager 메인 애플리케이션 클래스
 *
 * @EnableJpaRepositories - JPA Repository 활성화 (PostgreSQL용)
 * @EnableMongoRepositories - MongoDB Repository 활성화
 * @EntityScan - JPA 엔티티 스캔 패키지 지정
 */
@SpringBootApplication(scanBasePackages = "com.edumanager")
@EnableJpaRepositories(basePackages = {
        "com.edumanager.domain.user.repository",      // User 도메인 JPA Repository
        "com.edumanager.domain.student.repository",   // Student 도메인 JPA Repository
        "com.edumanager.infrastructure.database.jpa"  // 인프라 JPA Repository
})
@EnableMongoRepositories(basePackages = {
        "com.edumanager.infrastructure.database.mongodb"  // MongoDB Repository
})
@EntityScan(basePackages = {
        "com.edumanager.domain.user.entity",         // User 도메인 엔티티
        "com.edumanager.domain.student.entity"       // Student 도메인 엔티티
})
public class EduManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduManagerApplication.class, args);
    }
}