package com.bs.spring.demo.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Demo {
    @NotEmpty(message = "이름은 반드시 작성하세요!")
    @Pattern(regexp="[가-힣]{2,}",message = "두글자 이상 한글로 작성하세요")
    private String devName;
    @Min(value=10,message = "10살이상만 가능합니다")
    private int devAge;
    public String devGender;
    @NotEmpty(message="이메일을 반드시 작성하세요")
    @Email(message = "이메일형식이 아닙니다.")
    private String devEmail;
    private String[] devLang;
    @Past(message = "미래에서 왔구나")
    private Date birthDay;

    private Address address;

}
