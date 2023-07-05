//package board.demo.router;
//
//import board.demo.handler.UserHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.server.RequestPredicates;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//@Configuration
//public class UserRouter {
//
//    private final UserHandler userHandler;
//
//    public UserRouter(UserHandler userHandler) {
//        this.userHandler = userHandler;
//    }
//
//    @Bean
//    RouterFunction<ServerResponse> userRoutes() {
//        return RouterFunctions.nest(RequestPredicates.path("/users"), // Base route path
//                RouterFunctions.nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), // Basic Content-Type
//                        RouterFunctions.route(RequestPredicates.GET("/{userId}"), this.userHandler::getByUserId)
//                                .andRoute(RequestPredicates.PUT("/{userId}"), this.userHandler::updateUser)
//                                .andRoute(RequestPredicates.DELETE("/{userId}"), this.userHandler::deleteUser)
//                                .andRoute(RequestPredicates.method(HttpMethod.GET), this.userHandler::getAllUser)
//                                .andRoute(RequestPredicates.method(HttpMethod.POST), this.userHandler::saveUser)));
//    }
//}
