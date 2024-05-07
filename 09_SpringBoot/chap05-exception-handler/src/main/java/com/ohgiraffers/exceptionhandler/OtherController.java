package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    //exceptionHandler를 전역적으로 적용하는 방법

    @GetMapping("other-controller-null")
    public String otherNullPointerExceptionTest() {

        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }


    @GetMapping("other-controller-user")
    public String otherUserExceptionTest() throws MemberRegistException {
        boolean check = true;
        if(check) {
            throw new MemberRegistException("회원가입이 불가능합니다.");
        }
        return "/";
    }

    /* ArrayIndexOutOfBoundsException 발생 */
    @GetMapping("other-controller-array")
    public String otherArrayExceptionTest() {

        double[] array = new double[0];
        System.out.println(array[0]);

        return "/";
    }
}
