package com.project.board.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jaeyoung Bang
 */
@Getter
@AllArgsConstructor
public enum Category {
    LIFE("일상"),
    MEDICAL("의학"),
    SHOPPING("쇼핑"),
    ETC("기타");

    private final String description;
}
