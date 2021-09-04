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

//    @ManyToOne
//    @JoinColumn(name="User")
//    private User user
;
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String boardTitle;
    @Column(columnDefinition = "TEXT", nullable = false) // 직접 컬럼 정보를 작성할 수 있다.
    private String boardContent;
    @Column(columnDefinition = "integer check('1','2')")
    private int boardLevel;
    @Column(columnDefinition = "integer default 0")
    private int boardHit;
    private LocalDate boardDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cateId")
//    private Categoty cateId;


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
