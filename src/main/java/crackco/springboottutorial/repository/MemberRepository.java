package crackco.springboottutorial.repository;

import crackco.springboottutorial.domain.Member;

import java.util.List;
import java.util.Optional;

// 회원 객체를 저장할 저장소
public interface MemberRepository {
    Member save(Member member);

    // Optional - null을 반환할 수 있는 메서드일 경우 사용
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
