package com.project.exception;

import lombok.*;

/**
 * @author Jaeyoung Bang
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private ErrorCode errorCode;
    private String errorMessage;
}
