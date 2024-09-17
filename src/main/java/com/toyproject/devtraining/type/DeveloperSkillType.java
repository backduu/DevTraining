package com.toyproject.devtraining.type;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum DeveloperSkillType {
    BACKEND("백엔드")
    ,FRONTEND("프론트엔드")
    ,FULLSTACK("풀스택")
    ,EMBEDDED("임베디드")
    ,GUI("GUI")
    ;
    private final String enumDeveloperSkillType;
}
