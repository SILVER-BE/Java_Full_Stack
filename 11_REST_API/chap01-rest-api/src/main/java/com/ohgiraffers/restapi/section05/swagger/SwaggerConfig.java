package com.ohgiraffers.restapi.section05.swagger;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                //info 타입을 만들어서 제공(아래)
                .info(swaggerInfo());
    }

    private Info swaggerInfo() {
        return new Info()
        .title("Ohgiraffers API")
                .description("SpringBoot Swagger 연동 테스트")
                .version("1.0.0");

    }
}
