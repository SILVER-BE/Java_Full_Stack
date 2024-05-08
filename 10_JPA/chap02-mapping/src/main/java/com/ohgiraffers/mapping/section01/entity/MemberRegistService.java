package com.ohgiraffers.mapping.section01.entity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberRegistService {

    private MemberRepository memberRepository;

    // 의존성 주입
    public MemberRegistService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 멤버 등록 기능
    @Transactional //메소드가 성공적으로 실행됐을 때, commit 까지 완료
    public void registMember(MemberRegistDTO newMember) { // DTO 타입으로 전달하여 정보를 가공하고

        Member member = new Member(
                newMember.getMemberId(),
                newMember.getMemberPwd(),
                newMember.getMemberName(),
                newMember.getPhone(),
                newMember.getAddress(),
                newMember.getEnrollDate(),
                newMember.getMemberRole(),
                newMember.getStatus()
        );

        memberRepository.save(member); // Entity로 DB에 전달해준다.
    }

    // 아이디로 이름을 반환 받는 기능
    @Transactional
    public String registMemberAndFindName(MemberRegistDTO newMember) {
        registMember(newMember);
        return memberRepository.findNameById(newMember.getMemberId());
    }

}
