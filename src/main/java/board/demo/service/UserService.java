package board.demo.service;

import board.demo.dto.UserAddressDto;
import board.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@RequiredArgsConstructor //생성자 주입
@Service
public class UserService {

    private final UserRepository userRepository;


    //회원 목록 조회

    //회원 상세 조회

    //회원 등록
    public UserAddressDto create(UserAddressDto userAddressDto) throws SQLException {
        return userRepository.save(userAddressDto);
    }

    //회원 수정

    //회원 삭제
}
