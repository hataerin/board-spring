//package board.demo.router;
//
//import board.demo.handler.BoardHandler;
//import board.demo.handler.UserHandler;
//import board.demo.repository.BoardRepository;
//import board.demo.repository.UserRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.server.RequestPredicates;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//@Configuration
//public class BoardConfig {
//
//    BoardHandler boardHandler(BoardRepository boardRepository) {
//        return new BoardHandler(boardRepository);
//    }
//
//    @Bean
//    RouterFunction<ServerResponse> routerFunction(BoardHandler boardHandler) {
//        return RouterFunctions.nest(RequestPredicates.path("/boards"),
//                RouterFunctions.nest(RequestPredicates.accept(MediaType.APPLICATION_JSON),
//                        RouterFunctions.route()
//                .GET("",boardHandler::getAllBoard)
////                .GET("/{boardId}",boardHandler::getByBoardId)
////                .POST("", boardHandler::saveUser)
////                .DELETE("/{boardId}",boardHandler::deleteBoard)
////                .PUT("/{boardId}",boardHandler::updateBoard)
//                .build())
//        );
//    }
//}
