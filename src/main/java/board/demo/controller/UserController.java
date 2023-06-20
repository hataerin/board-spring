package board.demo.controller;


import board.demo.dto.UserAddressDto;
import board.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RequestMapping("/boards")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //회원 목록 조회

    //회원 상세 조회

    //회원 등록
    @PostMapping
    public UserAddressDto create(@RequestBody UserAddressDto userAddressDto) throws SQLException {
        return userService.create(userAddressDto);
    }

    //회원 수정

    //회원 삭제
}
