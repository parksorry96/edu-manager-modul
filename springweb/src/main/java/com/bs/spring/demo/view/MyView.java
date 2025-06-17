package com.bs.spring.demo.view;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class MyView implements View {
    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        for(String key : model.keySet()){
            System.out.println(key+":"+model.get(key));
        }
        response.sendRedirect(request.getContextPath());
    }
}
