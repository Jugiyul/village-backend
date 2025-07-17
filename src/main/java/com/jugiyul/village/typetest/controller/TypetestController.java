package com.jugiyul.village.typetest.controller;

import com.jugiyul.village.typetest.dto.StartRequest;
import com.jugiyul.village.typetest.dto.StartResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "유형 테스트", description = "유형 테스트 관련 API")
@RequestMapping("/api/v1/typetest")
public class TypetestController {

    @PostMapping("/start")
    public ResponseEntity<StartResponse> start(@RequestBody StartRequest req) {
        return ResponseEntity.ok(service.startTest(req));
    }
}
