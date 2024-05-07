package com.ohgiraffers.resolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/main"})
    public String main() {



        return "main"; // 메인화면으로 연결되게 설정
    }
}
