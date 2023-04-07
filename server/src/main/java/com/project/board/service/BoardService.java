package com.project.board.service;

import com.project.board.dto.PostBoard;
import com.project.board.entity.Board;
import com.project.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jaeyoung Bang
 */
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public PostBoard.Response createBoard(PostBoard.Request request) {

        Board board = Board.builder()
                .category(request.getCategory())
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        boardRepository.save(board);

        return PostBoard.Response.fromEntity(board);
    }
}
