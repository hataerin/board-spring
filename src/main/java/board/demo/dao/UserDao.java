package board.demo.dao;

import board.demo.model.User;
import board.demo.model.UserAddressDto;
import board.demo.model.UserDto;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    UserAddressDto findById(Integer userId);

    void saveUser(UserDto userDto);

    void updateUser(User user);

    void deleteUser(Integer userId);
}
