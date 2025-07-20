package com.jugiyul.village.typetest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessionCountResponse {
    // 세션 수(참여자 수)
    private long sessionCount;
}
