package board.demo.service;

import board.demo.entity.User;
import board.demo.model.UserDto;
import board.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 회원 목록 조회
    public List<UserDto> getAllUser() {
        List<User> userList = (List<User>) this.userRepository.findAll();

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
    public UserDto getUserById(Integer userId) {
        User user = this.userRepository.findById(userId).get();
//        User user = this.userRepository.findByUserId(userId);
        log.info(""+userId);

        if (user == null) {
            return null;
        }

        UserDto dto = UserDto.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .gender(user.getGender())
                .build();
        return dto;
//        return UserDto.builder().build();
    }



    // 회원 등록
    @Transactional
    public void createUser(UserDto dto) {
        this.userRepository.save(dto.toEntity());
    }
//    public void createUser(UserDto dto) {
//        this.userRepository.save(dto.toEntity());
//    }

    // 회원 수정
    @Transactional
    public void modifyUser(Integer userId, UserDto dto) {
        User before = this.userRepository.findById(userId).get();

        User user = User.builder()
                .userId(userId)
                .name(dto.getName())
                .email(dto.getEmail())
                .gender(dto.getGender())
                .build();
        this.userRepository.save(user);
    }

    // 회원 삭제
    @Transactional
    public void removeUser(Integer userId) {
        this.userRepository.deleteById(userId);
    }
}
