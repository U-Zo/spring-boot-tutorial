package crackco.springboottutorial;

import crackco.springboottutorial.repository.MemberRepository;
import crackco.springboottutorial.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // private EntityManager em;

//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

//    private DataSource dataSource;
//
//    @Autowired // 스프링 데이터베이스로부터 DataSource 자동 주입
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean // 컨테이너에 bean 객체 등록
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        // return new JdbcMemberRepository(dataSource);
//        // return new JdbcTemplateMemberRepository(dataSource);
//        // return new JpaMemberRepository(em);
//    }
}
