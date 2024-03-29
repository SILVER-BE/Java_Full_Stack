package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/* DispatcherServlet은 웹요청을 받는 즉시 @Controller가 달린 컨트롤러 클래스에 처리를 위임한다.
*  그 과정은 컨트롤러 클래스의 핸들러 메소드에 선언된 다양한 @RequestMapping 설정 내용에 따른다. */
@Controller
public class MethodMappingTestController {

    @RequestMapping("/menu/regist") // 이러한 요청('index.html'에 명시)이 들어왔을 때, 본 메소드를 실행하겠다
    public String registMenu(Model model) {

        /* Model 객체에 addAtribute 메소드를 이용해, key-value를 추가하면 view에서 사용할 수 있다.
         * view-reslover에서 다시 다룬다. */
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출함..");

        /* 반환하고자 하는 view의 경로를 포함한 이름을 작성,
         * resource/templates 하위부터의 경로를 작성한다. */
        return "mappingResult";
    }

    /* 요청 URL을 value 속성에 요청 method를 설정 */
    @RequestMapping(value="/menu/modify", method = RequestMethod.GET) // 메소드 호출방식 지정
    public String modifyMenu(Model model) {

        model.addAttribute("message", "GET 방식의 메뉴 수정용 핸들러 메소드 호출함..");

        return "mappingResult";
    }

    @RequestMapping("/menu/delete")
    public String getDeleteMenu(Model model) {
        model.addAttribute("message", "GET 방식의 삭제용 핸들러 메소드 호출");

        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model) {
        model.addAttribute("message", "POST 방식의 삭제용 핸들러 메소드 호출");

        return "mappingResult";
    }

}
