//package board.demo.handler;
//
//import board.demo.entity.Board;
//import board.demo.entity.User;
//import board.demo.model.UserDto;
//import board.demo.repository.BoardRepository;
//import board.demo.repository.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@Slf4j
//@Component
//public class BoardHandler {
//
//    private BoardRepository boardRepository;
//
//    public BoardHandler(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository;
//    }
//
//    // 목록 조회
//    public Mono<ServerResponse> getAllBoard(ServerRequest req) {
//        Flux<Board> boardFlux = Flux.fromIterable(this.boardRepository.findAll());
//
//        return ServerResponse.ok() // HTTP Status Code 200 [OK]
//                .contentType(MediaType.APPLICATION_JSON) // Response Content Type
//                .body(boardFlux, Board.class) // Response Body
//                .switchIfEmpty(ServerResponse.notFound().build()); // Response 404
//    }
//
//    // 상세 조회
//    public Mono<ServerResponse> getByUserId(ServerRequest req) {
//        Integer boardId = Integer.valueOf(req.pathVariable("boardId"));
//
//        Mono<Board> board = Mono.just(this.boardRepository.findById(boardId);
//
//        log.warn(board.toString());
//        return ServerResponse.ok() // HTTP Status Code 200 [OK]
//                .contentType(MediaType.APPLICATION_JSON) // Response Content Type
//                .body(board, Board.class) // Response Body
//                .switchIfEmpty(ServerResponse.notFound().build());
//    }
//
//    // 등록
//
//
//    // 수정
//
//
//    // 삭제
//
//}
