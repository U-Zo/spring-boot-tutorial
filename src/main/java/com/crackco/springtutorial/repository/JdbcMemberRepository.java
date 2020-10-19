package com.crackco.springtutorial.repository;

import com.crackco.springtutorial.domain.Member;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class JdbcMemberRepository implements MemberRepository {

    // DB를 사용하기 위해 사용
    private final DataSource dataSource;

    // 스프링을 통해 주입
    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        String sql = "insert into member(name) values(?)";

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, member.getName());

        pstmt.executeUpdate();

        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
