package board.demo.controller;

import board.demo.model.User;
import board.demo.model.UserDto;
import board.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // 회원 목록 조회
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    // 회원 상세 조회
    @GetMapping("/{userId}")
    public User findById(@PathVariable Integer userId) {
        return userService.findById(userId);
    }

    // 회원 등록
    @PostMapping
    private void createUser(@RequestBody UserDto dto) {
        this.userService.createUser(dto);
    }

    // 회원 수정
    @PutMapping("/{userId}")
    private void editUserInfo(@PathVariable Integer userId, @RequestBody UserDto dto) {
        this.userService.updateUser(userId, dto);
    }

    // 회원 삭제
    @DeleteMapping("/{userId}")
    private void deleteUser(@PathVariable Integer userId) {
        this.userService.deleteUser(userId);
    }
}
