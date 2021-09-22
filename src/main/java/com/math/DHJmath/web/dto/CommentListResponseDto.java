package com.math.DHJmath.web.dto;

import com.math.DHJmath.domain.comment.Comment;
import lombok.Getter;

@Getter
public class CommentListResponseDto {
    private Long commentId;
    private Long userId;
    private Long boardId;
    private String commentContent;
    private int commentLevel;
    private int referenceCommentId;

    public CommentListResponseDto(Comment entity) {
        this.commentId = entity.getCommentId();
        this.userId = entity.getUser().getUserId();
        this.boardId = entity.getBoard().getBoardId();
        this.commentContent = entity.getCommentContent();
        this.commentLevel = entity.getCommentLevel();
        this.referenceCommentId = entity.getReferenceCommentId();
    }
}
