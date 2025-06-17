package com.bs.spring.controller;

import com.bs.spring.model.dto.Animal;
import com.bs.spring.model.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BasicController {


    /* 등록된 springbean 의존성 주입하기 */
    //어노테이션을 이용해서 주입
    //@Autowired를 이용
    // 필드선언부, 생성자, setter메소드에서 사용이 가능함
        //의존성 주입을 받을 때 필드명과 beanname이 일치하면 일치하는 spring bean을 가져와 주입함.
        //필드명과 beanname이 일치하지 않을 때는 type을 일치하는 spring bean을 주입함
            //springbean이 한개만 등록이 되어있어야한다.(기본)
            //여러개 등록되어 있을 때는 추가 옵션 어노테이션을 사용해서 설정할 수 있다.
            //@Qualifier("beanname") 이용

    @Autowired
    private Animal animal;

    @Autowired
    private Animal animal2;

    @Autowired
    @Qualifier("animal3")
    private Animal a1;

    @Autowired(required = false)  //필수값
    private Person p;

    @Autowired
    private Person person2;

    @Autowired
    private List<Animal> animalList;

    @RequestMapping("/")
    public String index(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        session.setAttribute("lunch","부대찌개");
        Cookie c = new Cookie("saveId","admin");
        c.setPath("/");
        c.setMaxAge(60*60*24);
        response.addCookie(c);
        System.out.println("Animal bean 가져오기"+animal);
        System.out.println("Animal2 bean 가져오기"+animal2);
        System.out.println("Animal3 bean 가져오기"+a1);
        System.out.println("Person bean 가져오기"+p);
        System.out.println("Person2 bean 가져오기"+person2);
        System.out.println("=== list 의존성 주입===");
        animalList.forEach(System.out::println);


        return "index";
    }

}
