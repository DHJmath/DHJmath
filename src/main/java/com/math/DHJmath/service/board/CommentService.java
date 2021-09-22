package com.math.DHJmath.service.board;

import com.math.DHJmath.domain.board.Board;
import com.math.DHJmath.domain.comment.Comment;
import com.math.DHJmath.domain.comment.CommentRepository;
import com.math.DHJmath.web.dto.BoardListResponseDto;
import com.math.DHJmath.web.dto.BoardResponseDto;
import com.math.DHJmath.web.dto.CommentListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public List<CommentListResponseDto> findAllDesc(Long boardId) {
        return commentRepository.findAllDesc(boardId).stream()
                .map(CommentListResponseDto::new)
                .collect(Collectors.toList());
        // readOnly = true : 트랜잭션 범위는 유지하되 조회기능만 남겨두어 조회속도 개선
        // Stream 을 이용하여 람다함수형식으로 간결하고 깔끔하게 요소들의 처리가 가능
        // map은 요소들을 특정조건에 해당하는 값으로 변환 // new : 클래스 생성자
    }
}
