package com.ohgiraffers.thymeleaf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ohgiraffers.thymeleaf")
public class ContextConfiguration {
}

// Application 파일을 controller와 다른 패키지에 넣으면 실행이 되지 않는데,
// 어노테이션을 달아 경로를 확장해주면 실행할 수 있다.