package board.demo.dao;

import board.demo.model.User;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDao")
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    @Resource(name = "readSqlSessionTemplate")
    private final SqlSession readSqlSession;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer userId) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Integer userId) {

    }
}
