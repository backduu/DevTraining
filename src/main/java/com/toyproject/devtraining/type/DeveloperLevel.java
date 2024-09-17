package com.toyproject.devtraining.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeveloperLevel {
    NEW("인턴개발자")
    ,JUNIOR("초급개발자")
    ,INTERMEDIATE("중급개발자")
    ,SENIOR("고급개발자")
    ,SPECIAL("특급개발자")
    ;
    private final String enumDeveloperLevel;
}
