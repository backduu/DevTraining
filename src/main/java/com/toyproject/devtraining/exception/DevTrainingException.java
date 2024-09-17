package com.toyproject.devtraining.exception;

import lombok.Getter;

@Getter
public class DevTrainingException extends RuntimeException{
    private String message; // detail error message
    private DevTrainingErrorCode devTrainingErrorCode;

    public DevTrainingException(DevTrainingErrorCode errorCode) {
        super(errorCode.getMessage());
        this.devTrainingErrorCode = errorCode;
        this.message = errorCode.getMessage();
    }

    public DevTrainingException(DevTrainingErrorCode errorCode, String detailMessage) {
        super(errorCode.getMessage());
        this.devTrainingErrorCode = errorCode;
        this.message = detailMessage;
    }
}
