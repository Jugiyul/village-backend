package com.jugiyul.village.typetest.repository;

import com.jugiyul.village.typetest.domain.TestSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestSessionRepository extends JpaRepository<TestSession, Long> {
    // 세션ID 전달
    Optional<TestSession> findBySessionId(String sessionId);
    // 세션 수(참여자 수) 전달
}
