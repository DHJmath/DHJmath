package com.math.DHJmath.web;

import com.math.DHJmath.service.board.BoardService;
import com.math.DHJmath.web.dto.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/board")
    public Long save(@RequestBody BoardSaveRequestDto
                                           requestDto) {
       return boardService.save(requestDto);
    }



    @GetMapping("/board/boardList")
    public String boardList() {
        return "board-list";
    }
}


//1. insert = save (o)
//
//        2. update
//
//        3. delete
//
//        4. select