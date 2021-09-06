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

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String boardTitle;

    @Column(columnDefinition = "TEXT", nullable = false) // 직접 컬럼 정보를 작성할 수 있다.
    private String boardContent;

    @Column(columnDefinition = "integer default 0")
    private int boardHit;

    @Column(columnDefinition = "date default now()")
    private LocalDate boardDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cateId")
    private Category category;


    // 생성자
    @Builder
    public Board(String boardTitle,
                 String boardContent,
                 int boardHit,
                 LocalDate boardDate,
                 User user,
                 Category category) {

        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardHit = boardHit;
        this.boardDate = LocalDate.now();
        this.user = user;
        this.category = category;
    }


    // 메소드
    public Board update(String boardTitle, String boardContent) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;

        return this;
    }


}
