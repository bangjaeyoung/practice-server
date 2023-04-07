package com.project.board.controller;

import com.project.board.dto.PostBoard;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Jaeyoung Bang
 */
@Slf4j
@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/post")
    public PostBoard.Response postBoard(@Valid @RequestBody PostBoard.Request request) {
        log.info("request : {}", request);

        return boardService.createBoard(request);
    }
}
