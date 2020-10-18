package com.crackco.springtutorial.repository;

import com.crackco.springtutorial.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// @Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // Optional Null이 있어도 반환 가능
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // findAny: 하나라도 찾으면
    }

    @Override
    public List<Member> findAll() {
        // 자바에서 실무는 List를 많이 사용
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
