package board.demo.service;

import board.demo.mapper.UserMapper;
import board.demo.model.User;
import board.demo.model.UserAddressDto;
import board.demo.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable("user") // 캐시에 처음 데이터 넣으면 DB변경되어도 저장된 캐시만 가져옴
    @Transactional
    public List<UserAddressDto> findAllDetail() {
        log.warn("캐시적용: 전체조회");
        return userMapper.findAllDetail();
    }

    @Override
    @Cacheable(value = "user", key = "#id")
    @Transactional
    public UserAddressDto findById(Integer id) {
        log.warn("캐시적용: 상세조회");
        return userMapper.findById(id);
    }

    @Override
    @Transactional
    @CacheEvict(value = "user", allEntries = true) //메소드에서 어떤 파라미터를 받더라도 해당 캐시 데이터 모두 삭제
    public void createUser(UserDto userDto) {
        userMapper.createUser(userDto);
    }

    @Override
//    @CachePut(value = "user", key = "#id")
    @CacheEvict(value = "user", allEntries = true)
    @Transactional
    public void updateUser(Integer id,UserDto userDto) {
        userMapper.updateUser(id, userDto);
    }


    @Override
    @CacheEvict(value = "user", allEntries = true)
    @Transactional
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }
}
