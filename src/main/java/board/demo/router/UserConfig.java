package board.demo.router;

import board.demo.handler.UserHandler;
import board.demo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class UserConfig {

    UserHandler userHandler(UserRepository userRepository) {
        return new UserHandler(userRepository);
    }

    @Bean
    RouterFunction<ServerResponse> routerFunction(UserHandler userHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/users"),
                RouterFunctions.nest(RequestPredicates.accept(MediaType.APPLICATION_JSON),
                        RouterFunctions.route()
                .GET("",userHandler::getAllUser)
                .GET("/{userId}",userHandler::getByUserId)
                .POST("", userHandler::saveUser)
                .DELETE("/{userId}",userHandler::deleteUser)
                .PUT("/{userId}",userHandler::updateUser)
                .build())
        );
    }
}
