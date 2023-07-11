package board.demo.service;

import board.demo.model.BoardDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoardService {

    Flux<BoardDto> findAll();

    Mono<BoardDto> findById(Integer boardId);

    Mono<Void> ceateBoard(Mono<BoardDto> dtoMono);

    Mono<Void> updateBoard(Integer boardId,Mono<BoardDto> dtoMono);

    Mono<Void> deleteBoard(Integer boardId);
}
