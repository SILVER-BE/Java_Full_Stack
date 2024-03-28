package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 설정 파일 표시
/* aspect의 autoProxy 사용에 관한 설정을 해주어야 advice가 동작한다. */
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContextConfiguration {




}
