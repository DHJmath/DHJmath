package com.math.DHJmath.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    // 최신순 글 목록 조회
    @Query("SELECT b FROM Board b ORDER BY b.boardDate DESC")
    List<Board> findAllDesc();

    // 조회수 증가
    @Modifying
    @Query("UPDATE BOARD b SET b.boardHit = b.boardHit + 1 WHERE b.boardId = :boardId")
    int updateView(Long boardId);

}
