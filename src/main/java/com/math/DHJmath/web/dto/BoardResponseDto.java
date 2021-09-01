package com.math.DHJmath.web.dto;

import com.math.DHJmath.domain.board.Board;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BoardResponseDto {

    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private int boardLevel;
    private int boardHit;
    private LocalDate boardDate;
    private Long userId;
    private Long cateId;

    public BoardResponseDto(Board entity) {
        this.boardId = entity.getBoardId();
        this.boardTitle = entity.getBoardTitle();
        this.boardContent = entity.getBoardContent();
        this.boardLevel = entity.getBoardLevel();
        this.boardHit = entity.getBoardHit();
        this.boardDate = entity.getBoardDate();
        this.userId = entity.getUserId();
        this.cateId = entity.getCateId();
    }
}
