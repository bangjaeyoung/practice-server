package com.project.board.dto;

import com.project.board.type.Category;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author Jaeyoung Bang
 */
public class BoardRequestDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Post {
        @NotNull(message = "공백이 아니어야 합니다")
        private Category category;

        @NotNull(message = "공백이 아니어야 합니다")
        @Length(min = 1, max = 20, message = "제목은 1~20자여야 합니다")
        private String title;

        @NotNull(message = "공백이 아니어야 합니다")
        private String content;
    }
}
