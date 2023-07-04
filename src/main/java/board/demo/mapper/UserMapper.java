package board.demo.mapper;

import board.demo.model.User;
import board.demo.model.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    // 회원 목록 조회
    List<User> findAll();

    // 회원 상세 조회
    User findById(Integer id);

    // 회원 등록
    void createUser(@Param("user") UserDto user);

    // 회원 수정
    void updateUser(@Param("id") Integer id, @Param("user") UserDto user);

    // 회원 삭제
    void deleteUser(@Param("id") Integer id);
}
