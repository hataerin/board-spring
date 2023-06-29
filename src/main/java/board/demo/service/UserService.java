package board.demo.service;

import board.demo.model.UserDto;
import board.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 회원 목록 조회

    // 회원 상세 조회

    // 회원 등록
    @Transactional
    public void createUser(UserDto dto) {
        this.userRepository.save(dto.toEntity());
    }
//    public void createUser(UserDto dto) {
//        this.userRepository.save(dto.toEntity());
//    }

    // 회원 수정

    // 회원 삭제
}
