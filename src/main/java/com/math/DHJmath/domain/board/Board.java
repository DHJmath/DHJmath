package com.math.DHJmath.domain.board;

import com.math.DHJmath.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {

    // 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false)
    private String boardTitle;
    private String boardContent;
    private int boardLevel;
    private int boardHit;
    private LocalDate boardDate;
    private Long userId;
    private Long cateId;


//    // 생성자
//    @Builder
//    public Board(String boardTitle, String boardContent, int boardLevel,  )


    // 메소드
    public Board update(String boardTitle, String boardContent) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;

        return this;
    }


}
