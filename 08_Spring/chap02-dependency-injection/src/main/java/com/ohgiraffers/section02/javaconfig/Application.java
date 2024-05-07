package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

// java로 의존성 주입하는 방법

@Configuration
public class Application {
    public static void main(String[] args) {

        // 자바라서 AnnotationConfigApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class); // 메타 정보 전달

        MemberDTO member = context.getBean(MemberDTO.class); // 메타 정보 전달

        /* MemberDTO의 PersonalAccount 객체 출력 */
        System.out.println(member);
        System.out.println(member.getPersonalAccount());
        System.out.println(member.getPersonalAccount().deposit(10000));
        System.out.println(member.getPersonalAccount().getBalance());
        System.out.println(member.getPersonalAccount().withDraw(5000));
        System.out.println(member.getPersonalAccount().getBalance());
    }
}
