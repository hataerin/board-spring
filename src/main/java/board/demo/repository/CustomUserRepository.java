package board.demo.repository;

import board.demo.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface CustomUserRepository {

    @Query("select * from user where user_id = :userId")
    User findByUserId(@Param("userId") Integer id);

}
