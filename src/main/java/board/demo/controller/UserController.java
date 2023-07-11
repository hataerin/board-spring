package board.demo.controller;

import board.demo.entity.User;
import board.demo.model.UserDto;
import board.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    private Flux<UserDto> findAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{userId}")
    private Mono<UserDto> findById(@PathVariable Integer userId) {
        return this.userService.findById(userId);
    }

    @PostMapping
    private Mono<Void> createUser(@RequestBody Mono<UserDto> dtoMono) {
        return this.userService.createUser(dtoMono);
    }

    @PutMapping("/{userId}")
    private Mono<Void> updateUser(@PathVariable Integer userId, @RequestBody Mono<UserDto> dtoMono) {
        return this.userService.updateUser(userId, dtoMono);
    }

    @DeleteMapping("/{userId}")
    private Mono<Void> deleteUser(@PathVariable Integer userId) {
        return this.userService.deleteUser(userId);
    }
}
