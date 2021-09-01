package com.math.DHJmath.service.board;

import com.math.DHJmath.domain.board.Board;
import com.math.DHJmath.domain.board.BoardRepository;
import com.math.DHJmath.web.dto.BoardListResponseDto;
import com.math.DHJmath.web.dto.BoardResponseDto;
import com.math.DHJmath.web.dto.BoardSaveRequestDto;
import com.math.DHJmath.web.dto.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getBoardId();
    }


    @Transactional
    public void delete (Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + boardId));
        boardRepository.delete(board);
    }

    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        board.update(requestDto.getBoardTitle(), requestDto.getBoardContent());

        return id;
    }

    public BoardResponseDto findById(Long id) {
        Board entity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id) );
        return new BoardResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<BoardListResponseDto> findAllDesc() {
        return boardRepository.findAllDesc().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
        // readOnly = true : 트랜잭션 범위는 유지하되 조회기능만 남겨두어 조회속도 개선
        // Stream 을 이용하여 람다함수형식으로 간결하고 깔끔하게 요소들의 처리가 가능
        // map은 요소들을 특정조건에 해당하는 값으로 변환 // new : 클래스 생성자
    }

}


// 컬렉션을 반환하는 Spring Data JPA Repository 메서드는 null을 반환하지 않고 비어있는 컬렉션을 반환해주므로 Optional로 감싸서 반환할 필요가 없다.

// orElseThrow()
// 최종적으로 연산을 끝낸 후에도 옵셔널 객체가 비어있다면 예외 공급자 함수를 통해 예외를 발생시킵니다.
// IllegalArgumentException(String s)
// 메소드가 잘못되었거나 부적합한 인수를 전달했음을 나타내기 위해 던져집니다. s : 상세 메세지
//