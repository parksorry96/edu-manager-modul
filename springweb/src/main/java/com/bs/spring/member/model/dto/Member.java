package com.bs.spring.member.model.dto;

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
public class Member {

    @NotEmpty(message = "이름은 반드시 작성하세요!")
    @Size(min=4, message="4글자 이상 입력하세요")
    private String userId;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,}$", message = "숫자,영대문자 특수문자 포함 8글자이상")
    private String password;
    @Pattern(regexp ="^[가-힣a-zA-Z]{2,}$", message = "이름은 2글자 이상 사용하세요")
    private String userName;
    private String gender;
    @Min(value = 20, message = "20살이상만 가능합니다")
    @Max(value = 100, message = "100살이하만 가능합니다.")
    private int age;
    @NotEmpty(message="이메일은 반드시 입력하세요")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;
    private String phone;
    private String address;
    private String[] hobby;
    private Date enrollDate;



}
