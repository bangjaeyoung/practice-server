package com.project.exception;

import lombok.Getter;

/**
 * @author Jaeyoung Bang
 */
@Getter
public class BusinessLogicException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String detailMessage;

    public BusinessLogicException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.detailMessage = errorCode.getMessage();
    }

    public BusinessLogicException(ErrorCode errorCode, String detailMessage) {
        super(detailMessage);
        this.errorCode = errorCode;
        this.detailMessage = detailMessage;
    }
}
