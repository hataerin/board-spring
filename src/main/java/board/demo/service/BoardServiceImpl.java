package board.demo.service;

import board.demo.model.BoardDto;
import board.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;


    @Override
    public Flux<BoardDto> findAll() {
        return Flux.fromIterable(this.boardRepository.findAll())
                .map(board -> board.toDto(board));
    }

    @Override
    public Mono<BoardDto> findById(Integer boardId) {
        return Mono.fromCallable(()->this.boardRepository.findById(boardId).get())
                .map(board -> board.toDto(board));
    }

    @Override
    public Mono<Void> ceateBoard(Mono<BoardDto> dtoMono) {
        return dtoMono.map(dto -> this.boardRepository.save(dto.toEntity()))
                .and(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build());
    }

    @Override
    public Mono<Void> updateBoard(Integer boardId, Mono<BoardDto> dtoMono) {
        return dtoMono.map(dto -> this.boardRepository.save(dto.toEntity(boardId)))
                .and(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build());
    }

    @Override
    public Mono<Void> deleteBoard(Integer boardId) {
        return Mono.fromRunnable(()->this.boardRepository.deleteById(boardId))
                .and(ServerResponse.ok().build());
    }
}
