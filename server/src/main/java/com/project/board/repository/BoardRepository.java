package com.project.board.repository;

import com.project.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jaeyoung Bang
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
}
