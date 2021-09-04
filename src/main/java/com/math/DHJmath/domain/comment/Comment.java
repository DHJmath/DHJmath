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
    private User userId;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board boardId;

    @Builder
    public Comment(Long commentId,
                   String commentContent,
                   LocalTime commentDate,
                   int commentLevel,
                   int referenceCommentId,
                   User userId,
                   Board boardId) {

        this.commentId = commentId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.commentLevel = commentLevel;
        this.referenceCommentId = referenceCommentId;
        this.userId = userId;
        this.boardId = boardId;
    }

}
