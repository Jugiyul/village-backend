package com.jugiyul.village.typetest.repository;

import com.jugiyul.village.typetest.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // 문제 번호로 문제 불러오기
    Optional<Question> findByQuestionNo(Integer questionNo);
}
