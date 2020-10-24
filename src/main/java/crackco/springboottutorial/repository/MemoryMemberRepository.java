package crackco.springboottutorial.repository;

import crackco.springboottutorial.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// 메모리 멤버 저장소
// @Repository // Spring 컨테이너가 해당 리포지토리 Bean 객체 저장
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 0 1 2 순차적 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {

        // null 이어도 감싸서 반환
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {

        // name과 같은 Member 객체를 하나라도 찾으면 바로 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {

        // store 값들의 컬렉션 반환
        return new ArrayList<>(store.values());
    }

    // 저장소를 비움
    public void clearStore() {
        store.clear();
    }
}
