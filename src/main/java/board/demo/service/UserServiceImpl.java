package board.demo.service;

import board.demo.mapper.master.UserMapper;
import board.demo.model.User;
import board.demo.model.UserAddressDto;
import board.demo.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    @Transactional
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    @Transactional
    public List<UserAddressDto> findAllDetail() {
        return userMapper.findAllDetail();
    }

    @Override
    @Transactional
    public UserAddressDto findById(Integer id) {

        return userMapper.findById(id);
    }

    @Override
    @Transactional
    public void createUser(UserDto userDto) {
        userMapper.createUser(userDto);
    }

    @Override
    @Transactional
    public void updateUser(Integer id,UserDto userDto) {
        userMapper.updateUser(id, userDto);
    }


    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }
}
