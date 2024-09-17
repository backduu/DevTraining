package com.toyproject.devtraining.dto;

import com.toyproject.devtraining.type.DeveloperLevel;
import com.toyproject.devtraining.type.DeveloperSkillType;
import com.toyproject.devtraining.type.StatusCode;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperDTO {
    private DeveloperLevel developerLevel;
    private DeveloperSkillType developerSkillType;
    private String memberId;
    private int id;
    private int age;
    private int experienceYears;
    private String member_id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
    private StatusCode statusCode;
}
