package com.jugiyul.village.typetest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jugiyul.village.typetest.domain.enums.Browser;
import com.jugiyul.village.typetest.domain.enums.DeviceType;
import com.jugiyul.village.typetest.domain.enums.OS;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.OffsetDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class StartRequest {
    // 다바이스 종류
    @NotBlank
    private DeviceType deviceType;
    // OS 종류
    @NotBlank
    private OS os;
    // 브라우저 종류
    @NotBlank
    private Browser browser;
    // 이전 페이지 URL
    @NotBlank
    private String refererUrl;
    // 시작 버튼을 누른 시간
    @NotNull
    @JsonFormat(shape   = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime timestamp;
}
