package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// resource와 같은 경로
public class Application {
    public static void main(String[] args) {

        // xml 파일은 GenericXmlApplicationContext 이용
        ApplicationContext context =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        MemberDTO member = context.getBean(MemberDTO.class); // 메타정보 가져오기

        /* MemberDTO의 PersonalAccount 객체 출력 */
        System.out.println(member.getPersonalAccount());
        System.out.println(member.getPersonalAccount().deposit(10000));
        System.out.println(member.getPersonalAccount().getBalance());
        System.out.println(member.getPersonalAccount().withDraw(10000));
        System.out.println(member.getPersonalAccount().getBalance());

    }
}
