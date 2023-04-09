package com.project.board.dto;

import com.project.board.entity.Board;
import com.project.board.type.Category;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author Jaeyoung Bang
 */
public class PostBoard {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Request {
        @NotNull(message = "공백이 아니어야 합니다")
        private Category category;

        @NotNull(message = "공백이 아니어야 합니다")
        @Length(min = 1, max = 20, message = "제목은 1~20자여야 합니다")
        private String title;

        @NotNull(message = "공백이 아니어야 합니다")
        private String content;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private Category category;
        private String title;
        private String content;

        public static Response fromEntity(Board board) {
            return Response.builder()
                    .category(board.getCategory())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .build();
        }
    }
}
