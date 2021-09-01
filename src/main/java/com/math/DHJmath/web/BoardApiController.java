package com.math.DHJmath.web;

import com.math.DHJmath.service.board.BoardService;
import com.math.DHJmath.web.dto.BoardResponseDto;
import com.math.DHJmath.web.dto.BoardSaveRequestDto;
import com.math.DHJmath.web.dto.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.function.LongFunction;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    // 게시글 등록
    @PostMapping("/api/board")
    public Long save(@RequestBody BoardSaveRequestDto
                                           requestDto) {
       return boardService.save(requestDto);
    }

    // 게시글 리스트 조회
    @GetMapping("/board/boardList")
    public String boardList(Model model) {
        model.addAttribute("boardList", boardService.findAllDesc());
        return "board/board-list";
    }

//    // 게시글 디테일 조회
//    @GetMapping("/api/board/{boardId}")
//    public BoardResponseDto findById (@PathVariable Long boardId) {
//        return boardService.findById(boardId);
//    }

    // 게시글 디테일 조회
    @GetMapping("/board/update/{boardId}")
    public String findById(@PathVariable Long boardId,
                         Model model) {
        BoardResponseDto dto = boardService.findById(boardId);
        model.addAttribute("board", dto);
        return "board/board";
    }


    // 게시글 삭제
    @DeleteMapping("/api/board/{boardId}")
    public Long delete(@PathVariable Long boardId) {
        boardService.delete(boardId);
        return boardId;
    }

    // 글 내용을 담아서 수정페이지로 이동
    @GetMapping("/board/update/{boardId}")
    public String update(@PathVariable Long id,
                         Model model) {
        BoardResponseDto dto = boardService.findById(id);
        model.addAttribute("board", dto);
        return "board/board-update";
    }

    // 수정한 form으로 수정완료하기
    @PutMapping("/api/board/{boardId}")
    public Long updateEnd(@PathVariable Long id,
                          @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

}

// @PathVariable : URL 경로에 변수를 넣어주는거

//1. insert = save (o)
//
//        2. update
//
//        3. delete
//
//        4. select