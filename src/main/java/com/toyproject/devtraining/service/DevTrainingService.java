package com.toyproject.devtraining.service;
import com.toyproject.devtraining.dao.DeveloperMapper;
import com.toyproject.devtraining.dto.DeveloperDTO;
import com.toyproject.devtraining.entity.CreateDeveloper;
import com.toyproject.devtraining.exception.DevTrainingException;
import com.toyproject.devtraining.type.DeveloperLevel;
import com.toyproject.devtraining.type.StatusCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.toyproject.devtraining.exception.DevTrainingErrorCode.*;

@Service
@RequiredArgsConstructor
public class DevTrainingService {
    private final DeveloperMapper developerMapper;
    private final DevValidationService devValidationService;

    public int getDeveloperCount() {
        return developerMapper.getDevCount();
    }

    public List<DeveloperDTO> getDevelopers() {
        return developerMapper.getDevelopers();
    }

    public DeveloperDTO getDeveloperDetail() {
        return developerMapper.getDeveloperDetail();
    }

    public CreateDeveloper.Response createDevelopers(CreateDeveloper.Request request) {
        devValidationService.validateCreateDeveloperRequest(request);

        DeveloperDTO developer = DeveloperDTO.builder()
                .developerLevel(request.getDeveloperLevel())
                .developerSkillType(request.getDeveloperSkillType())
                .memberId(request.getMemberId())
                .age(request.getAge())
                .name(request.getName())
                .experienceYears(request.getExperienceYears())
                .statusCode(StatusCode.EMPLOYED)
                .build();

                developerMapper.createDevelopers(developer);

                return CreateDeveloper.Response.fromEntity(developer);
    }


}
