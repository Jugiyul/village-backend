package com.jugiyul.village.typetest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class StartRequest {
    // 다바이스 종류
    @NotBlank
    private String deviceType;
    // OS 종류
    @NotBlank
    private String os;
    // 브라우저 종류
    @NotBlank
    private String browser;
    // 이전 페이지 URL
    @NotBlank
    private String refererUrl;
    // 시작 버튼을 누른 시간
    @NotNull
    private LocalDateTime timestamp;
}
