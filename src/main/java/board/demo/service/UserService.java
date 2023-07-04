package board.demo.service;

import board.demo.model.User;
import board.demo.model.UserAddressDto;
import board.demo.model.UserDto;

import java.util.List;

public interface UserService {
    // 회원 목록 조회
    List<User> findAll();

    List<UserAddressDto> findAllDetail();

    // 회원 상세 조회
    UserAddressDto findById(Integer id);

    // 회원 등록
    void createUser(UserDto userDto);


    // 회원 수정
    void updateUser(Integer userId, UserDto userDto);

    // 회원 삭제
    void deleteUser(Integer id);
}
