package board.demo.handler;

import board.demo.entity.User;
import board.demo.model.UserDto;
import board.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UserHandler {

    private UserRepository userRepository;

    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원 목록 조회
    public Mono<ServerResponse> getAllUser(ServerRequest req) {
        Flux<User> userFlux = Flux.fromIterable(this.userRepository.findAll());

        return ServerResponse.ok() // HTTP Status Code 200 [OK]
                .contentType(MediaType.APPLICATION_JSON) // Response Content Type
                .body(userFlux, User.class) // Response Body
                .switchIfEmpty(ServerResponse.notFound().build()); // Response 404
    }

    // 회원 상세 조회
    public Mono<ServerResponse> getByUserId(ServerRequest req) {
        Integer userId = Integer.valueOf(req.pathVariable("userId"));

        Mono<User> user = Mono.just(this.userRepository.findByUserId(userId));

        log.warn(user.toString());
        return ServerResponse.ok() // HTTP Status Code 200 [OK]
                .contentType(MediaType.APPLICATION_JSON) // Response Content Type
                .body(user, User.class) // Response Body
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    // 회원 등록
    @Transactional
    public Mono<ServerResponse> saveUser(ServerRequest req) {

        Mono<UserDto> userDtoMono = req.bodyToMono(UserDto.class);

        log.warn(req.body(UserDto.class));

        return userDtoMono.flatMap(userDto -> Mono.fromCallable(() -> this.userRepository.save(userDto.toEntity())))
                .flatMap(data -> ServerResponse.ok() // HTTP Status Code 200 [OK]
                        .contentType(MediaType.APPLICATION_JSON) // Response Content Type
                        .bodyValue("Effected Row : " + data) // Response Body
                );
    }

    // 회원 수정
    @Transactional
    public Mono<ServerResponse> updateUser(ServerRequest req) {
        String userId = req.pathVariable("userId");

        Mono<UserDto> userDtoMono = req.bodyToMono(UserDto.class);

        return userDtoMono.flatMap(userDto -> Mono.fromCallable(() -> this.userRepository.save(userDto.toEntity())))
                .flatMap(data -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue("Effected Row : " + data));
    }


    // 회원 삭제
    @Transactional
    public Mono<ServerResponse> deleteUser(ServerRequest req) {
        Integer userId = Integer.valueOf(req.pathVariable("userId"));

        this.userRepository.deleteById(userId);

        return ServerResponse.status(HttpStatus.NO_CONTENT) // HTTP Status Code 204
                .build(Mono.empty()) // Response Publisher<Void>
                .switchIfEmpty(ServerResponse.notFound().build()); // Response 404
    }
}
