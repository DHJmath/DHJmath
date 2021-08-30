package com.math.DHJmath.web.dto;

import com.math.DHJmath.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    @Id
    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private int boardLevel;
    private int boardHit;
    private LocalDate boardDate;
    private Long userId;
    private Long cateId;


    public Board toEntity() {
        return new Board(boardId, boardTitle, boardContent, boardLevel, boardHit,
                boardDate, userId, cateId);
    }
}
