package board.demo.controller;


import board.demo.domain.BoardDto;
import board.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    //게시판 목록 조회
    @GetMapping
    private List<BoardDto> findAllBoard() {
        return this.boardService.getAllBoards();
    }

    //게시판 상세 조회
    @GetMapping("/:{id}")
    private BoardDto findBoardById(@PathVariable Long id) {
        return this.boardService.getBoardById(id);
    }

    //게시판 등록
    @PostMapping
    private void createBoard(@RequestBody BoardDto boardDto) {
        this.boardService.createBoard(boardDto);
    }

    //게시판 수정
    @PutMapping("/:{id}")
    private void editBoard(@PathVariable Long id, @RequestBody BoardDto boardDto) {
        this.boardService.modifyBoard(id, boardDto);
    }

    //게시판 삭제
    @DeleteMapping("/:{id}")
    private void deleteBoard(@PathVariable Long id) {
        this.boardService.removeBoard(id);
    }
}
