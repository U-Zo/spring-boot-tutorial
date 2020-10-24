package crackco.springboottutorial.service;

import crackco.springboottutorial.domain.Member;
import crackco.springboottutorial.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService;

    // new 키워드를 생성시 MemberService 클래스의  저장소 객체가 다를 수 있음
    MemoryMemberRepository memberRepository;

    @BeforeEach // 모든 케이스가 동작하기 전에 수행
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hello");

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

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
