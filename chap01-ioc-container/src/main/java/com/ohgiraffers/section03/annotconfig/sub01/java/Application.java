package com.ohgiraffers.section03.annotconfig.sub01.java;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // 자바 설정이라 AnnotationConfigApplicationContext
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class); // 메타 정보 전달

        String[] beanNames = context.getBeanDefinitionNames(); // getBeanDefinitionNames : bean들의 이름을 배열로 반환시켜줌
        for(String beanName : beanNames) {
            System.out.println(beanName);
        }

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class); //스캔으로 자동 변환될때 대문자가 소문자로 바뀜

        System.out.println(memberDAO.selectMember(1));
        System.out.println(memberDAO.insertMember(new MemberDTO(3, "user03", "pass03", "코알라")));
        System.out.println(memberDAO.selectMember(3));
    }
}
