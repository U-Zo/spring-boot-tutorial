package crackco.springboottutorial.domain;

public class Member {

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
