package board.demo.service;

import board.demo.model.UserDto;
import board.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;


    @Override
    public Flux<UserDto> findAll() {
        return Flux.fromIterable(this.userRepository.findAll())
                .map(user -> user.toDto(user));
    }

    @Override
    public Mono<UserDto> findById(Integer userId) {
        return Mono.fromCallable(()->this.userRepository.findById(userId).get())
                .map(user -> user.toDto(user));
    }

    @Override
    public Mono<Void> createUser(Mono<UserDto> dtoMono) {
        return dtoMono.map(dto -> this.userRepository.save(dto.toEntity()))
                .and(ServerResponse.ok().build());
    }

    @Override
    public Mono<Void> updateUser(Integer userId, Mono<UserDto> dtoMono) {
        return dtoMono.map(dto-> this.userRepository.save(dto.toEntity(userId)))
                .and(ServerResponse.ok().build());

    }

    @Override
    public Mono<Void> deleteUser(Integer userId) {
        return Mono.fromRunnable(()->this.userRepository.deleteById(userId))
                .and(ServerResponse.ok().build());
    }
}
