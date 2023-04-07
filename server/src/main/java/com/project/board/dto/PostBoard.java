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
        @NotNull
        private Category category;

        @NotNull
        @Length(min = 1, max = 20, message = "title length must be 1~20")
        private String title;

        @NotNull
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
