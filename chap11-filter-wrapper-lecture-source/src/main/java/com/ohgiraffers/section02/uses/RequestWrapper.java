package com.ohgiraffers.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/* 3 */

public class RequestWrapper extends HttpServletRequestWrapper {

    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    // 꺼내는 순간 암호화되게 만들기
    @Override
    public String getParameter(String name) {
        String value = "";

        if("password".equals(name)) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter(name));
        } else {
            value = super.getParameter(name);
        }

        return value;
    }


}
