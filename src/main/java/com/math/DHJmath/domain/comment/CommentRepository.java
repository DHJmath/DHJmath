package com.math.DHJmath.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 최신순 댓글 목록 조회
    @Query("SELECT c FROM Comment c WHERE c.boardId = :boardId ORDER BY c.commentDate DESC")
    List<Comment> findAllDesc(Long boardId);
}
