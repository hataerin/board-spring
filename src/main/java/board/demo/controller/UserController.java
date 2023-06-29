package board.demo.controller;

import board.demo.entity.User;
import board.demo.model.UserDto;
import board.demo.repository.UserRepository;
import board.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
//    private UserRepository userRepository;
    private UserService userService;

//    public UserController() {
//        super();
//    }

    // 회원 목록 조회
    @GetMapping
    private List<UserDto> findAllUsers() {
        return this.userService.getAllUser();
    }

    // 회원 상세 조회
//    @GetMapping("/{userId}")
//    private UserDto findUserById(@PathVariable Integer userId) {
//        return this.userService.getUserById(userId);
//    }
    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Integer userId) {
        return this.userService.getUserById(userId);
    }



    // 회원 등록
    @PostMapping
    private void createUser(@RequestBody UserDto dto) {
        this.userService.createUser(dto);
    }

    // 회원 수정
    @PutMapping("/{userId}")
    private void editUserInfo(@PathVariable Integer userId, @RequestBody UserDto dto) {
        this.userService.modifyUser(userId, dto);
    }

    // 회원 삭제
    @DeleteMapping("/{userId}")
    private void deleteUserInfo(@PathVariable Integer userId) {
        this.userService.removeUser(userId);
    }
}
