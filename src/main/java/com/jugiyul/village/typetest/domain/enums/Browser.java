package com.jugiyul.village.typetest.domain.enums;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum Browser {
    CHROME,
    SAFARI,
    EDGE,
    FIREFOX,

    @JsonEnumDefaultValue
    OTHER
}
