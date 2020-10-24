package crackco.springboottutorial.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // 엔티티로 설정
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 생성해줌
    private Long id;        // 데이터 구분을 위한 id
    private String name;    // 회원의 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
