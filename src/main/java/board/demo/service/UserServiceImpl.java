package board.demo.service;

import board.demo.mapper.UserMapper;
import board.demo.model.User;
import board.demo.model.UserAddressDto;
import board.demo.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
    @Cacheable(value = "user", key = "'all'") // 캐시에 처음 데이터 넣으면 DB변경되어도 저장된 캐시만 가져옴
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
    @CacheEvict(value = "user", key = "'all'")
    public void createUser(UserDto userDto) {
        userMapper.createUser(userDto);
    }

    @Override
    @CachePut(value = "user", key = "#id")
    @CacheEvict(value = "user", key = "'all'")
    @Transactional
    public void updateUser(Integer id,UserDto userDto) {
        userMapper.updateUser(id, userDto);
    }


    @Override
    @Caching(evict = {
            @CacheEvict(value = "user", key = "'all'"),
            @CacheEvict(value = "user", key = "#id")
    })
    @Transactional
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }
}
