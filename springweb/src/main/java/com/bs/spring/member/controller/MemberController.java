package com.bs.spring.member.controller;

import com.bs.spring.member.model.dto.Member;
import com.bs.spring.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"loginMember"})
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //
    @PostMapping("/loginend.do")
    public String login(String userId, String pw, Model model) {

        Member member = memberService.searchById(userId);
        if (member == null) {
            model.addAttribute("msg", "로그인실패");
            model.addAttribute("loc", "/");

            return "common/msg";
        }
        if (passwordEncoder.matches(pw, member.getPassword())) {
            //sendRedirect로 응답할 때는 redirect: 주소
            //redirect주소는 : controller mapping주소를 작성한다.
//            session.setAttribute("loginMember",member);
            model.addAttribute("loginMember", member);
            return "redirect:/";
        }
        return "redirect:/";
    }

    @RequestMapping("/logout.do")
//    public String logout(HttpSession session) {
//    session.invalidate();     //model로 하면 이렇게 해서 안됨.

    public String logout(SessionStatus sessionStatus) {
        if (!sessionStatus.isComplete()) {
            sessionStatus.setComplete();
        }

        return "redirect:/";
    }

//    @RequestMapping("/enrollmember.do")
//    public String enrollMember() {
//        return "member/memberEnroll";
//    }
//    @RequestMapping(value="/enrollmemberend.do", method= RequestMethod.POST)
//    @PostMapping("/enrollmemberend.do")
//    public String enrollMemberEnd(@ModelAttribute Member member, Model model) {
//        String password=member.getPassword();
//        member.setPassword(passwordEncoder.encode(password));
//        int result = memberService.enrollMember(member);
//        if (result == 0) {
//            model.addAttribute("msg", "회원가입 실패");
//            model.addAttribute("loc", "/");
//
//        } else {
//            model.addAttribute("msg", "회원가입 성공");
//            model.addAttribute("loc", "/");
//        }
//        return "common/msg";
//
//    }

@RequestMapping("/enrollmember.do")
public String enrollMember(@ModelAttribute("member")Member member) {
    return "member/memberEnroll";
}
    @PostMapping("/enrollmemberend.do")
    public String enrollMemberEnd(@Validated Member member, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
            return "/member/memberEnroll";
        }
        String password=member.getPassword();
        member.setPassword(passwordEncoder.encode(password));

        int result = memberService.enrollMember(member);
        if (result == 0) {
            model.addAttribute("msg", "회원가입 실패");
            model.addAttribute("loc", "/");

        } else {
            model.addAttribute("msg", "회원가입 성공");
            model.addAttribute("loc", "/");
        }
        return "common/msg";

    }
}
