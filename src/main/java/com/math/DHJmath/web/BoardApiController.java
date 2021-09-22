package com.math.DHJmath.web;

import com.math.DHJmath.config.auth.LoginUser;
import com.math.DHJmath.config.auth.dto.SessionUser;
import com.math.DHJmath.service.board.BoardService;
import com.math.DHJmath.service.board.CommentService;
import com.math.DHJmath.web.dto.BoardResponseDto;
import com.math.DHJmath.web.dto.BoardSaveRequestDto;
import com.math.DHJmath.web.dto.BoardUpdateRequestDto;
import com.math.DHJmath.web.dto.CommentListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.function.LongFunction;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;
    private final CommentService commentService;

    // 게시글 등록페이지로 이동
    @GetMapping("board/save")
    public String goSave(@LoginUser SessionUser user) {
        if ( user != null ) {
            return "board/board-save";
        } else {
            // 로그인이 되어있지 않을 시, 로그인 페이지로 보내??
            return "user/login";
        }
    }

    // 게시글 등록
    @PostMapping("/api/board/save")
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

    // 게시글 디테일 조회 ( 댓글도 같이 조회 )
    @GetMapping("/board/update/{boardId}")
    public String findById(@PathVariable Long boardId,
                         Model model) {
        boardService.updateView(boardId);  // 조회수 증가
        BoardResponseDto boardDto = boardService.findById(boardId);
        model.addAttribute("commentList", commentService.findAllDesc(boardId));  // 해당 댓글
        model.addAttribute("board", boardDto);
        return "board/board";
    }


    // 게시글 삭제 ( 로그인 접근성 확인해야함 )
    @DeleteMapping("/api/board/{boardId}")
    public Long delete(@PathVariable Long boardId) {
        boardService.delete(boardId);
        return boardId;
    }

    // 글 내용을 담아서 수정페이지로 이동
    @GetMapping("/board/update/{boardId}")
    public String goUpdate(@PathVariable Long id,
                         Model model,
                         @LoginUser SessionUser user) {

        BoardResponseDto dto = boardService.findById(id);

        // 작성자와 로그인 정보가 같은지 확인
        if ( user.getEmail() == dto.getUser().getEmail() ) {
            model.addAttribute("board", dto);
            return "board/board-update";
            
        // 같지 않다면 로그인창으로
        } else {
            return "user/login";
        }

    }

    // 수정한 form으로 수정완료하기
    @PutMapping("/api/board/{boardId}")
    public Long update(@PathVariable Long id,
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