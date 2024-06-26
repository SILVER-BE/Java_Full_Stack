package com.ohgiraffers.crud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class BeanConfig {

    @Bean //직접 만든게 아닐 땐 Bean 달아주기
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages/message");
        messageSource.setDefaultEncoding("UTF-8");
        Locale.setDefault(Locale.KOREA); /* 제공하지 않는 언어로 요청 시 사용할 default 언어 설정 */

        return messageSource;
    }
}
