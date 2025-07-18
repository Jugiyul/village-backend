package com.jugiyul.village.typetest.repository;

import com.jugiyul.village.typetest.domain.TestSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestSessionRepository extends JpaRepository<TestSession, Long> {
    Optional<TestSession> findBySessionId(String sessionId);
}
