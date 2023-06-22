//package board.demo.repository;
//
//import board.demo.dto.UserAddressDto;
//import board.demo.entity.User;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//@Slf4j
//class UserRepositoryTest {
//
//    UserRepository repository = new UserRepository();
//
//    static List<User> userList = new ArrayList<>();
//
//    User user = User.builder()
//            .name("apeach")
//            .email("apeach@osckorea.com")
//            .gender(2)
//            .build();
//
//
//    @Order(1)
//    @Test
//    void create() throws SQLException {
//        UserAddressDto userAddressDto = UserAddressDto.builder()
//                .build();
//        repository.save(userAddressDto);
//    }
//
//    @Order(2)
//    @Test
//    void findAll() throws SQLException {
//        userList = repository.findAll(userList);
//    }
//
//    @Order(3)
//    @Test
//    void findById() throws SQLException {
//        User user1 = userList.get(userList.size() - 1);
//        User findUser = repository.findById(user1.getId());
//        log.info("findUser={}", findUser);
//        assertThat(findUser.getName()).isEqualTo(user.getName());
//    }
//
//    @Order(4)
//    @Test
//    void update() throws SQLException {
//        String newName = "osc";
//        int id = user.getId();
//        repository.update(id, newName, newName + "@osckorea.com", 2);
//        User userAfter = repository.findById(id);
//        assertThat(newName).isEqualTo(userAfter.getName());
//    }
//
//    @Order(5)
//    @Test
//    void delete() throws SQLException {
//        int deleteId = user.getId();
//        repository.delete(deleteId);
//        assertThatThrownBy(() -> repository.findById(deleteId))
//                .isInstanceOf(NoSuchElementException.class);
//    }
//}