package com.math.DHJmath.domain.comment;

import com.math.DHJmath.domain.board.Board;
import com.math.DHJmath.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String commentContent;

    private LocalTime commentDate;

    @Column(columnDefinition = "NUMBER")
    private int commentLevel;
    private int referenceCommentId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;

    @Builder
    public Comment(Long commentId,
                   String commentContent,
                   LocalTime commentDate,
                   int commentLevel,
                   int referenceCommentId,
                   User user,
                   Board board) {

        this.commentId = commentId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.commentLevel = commentLevel;
        this.referenceCommentId = referenceCommentId;
        this.user = user;
        this.board = board;
    }

}
