package com.ohgiraffers.cookie;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

//        response.sendRedirect("redirect");

        /*
        * [ 쿠키 사용법 ]
        * 1. 쿠키를 생성한다.
        * 2. 생성한 쿠키의 만료 시간을 설정한다.
        * 3. 응답 헤더에 쿠키를 담는다.
        * 4. 응답을 보낸다.
        *
        * [ 쿠키 제약 사항 ]
        * 1. 쿠키의 이름은 ascii 문자만을 사용해야 하며 한 번 설정한 이름은 변경 불가
        * 2. 이름에 공백 문자와 일부 특수 문자([] () = , " \ ? @ : ;) 사용 불가
        * */

        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        firstNameCookie.setMaxAge(60 * 60 * 24);        // 초 단위 설정 (만료시간 : 하루)
        lastNameCookie.setMaxAge(60 * 60 * 24);

        response.addCookie(firstNameCookie);
        response.addCookie(lastNameCookie);

        response.sendRedirect("redirect");
    }
}
