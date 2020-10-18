package com.crackco.springtutorial.controller;

import com.crackco.springtutorial.domain.Member;
import com.crackco.springtutorial.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// @Controller 어노테이션이 있으면
// 자동으로 객체를 생성하여 Spring 컨테이너에 저장하여 관리
@Controller
public class MemberController {

    // 스프링 컨테이너에 등록하여 사용하기
    private final MemberService memberService;

    // 컨테이너의 객체를 가져와서 자동으로 연결
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }
}
