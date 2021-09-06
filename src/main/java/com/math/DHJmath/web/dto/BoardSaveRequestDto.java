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
    private int boardHit;
    private LocalDate boardDate;
    private User user;
    private Category category;

    @Builder
    public BoardSaveRequestDto(String boardTitle,
                 String boardContent,
                 int boardHit,
                 LocalDate boardDate,
                 User user,
                 Category category) {

        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardHit = boardHit;
        this.boardDate = boardDate;
        this.user = user;
        this.category = category;
    }

    public Board toEntity() {
        return Board.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .boardHit(boardHit)
                .boardDate(boardDate)
                .user(user)
                .category(category)
                .build();
    }
}
