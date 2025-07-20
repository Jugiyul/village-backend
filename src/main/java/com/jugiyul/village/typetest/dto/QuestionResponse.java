package com.jugiyul.village.typetest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuestionResponse {
    private Integer questionNo;
    private String content;
    private List<OptionDto> options;
}
