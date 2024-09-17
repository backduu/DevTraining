package com.toyproject.devtraining.dto;

import com.toyproject.devtraining.exception.DevTrainingErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DevTrainingErrorResponse {
    private DevTrainingErrorCode errorCode;
    private String errorMessage;
}
