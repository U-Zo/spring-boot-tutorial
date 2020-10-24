package crackco.springboottutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 컨트롤러는 웹 접근을 담당
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {

        // 템플릿의 파일을 우선으로 탐색한다.
        return "home"; // home이라는 파일을 찾아서 호출
    }
}
