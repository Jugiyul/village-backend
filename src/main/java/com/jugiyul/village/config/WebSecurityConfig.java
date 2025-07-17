package com.jugiyul.village.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // REST API 이므로 CSRF 비활성화
            .csrf(csrf -> csrf.disable())
            // CORS 활성화
            .cors(Customizer.withDefaults())
            // 모든 요청 허용(인증/인가 없음)
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        return request -> {
            var config = new CorsConfiguration();
            // 허용할 프론트 도메인
            config.setAllowedOriginPatterns(List.of("http://localhost:5173"));
            // 허용 HTTP 메서드
            config.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
            // 허용 헤더
            config.setAllowedHeaders(List.of("*"));
            // 쿠키/자격증명 허용
            config.setAllowCredentials(true);

            return config;
        };
    }
}
