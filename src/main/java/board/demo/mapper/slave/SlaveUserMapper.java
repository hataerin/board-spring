package board.demo.mapper.slave;

import board.demo.model.User;
import board.demo.model.UserAddressDto;

import java.util.List;


public interface SlaveUserMapper {

    // 회원 목록 조회
    List<User> findAll();

    // 회원 주소 포함 목록 조회
    List<UserAddressDto> findAllDetail();

    // 회원 상세 조회
    UserAddressDto findById(Integer id);
}
