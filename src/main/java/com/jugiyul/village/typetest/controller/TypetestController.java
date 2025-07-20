package com.jugiyul.village.typetest.controller;

import com.jugiyul.village.typetest.dto.QuestionResponse;
import com.jugiyul.village.typetest.dto.SessionCountResponse;
import com.jugiyul.village.typetest.dto.StartRequest;
import com.jugiyul.village.typetest.dto.StartResponse;
import com.jugiyul.village.typetest.service.TypetestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "유형 테스트", description = "유형 테스트 관련 API")
@RequestMapping("/api/v1/typetest")
public class TypetestController {
    public final TypetestService ttService;

    @PostMapping("/sessions/start")
    @Operation(summary = "시작 버튼", description = "유형 테스트를 시작합니다.")
    public ResponseEntity<StartResponse> start(@Valid @RequestBody StartRequest req) {
        return ResponseEntity.ok(ttService.startTest(req));
    }

    @GetMapping("sessions/count")
    @Operation(summary = "참여자 수 받아오기", description = "유형 테스트 참여자 수(세션 생성 수)를 받아옵니다.")
    public ResponseEntity<SessionCountResponse> getSessionCount() {
        long count = ttService.getSessionCount();
        return ResponseEntity.ok(new SessionCountResponse(count));
    }

    @GetMapping("/questions/{questionNo}")
    @Operation(summary = "문제 받아오기", description = "각 페이지에 해당하는 문제와 선택지를 받아옵니다.")
    public ResponseEntity<QuestionResponse> getQuestion(@PathVariable Integer questionNo) {
        return ResponseEntity.ok(ttService.getQuestion(questionNo));
    }
}
