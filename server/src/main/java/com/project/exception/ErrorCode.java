package com.project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jaeyoung Bang
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_REQUEST("잘못된 요청입니다"),

    ALREADY_EXISTS_EMAIL("이미 등록된 이메일이 존재합니다"),
    ALREADY_EXISTS_NICKNAME("이미 등록된 닉네임이 존재합니다"),

    INTERNAL_SERVER_ERROR("서버에 오류가 발생했습니다");

    private final String message;
}
