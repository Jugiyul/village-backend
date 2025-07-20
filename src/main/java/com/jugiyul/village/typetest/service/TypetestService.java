package com.jugiyul.village.typetest.service;

import com.jugiyul.village.typetest.domain.Question;
import com.jugiyul.village.typetest.domain.TestSession;
import com.jugiyul.village.typetest.dto.OptionDto;
import com.jugiyul.village.typetest.dto.QuestionResponse;
import com.jugiyul.village.typetest.dto.StartRequest;
import com.jugiyul.village.typetest.dto.StartResponse;
import com.jugiyul.village.typetest.repository.QuestionRepository;
import com.jugiyul.village.typetest.repository.TestSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypetestService {

    private final TestSessionRepository tsRepo;
    private final QuestionRepository questionRepo;

    // 시작 - session 생성
    public StartResponse startTest(StartRequest req) {
        // 세션 Id 생성
        String sessionId = UUID.randomUUID().toString();
        // 엔티티 저장
        TestSession session = TestSession.builder()
                .sessionId(sessionId)
                .deviceType(req.getDeviceType())
                .os(req.getOs())
                .browser(req.getBrowser())
                .refererUrl(req.getRefererUrl())
                .build();
        // saveAndFlush 하면 바로 DB 반영 + createdAt 채우기
        TestSession savedSession = tsRepo.saveAndFlush(session);
        // 응답 DTO 반환
        return new StartResponse(sessionId, savedSession.getStartedAt());
    }

    // session 수 받아오기
    public long getSessionCount() {
        return tsRepo.count();
    }

    // 문제 받아오기
    @Transactional(readOnly = true)
    public QuestionResponse getQuestion(Integer questionNo) {
        // 문제 번호를 통해 문제를 먼저 받아오고
        Question q = questionRepo.findByQuestionNo(questionNo)
                .orElseThrow(() -> new IllegalArgumentException("Invalid questionNo: " + questionNo));

        //
        List<OptionDto> options = q.getOptions().stream()
                .map(o -> new OptionDto(o.getOptionLabel(), o.getOptionText()))
                .collect(Collectors.toList());


        return new QuestionResponse(q.getQuestionNo(), q.getContent(), options);
    }
}
