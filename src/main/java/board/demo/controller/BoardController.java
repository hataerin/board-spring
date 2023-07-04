package board.demo.controller;

import board.demo.model.Board;
import board.demo.model.BoardDetailDto;
import board.demo.model.BoardDto;
import board.demo.model.UserDto;
import board.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시판 목록 조회
    @GetMapping
    private List<Board> findAll() {
        return this.boardService.findAll();
    }

    // 게시판 상세 조회
//    @GetMapping("/{boardId}")
//    private Board findById(@PathVariable Integer boardId) {
//        return boardService.findById(boardId);
//    }
    @GetMapping("/{boardId}")
    private BoardDetailDto findById(@PathVariable Integer boardId) {
        return boardService.findDetailById(boardId);
    }

    // 게시판 등록
    @PostMapping
    private void createBoard(@RequestBody BoardDto dto) {
        this.boardService.createBoard(dto);
    }

    // 게시판 수정
    @PutMapping("/{boardId}")
    private void editUserInfo(@PathVariable Integer boardId, @RequestBody BoardDto dto) {
        this.boardService.updateBoard(boardId, dto);
    }

    // 게시판 삭제
    @DeleteMapping("/{boardId}")
    private void deleteBoard(@PathVariable Integer boardId) {
        this.boardService.deleteBoard(boardId);
    }
}
