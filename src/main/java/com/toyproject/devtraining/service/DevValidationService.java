package com.toyproject.devtraining.service;

import com.toyproject.devtraining.dao.DeveloperMapper;
import com.toyproject.devtraining.dto.DeveloperDTO;
import com.toyproject.devtraining.entity.CreateDeveloper;
import com.toyproject.devtraining.exception.DevTrainingException;
import com.toyproject.devtraining.type.DeveloperLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.toyproject.devtraining.exception.DevTrainingErrorCode.DUPLICATED_MEMBER_ID;
import static com.toyproject.devtraining.exception.DevTrainingErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;

@Service
@RequiredArgsConstructor
public class DevValidationService {
    private final DeveloperMapper developerMapper;

    // --- 개발자 생성 validation
    void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
        validateDeveloperLevel(request.getDeveloperLevel(), request.getExperienceYears());

        // member ID 검색
        List<DeveloperDTO> listExistsDeveloper = developerMapper.findByMemberId(request.getMemberId());
        if(!listExistsDeveloper.isEmpty())
        {
            throw new DevTrainingException(DUPLICATED_MEMBER_ID);
        }
    }

    private void validateDeveloperLevel(DeveloperLevel developerLevel, Integer experienceYears) {
        if(developerLevel == DeveloperLevel.SPECIAL &&
                experienceYears < 10 || experienceYears > 30) {
            throw new DevTrainingException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        if (developerLevel == DeveloperLevel.SENIOR &&
                experienceYears < 10) {
            throw new DevTrainingException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        if (developerLevel == DeveloperLevel.INTERMEDIATE &&
                (experienceYears < 4 || experienceYears > 10)) {
            throw new DevTrainingException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        if (developerLevel == DeveloperLevel.JUNIOR && experienceYears > 4) {
            throw new DevTrainingException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
    }
}
