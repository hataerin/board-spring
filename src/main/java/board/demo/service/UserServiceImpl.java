package board.demo.service;

import board.demo.mapper.UserMapper;
import board.demo.model.User;
import board.demo.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public User findById(Integer id) {

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
