package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* @Configuration : 해당 클래스가 bean을 생성하는 클래스임을 표기 */
@Configuration
public class ContextConfiguration {

    // xml을 이용하지 않고 여기서 직접 빈을 생성할 수도 있음

    /* @Bean : 해당 메소드의 반환 값을 spring container에 bean으로 등록한다는 의미
    *          이름을 별도로 지정하지 않으면 메소드명을 bean의 id로 자동 인식 함 */

    @Bean(name="member") // name 생략 가능 -> "member", 지정하지 않으면 메소드 이름을 아이디로 인식
    public MemberDTO getMember() {

        return new MemberDTO(1, "user01", "pass01", "판다");
    }

}
