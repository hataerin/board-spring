package board.demo.service;

import board.demo.mapper.master.MasterUserMapper;
import board.demo.mapper.slave.SlaveUserMapper;
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

    private final MasterUserMapper masterUserMapper;
    private final SlaveUserMapper slaveUserMapper;

    public UserServiceImpl(MasterUserMapper masterUserMapper, SlaveUserMapper slaveUserMapper) {
        this.masterUserMapper = masterUserMapper;
        this.slaveUserMapper = slaveUserMapper;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return masterUserMapper.findAll();
    }

    @Override
    @Transactional
    public List<UserAddressDto> findAllDetail() {
        return masterUserMapper.findAllDetail();
    }

    @Override
    @Transactional
    public UserAddressDto findById(Integer id) {

        return masterUserMapper.findById(id);
    }

    @Override
    @Transactional
    public void createUser(UserDto userDto) {
        masterUserMapper.createUser(userDto);
    }

    @Override
    @Transactional
    public void updateUser(Integer id,UserDto userDto) {
        masterUserMapper.updateUser(id, userDto);
    }


    @Override
    @Transactional
    public void deleteUser(Integer id) {
        masterUserMapper.deleteUser(id);
    }
}
