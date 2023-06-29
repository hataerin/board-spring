package board.demo.repository;

import board.demo.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    // 회원 목록 조회

    // 회원 상세 조회
//    @Query(value = "select * from user where user_id = :id")
//    public User findByUserId(@Param("id")Integer id);

    // 회원 등록
//    @Query(value = UserSQL.INSERT_USER)
//    public User saveUser();

    // 회원 수정

    // 회원 삭제
}
