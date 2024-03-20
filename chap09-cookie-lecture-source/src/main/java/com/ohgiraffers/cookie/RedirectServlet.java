package com.ohgiraffers.cookie;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    //redirect는 get방식
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // redirect시 이전 요청 정보는 존재하지 않는다. (request가 공유되지 않으므로 null값 반환)
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");

        /*
        * [ 쿠키 쓰는 법 ]
        * 1. request에서 쿠키 목록을 쿠키의 배열 형태로 꺼내온다.
        * 2. 쿠키의 getName, getValue를 이용해서 쿠키에 담긴 값을 사용한다.
        * */

        Cookie[] cookies = request.getCookies();
        for(int i = 0; i < cookies.length; i++) {
            System.out.println("[cookie] " + cookies[i].getName() + " : " + cookies[i].getValue());

            if("firstName".equals(cookies[i].getName())) {
                firstname = cookies[i].getValue();
            } else if ("lastName".equals(cookies[i].getName())) {
                lastname = cookies[i].getValue();
            }
        }

        StringBuilder responseText = new StringBuilder();
        responseText.append("<doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3>Your first name is ")
                .append(firstname)
                .append(" and last name is ")
                .append(lastname)
                .append("~!</h3>")
                .append("</body>\n")
                .append("</html>");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print(responseText.toString());
        out.flush();
        out.close();
    }

}
