package board.demo.service;

import board.demo.dto.UserDto;
import board.demo.entity.User;
import board.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원 목록 조히
    public List<UserDto> getAllUser() {
        List<User> userList = this.userRepository.findAll();

        if (userList.isEmpty()) {
            return null;
        }

        List<UserDto> dtoList = new ArrayList<UserDto>();

        for (User user : userList) {
            UserDto dto = UserDto.builder()
                    .userId(user.getUserId())
                    .name(user.getName())
                    .email(user.getEmail())
                            .gender(user.getGender())
                    .build();

            dtoList.add(dto);
        }

        return dtoList;
    }


    // 회원 상세 조회



    // 회원 등록



    // 회원 수정



    // 회원 삭제
}
