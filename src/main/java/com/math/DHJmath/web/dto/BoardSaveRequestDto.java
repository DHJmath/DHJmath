package com.math.DHJmath.web.dto;

import com.math.DHJmath.domain.board.Board;
import com.math.DHJmath.domain.board.Category;
import com.math.DHJmath.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.net.UnknownServiceException;
import java.time.LocalDate;
import java.util.Date;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String boardTitle;
    private String boardContent;
    private int boardLevel;
    private int boardHit;
    private LocalDate boardDate;
    private User userId;
    private Category cateId;

    @Builder
    public BoardSaveRequestDto(String boardTitle,
                 String boardContent,
                 int boardLevel,
                 int boardHit,
                 LocalDate boardDate,
                 User userId,
                 Category cateId) {

        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardLevel = boardLevel;
        this.boardHit = boardHit;
        this.boardDate = boardDate;
        this.userId = userId;
        this.cateId = cateId;
    }

    public Board toEntity() {
        return new Board(boardTitle, boardContent, boardLevel, boardHit,
                boardDate, userId, cateId);
    }
}
