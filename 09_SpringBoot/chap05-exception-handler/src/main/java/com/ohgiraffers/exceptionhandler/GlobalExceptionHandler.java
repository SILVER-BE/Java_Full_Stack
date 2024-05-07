package com.ohgiraffers.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* @ControllerAdvice 어노테이션이 적용된 클래스의 @ExceptionHandler는 전역적으로 기능한다. */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class) // 전역으로 적용 됨
    public String nullPointerExceptionHandler(NullPointerException exception) {

        System.out.println("message : " + exception.getMessage());
        System.out.println("Global(전역) 레벨의 exception 처리");

        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class) // 전역으로 적용 됨
    public String userExceptionHandler(MemberRegistException exception, Model model) {

        model.addAttribute("exception", exception);
        System.out.println("Global(전역) 레벨의 exception 처리");

        return "error/memberRegist";
    }

    /* 상위 타입의 Exception을 통해 Handler를 작성하면 하위 타입의 모든 Exception을 처리할 수 있다. */
    @ExceptionHandler(Exception.class) //모두 적용될 수 있도록 Exception의 상위 타입 작성
    public String defaultException(Exception exception) {

        return "error/default";
    }

}
