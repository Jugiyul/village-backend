package com.jugiyul.village.typetest.service;

import com.jugiyul.village.typetest.domain.TestSession;
import com.jugiyul.village.typetest.dto.StartRequest;
import com.jugiyul.village.typetest.dto.StartResponse;
import com.jugiyul.village.typetest.repository.TestSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TypetestService {

    private final TestSessionRepository tsRepo;

    // 시작 - session 생성
    public StartResponse startTest(StartRequest req) {
        // 세션 Id 생성
        String sessionId = UUID.randomUUID().toString();
        // 엔티티 저장
        TestSession session = new TestSession();
        session.setSessionId(sessionId);
        tsRepo.save(session);
        // 응답 DTO 반환
        return new StartResponse(sessionId, LocalDateTime.now());
    }

    // session 수 받아오기
    public long getSessionCount() {
        return tsRepo.count();
    }
}
