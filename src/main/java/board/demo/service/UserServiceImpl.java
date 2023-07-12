package board.demo.service;

import board.demo.dao.UserDao;
import board.demo.mapper.read.ReadUserMapper;
import board.demo.mapper.write.WriteUserMapper;
import board.demo.model.User;
import board.demo.model.UserAddressDto;
import board.demo.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;


    @Override
    public List<User> findAll() {
        List<User> userList = this.userDao.findAll();

        List<UserDto> dtoList = new ArrayList<UserDto>();

        return userList;
    }

    @Override
    public List<UserAddressDto> findAllDetail() {
        List<User> userList = this.userDao.findAll();

        List<UserAddressDto> dtoList = new ArrayList<UserAddressDto>();

        return dtoList;

    }

    @Override
    public UserAddressDto findById(Integer id) {
        UserAddressDto userAddressDto = this.userDao.findById(id);

        return userAddressDto;
    }

    @Override
    public void createUser(UserDto userDto) {
        this.userDao.saveUser(userDto);
    }

    @Override
    public void updateUser(Integer userId, UserDto userDto) {
        this.userDao.updateUser(userDto.toEntity(userId));
    }

    @Override
    public void deleteUser(Integer id) {
        this.userDao.deleteUser(id);
    }
}
