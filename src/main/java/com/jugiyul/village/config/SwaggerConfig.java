package com.jugiyul.village.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI typetestApplicationOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Typetest Application API")
                .version("v1")
                .description("나와 맞는 동네를 찾는 유형테스트 API 문서"));
    }
}
