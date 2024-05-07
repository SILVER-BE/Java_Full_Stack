package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {

    private final MemberDAO memberDAO;

    //초기화, 생성자에 의존성 주입, 타입을 찾아 의존성 주입, 하나일 땐 생략 가능
    @Autowired
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public Map<Long, MemberDTO> selectMembers() {
        System.out.println("selectMembers 메소드 실행");
        return memberDAO.selectMembers();
    }

    public MemberDTO selectMember(Long id) {
        System.out.println("selectMember 메소드 실행");
        return memberDAO.selectMember(id);
    }

}
