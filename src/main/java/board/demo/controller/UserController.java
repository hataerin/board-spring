package board.demo.controller;

import board.demo.entity.User;
import board.demo.model.UserDto;
import board.demo.repository.UserRepository;
import board.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // 회원 상세 조회

    // 회원 등록
    @PostMapping
    private void createUser(@RequestBody UserDto dto) {
        this.userService.createUser(dto);
    }

    // 회원 수정

    // 회원 삭제
}
