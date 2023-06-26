package board.demo.controller;


import board.demo.domain.UserDto;
import board.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //회원 목록 조회
    @GetMapping
    private List<UserDto> findAllUsers() {
        return this.userService.getAllUsers();
    }

    //회원 상세 조회
    @GetMapping("/{userId}")
    private UserDto findUserById(@PathVariable String userId) {

        return this.userService.getUserById(userId);
    }

    //회원 등록
    @PostMapping
    private void createUser(@RequestBody UserDto userDto) {
        this.userService.saveUser(userDto);
    }

    //회원 수정
    @PutMapping("/{userId}")
    private void modifyUser(@PathVariable String userId, @RequestBody UserDto userDto) {
        this.userService.modifyUser(userId, userDto);
    }

    //회원 삭제
    @DeleteMapping("/{userId}")
    private void deleteUser(@PathVariable String userId) {
        this.userService.deleteUser(userId);
    }
}
