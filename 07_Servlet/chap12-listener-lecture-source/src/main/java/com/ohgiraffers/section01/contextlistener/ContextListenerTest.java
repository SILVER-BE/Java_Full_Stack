package com.ohgiraffers.section01.contextlistener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

    /*
    * 1. context ( -> 톰캣 컨테이너 자체에 리스너 연결 )
    *   - ServletContextListener : 웹 애플리케이션의 시작/종료에 대한 이벤트 리스너
    *   - ServletContextAttributeListener : context에 attribute 추가/수정/삭제에 대한 이벤트 리스너
     */
    public ContextListenerTest() {
        // 서버를 시작할 때 생성
        System.out.println("context listener 인스턴스 생성");

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 서버를 시작할 때 기본생성자 생성 이후 작동
        System.out.println("context init !!!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 서버 종료 시 작동
        System.out.println("context destroy !!!");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("context attribute 추가 됨");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("context attribute 제거 됨");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("context attribute 수정 됨");
    }
}
