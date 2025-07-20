package com.jugiyul.village.typetest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.OffsetDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StartResponse {
    // 프론트로 전달할 세션ID
    private String testSessionId;

    // 시작 시간 (DB 저장된 시간을 그대로 내려줌)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime startedAt;
}
