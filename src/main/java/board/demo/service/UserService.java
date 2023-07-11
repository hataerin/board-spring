package board.demo.service;

import board.demo.model.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<UserDto> findAll();

    Mono<UserDto> findById(Integer userId);

    Mono<Void> createUser(Mono<UserDto> dtoMono);

    Mono<Void> updateUser(Integer userId, Mono<UserDto> dtoMono);

    Mono<Void> deleteUser(Integer userId);

}
