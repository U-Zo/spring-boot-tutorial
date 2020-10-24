package crackco.springboottutorial.repository;

import crackco.springboottutorial.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Spring data JPA가 자동으로 구현체를 등록한다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // select m from Member m where m.name = ? 규칙이 정해져 있음
    @Override
    Optional<Member> findByName(String name);
}
