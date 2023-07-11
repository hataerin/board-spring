package board.demo.controller;

import board.demo.model.BoardDto;
import board.demo.model.UserDto;
import board.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    private Flux<BoardDto> findAll() {
        return this.boardService.findAll();
    }

    @GetMapping("/{boardId}")
    private Mono<BoardDto> findById(@PathVariable Integer boardId) {
        return this.boardService.findById(boardId);
    }

    @PostMapping
    private Mono<Void> createBoard(@RequestBody Mono<BoardDto> dtoMono) {
        return this.boardService.ceateBoard(dtoMono);
    }

    @PutMapping("/{boardId}")
    private Mono<Void> updateBoard(@PathVariable Integer boardId, @RequestBody Mono<BoardDto> dtoMono) {
        return this.boardService.updateBoard(boardId, dtoMono);
    }

    @DeleteMapping("/{boardId}")
    private Mono<Void> deleteUser(@PathVariable Integer boardId) {
        return this.boardService.deleteBoard(boardId);
    }

}
