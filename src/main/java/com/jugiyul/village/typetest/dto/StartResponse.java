package com.jugiyul.village.typetest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class StartResponse {
    // 프론트로 전달할 세션ID
    private String testSessionId;

    // 시작 시간
    @JsonFormat(
        shape    = JsonFormat.Shape.STRING,
        pattern  = "yyyy-MM-dd'T'HH:mm:ss",
        timezone = "Asia/Seoul"           // 한국 시간대 지정
    )
    private LocalDateTime startedAt;
}
