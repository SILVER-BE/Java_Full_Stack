package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/* 2 */

/* web.xml에서 filter 이용하는 방법 */

public class EncodingFilter implements Filter {

    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 필터 안에서 수행될 내용
        HttpServletResponse hresponse = (HttpServletResponse) servletResponse;

        hresponse.setContentType(encodingType);

        // 다음 필터가 있다면 실행, 아니라면 doGet,doPost 실행
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
