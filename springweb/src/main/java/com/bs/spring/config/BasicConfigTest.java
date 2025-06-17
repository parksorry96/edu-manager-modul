package com.bs.spring.config;

import com.bs.spring.model.dto.Animal;
import com.bs.spring.model.dto.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BasicConfigTest {

    @Bean
    Animal animal4(){
        return Animal.builder()
                .name("육지거북이")
                .age(1)
                .gender("남")
                .build();
    }
    @Bean("p2")   //beanname설정
    @Primary    //이놈이 최우선임. -> 두개 써지면 어떻게 되는지 나중에 테스트해보기
    Person person2(Animal animal4){
        return Person.builder()
                .name("유병승")
                .age(19)
                .mbti("ENTJ")
                .salary(20)
                .animal(animal4)
                .build();
    }

}
