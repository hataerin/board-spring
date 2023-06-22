package board.demo.service;

import board.demo.domain.UserDto;
import board.demo.entity.User;
import board.demo.repository.UserAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor //생성자 주입
@Service
public class UserService {

//    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;


    //회원 목록 조회
    public List<UserDto> getAllUsers() {
        List<User> userList = this.userAddressRepository.findAllUsers();

        if (userList.isEmpty()) {
            return null;
        }

        List<UserDto> userDtoList = new ArrayList<UserDto>();

        for (User user : userList) {
            UserDto userDto = UserDto.builder()
                    .userId(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .gender(user.getGender())
                    .zipCode(user.getZipCode())
                    .detailAddress(user.getDetailAddr())
                    .build();
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    //회원 상세 조회
    public UserDto getUserById(String userId) {

        User user = this.userAddressRepository.findUserById(userId);

        if (user == null) {

            return null;
        }

        UserDto userDto = UserDto.builder()
                .userId(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .gender(user.getGender())
                .zipCode(user.getZipCode())
                .detailAddress(user.getDetailAddr())
                .build();

        return userDto;
    }

    //회원 등록
    public void saveUser(UserDto userDto) {
        this.userAddressRepository.saveUser(userDto.toEntity());
    }

    //회원 수정
    public void modifyUser(String userId, UserDto userDto) {

        this.userAddressRepository.editUser(userId, userDto.toEntity());
    }

    //회원 삭제
    public void deleteUser(String userId) {

        this.userAddressRepository.deleteUser(userId);
    }
}
