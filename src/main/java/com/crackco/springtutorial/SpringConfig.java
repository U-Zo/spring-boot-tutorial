package com.crackco.springtutorial;

import com.crackco.springtutorial.repository.MemberRepository;
import com.crackco.springtutorial.repository.MemoryMemberRepository;
import com.crackco.springtutorial.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 스프링 빈 설정
 */
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
