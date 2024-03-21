package com.ohgiraffers.section01.contextlistener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("context listener 확인용 서블릿"); // 제대로 연결됐는지 확인용 출력문

        ServletContext context = request.getServletContext();

        /* context에 attr를 추가하면, attributeAdded() 메소드 동작 */
        context.setAttribute("test", "value");
        /* 동일한 key로 context에 attr를 추가(수정)하면 attributeReplaced() 메소드 동작 */
        context.setAttribute("test", "value2");
        /* context에서 attr를 제거하면 attributeRemoved() 메소드 동작 */
        context.removeAttribute("test");
    }

}
