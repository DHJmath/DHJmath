package com.math.DHJmath.web.dto;

import com.math.DHJmath.domain.board.Board;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BoardListResponseDto {
    private Long boardId;
    private String boardTitle;
    private LocalDate boardDate;
    private Long userId;
    private int boardHit;

    // 생성자
    public BoardListResponseDto(Board entity) {
        this.boardId = entity.getBoardId();
        this.boardTitle = entity.getBoardTitle();
        this.boardDate = entity.getBoardDate();
        this.userId = entity.getUser().getUserId();
        this.boardHit = entity.getBoardHit();
    }

}
