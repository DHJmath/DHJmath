package com.math.DHJmath.web.dto;

import com.math.DHJmath.domain.board.Board;
import com.math.DHJmath.domain.board.Category;
import com.math.DHJmath.domain.user.User;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BoardResponseDto {

    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private int boardHit;
    private LocalDate boardDate;
    private User user;
    private Category category;

    public BoardResponseDto(Board entity) {
        this.boardId = entity.getBoardId();
        this.boardTitle = entity.getBoardTitle();
        this.boardContent = entity.getBoardContent();
        this.boardHit = entity.getBoardHit();
        this.boardDate = entity.getBoardDate();
        this.user = entity.getUser();
        this.category = entity.getCategory();
    }
}
