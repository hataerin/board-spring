package board.demo.dao;

import board.demo.model.User;
import board.demo.model.UserAddressDto;
import board.demo.model.UserDto;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDao")
@Slf4j
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    @Resource(name = "readSqlSessionTemplate")
    private final SqlSession readSqlSession;

    @Qualifier("writeSqlSessionTemplate")
    @Resource(name = "writeSqlSessionTemplate")
    private final SqlSession writeSqlSession;

    private final String findAll = "board.demo.mapper.read.ReadUserMapper.findAll";
    private final String findAllDetail = "board.demo.mapper.read.ReadUserMapper.findAllDetail";
    private final String findById = "board.demo.mapper.read.ReadUserMapper.findById";
    private final String createUser = "board.demo.mapper.write.WriteUserMapper.createUser";
    private final String updateUser = "board.demo.mapper.write.WriteUserMapper.updateUser";
    private final String deleteUser = "board.demo.mapper.write.WriteUserMapper.deleteUser";


    @Override
    public List<User> findAll() {
        List<User> userList = this.readSqlSession.selectList(findAll);

        log.error(userList.size()+"");

        return userList;
    }

    @Override
    public UserAddressDto findById(Integer userId) {
        UserAddressDto userAddressDto = this.readSqlSession.selectOne(findById, userId);

        return userAddressDto;
    }

    @Override
    public void saveUser(UserDto userDto) {
        this.writeSqlSession.insert(createUser, userDto);
    }

    @Override
    public void updateUser(User user) {
        this.writeSqlSession.update(updateUser, user);
    }

    @Override
    public void deleteUser(Integer userId) {
        this.writeSqlSession.delete(deleteUser, userId);
    }
}
