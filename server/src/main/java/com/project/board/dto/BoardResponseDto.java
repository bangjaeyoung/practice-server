package com.project.board.dto;

import com.project.board.entity.Board;
import com.project.board.type.Category;
import lombok.*;

/**
 * @author Jaeyoung Bang
 */
public class BoardResponseDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Post {
        private Category category;
        private String title;
        private String content;

        public static BoardResponseDto.Post fromEntity(Board board) {
            return BoardResponseDto.Post.builder()
                    .category(board.getCategory())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .build();
        }
    }
}
