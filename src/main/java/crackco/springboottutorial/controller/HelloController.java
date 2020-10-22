package crackco.springboottutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // /hello로 접속하면 해당 메서드 수행
    public String hello(Model model) {
        // Model은 MVC의 M에 해당하는 Model을 뜻함
        // 서블릿의 setAttribute() 메서드와 비슷한 기능
        model.addAttribute("data", "hello!");

        // 템플릿 처리 - 해당 파일명에 연결, templates/hello.html
        return "hello";
    }

    // @RequestParam 외부에서 파라미터를 받아야 할 때 사용
    // 웹 페이지의 form input value, url 파라미터 등
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // 데이터를 템플릿이 아닌 응답으로 바로 반환
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    
    // 객체로 반환할 시 JSON 형태로 값 반환
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // static으로 class를 정의하면 해당 클래스에서 사용할 수 있음
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
