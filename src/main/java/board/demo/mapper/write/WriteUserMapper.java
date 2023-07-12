package board.demo.mapper.write;

import board.demo.model.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WriteUserMapper {

    // 회원 등록
    void createUser(@Param("user") UserDto user);

    // 회원 수정
    void updateUser(@Param("id") Integer id, @Param("user") UserDto user);

    // 회원 삭제
    void deleteUser(@Param("id") Integer id);
}
