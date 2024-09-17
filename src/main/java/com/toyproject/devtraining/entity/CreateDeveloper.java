package com.toyproject.devtraining.entity;

import com.toyproject.devtraining.dto.DeveloperDTO;
import com.toyproject.devtraining.type.DeveloperLevel;
import com.toyproject.devtraining.type.DeveloperSkillType;
import jakarta.validation.constraints.*;
import lombok.*;

public class CreateDeveloper {
    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        @NotNull
        private DeveloperLevel developerLevel;
        @NotNull
        private DeveloperSkillType developerSkillType;
        @NotNull
        @Min(0) @Max(20)
        private Integer experienceYears;
        @NotNull @Size(min = 3, max = 50, message = "memberId size must 3~50")
        private String memberId;
        @NotNull @Size(min = 3, max = 20, message = "name size must 3~20")
        private String name;
        @Min(18)
        private Integer age;
    }

    @ToString
    @Getter @Setter
    @AllArgsConstructor @NoArgsConstructor
    @Builder
    public static class Response {
        private DeveloperLevel developerLevel;
        private DeveloperSkillType developerSkillType;
        private Integer experienceYears;
        private String memberId;

        public static Response fromEntity(DeveloperDTO developer) {
            return Response.builder()
                    .developerLevel(developer.getDeveloperLevel())
                    .developerSkillType(developer.getDeveloperSkillType())
                    .experienceYears(developer.getExperienceYears())
                    .memberId(developer.getMemberId())
                    .build();
        }
    }
}
