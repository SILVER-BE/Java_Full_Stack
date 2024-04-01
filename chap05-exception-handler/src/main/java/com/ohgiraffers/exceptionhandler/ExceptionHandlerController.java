package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

    /* 일부러 null 발생 시키기 */
    @GetMapping("controller-null")
    public String nullPointerExceptionTest() {

        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }

    /* null 발생할 경우, 출력 */
    @ExceptionHandler(NullPointerException.class) // 같은 컨트롤러 내부에서만 적용 됨
    public String nullPointerExceptionHandler(NullPointerException exception) {

        System.out.println("message : " + exception.getMessage());
        System.out.println("Controller(지역) 레벨의 exception 처리");

        return "error/nullPointer";
    }

    @GetMapping("controller-user")
    public String userExceptionTest() throws MemberRegistException {
        boolean check = true;
        if(check) {
            throw new MemberRegistException("회원가입이 불가능합니다.");
        }
        return "/";
    }

    @ExceptionHandler(MemberRegistException.class) // 같은 컨트롤러 내부에서만 적용 됨
    public String userExceptionHandler(MemberRegistException exception, Model model) {

        model.addAttribute("exception", exception);
        System.out.println("Controller(지역) 레벨의 exception 처리");

        return "error/memberRegist";
    }
}
