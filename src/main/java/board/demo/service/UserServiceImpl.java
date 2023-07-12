package board.demo.service;

import board.demo.mapper.read.ReadUserMapper;
import board.demo.mapper.write.WriteUserMapper;
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

    private ReadUserMapper readUserMapper;
    private WriteUserMapper writeUserMapper;

    public UserServiceImpl(ReadUserMapper readUserMapper, WriteUserMapper writeUserMapper) {
        this.readUserMapper = readUserMapper;
        this.writeUserMapper = writeUserMapper;
    }


    @Override
    @Transactional
    public List<User> findAll() {
        return readUserMapper.findAll();
    }

    @Override
    @Transactional
    public List<UserAddressDto> findAllDetail() {
        return readUserMapper.findAllDetail();
    }

    @Override
    @Transactional
    public UserAddressDto findById(Integer id) {

        return readUserMapper.findById(id);
    }

    @Override
    @Transactional
    public void createUser(UserDto userDto) {
        writeUserMapper.createUser(userDto);
    }

    @Override
    @Transactional
    public void updateUser(Integer id,UserDto userDto) {
        writeUserMapper.updateUser(id, userDto);
    }


    @Override
    @Transactional
    public void deleteUser(Integer id) {
        writeUserMapper.deleteUser(id);
    }
}
