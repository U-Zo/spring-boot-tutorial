package crackco.springboottutorial.service;

import crackco.springboottutorial.domain.Member;
import crackco.springboottutorial.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// @Service // Spring 컨테이너가 해당 서비스 Bean 객체 저장
@Transactional // 데이터를 변경할 때는 꼭 필요
public class MemberService {

    private final MemberRepository memberRepository;

    // 외부에서 주입하도록 설정하면 같은 저장소 사용하게 됨
    // @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {

        validateDuplicateMember(member);

        // ifPresent() 값이 null이 아니면
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 같은 이름이 있는 중복 회원x
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
