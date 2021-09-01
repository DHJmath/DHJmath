package com.math.DHJmath.web;

import com.math.DHJmath.service.board.BoardService;
import com.math.DHJmath.web.dto.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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



    @GetMapping("/board/boardList")
    public String boardList() {
        return "board-list";
    }


    // 게시글 삭제
    @DeleteMapping("/api/board/{boardId}")
    public Long delete(@PathVariable Long boardId) {
        boardService.delete(boardId);
        return boardId;
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