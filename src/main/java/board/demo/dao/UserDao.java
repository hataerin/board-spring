package board.demo.dao;

import board.demo.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findById(Integer userId);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);
}
