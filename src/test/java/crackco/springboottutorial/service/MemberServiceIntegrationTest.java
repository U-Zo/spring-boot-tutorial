package crackco.springboottutorial.service;

import crackco.springboottutorial.domain.Member;
import crackco.springboottutorial.repository.MemberRepository;
import crackco.springboottutorial.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // 스프링 컨테이너와 함께 테스트 수행
@Transactional // 테스트 후 트랜잭션 롤백을 수행
class MemberServiceIntegrationTest {

    // 테스트 시 편한 방법으로 해도 상관 없음
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);

        // 예외 발생 시 예외 클래스가 같으면 성공
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        // 메시지가 같으면 성공
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2); // 중복이니 예외
//
//            // 예외가 발생하지 않으면 실패
//            fail("예외가 발생해야 합니다.");
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        // then
    }
}
