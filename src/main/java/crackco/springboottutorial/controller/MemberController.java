package crackco.springboottutorial.controller;

import crackco.springboottutorial.domain.Member;
import crackco.springboottutorial.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // Spring 컨테이너가 해당 컨트롤러 Bean 객체 저장
public class MemberController {

    private final MemberService memberService;

    @Autowired // 자동으로 Spring 컨테이너의 Bean 객체 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    // 회원가입의 폼의 값이 자동으로 MemberForm으로 변환되어 넘김
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());

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
