package board.demo.repository;

import board.demo.entity.User;
import board.demo.entity.UserSQLProps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Slf4j
@Repository
public class UserAddressRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UserSQLProps userSQLProps;

    private final RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);


    public UserAddressRepository(JdbcTemplate jdbcTemplate, UserSQLProps userSQLProps, UserSQLProps userSQLProps1) {
        this.jdbcTemplate = jdbcTemplate;
        this.userSQLProps = userSQLProps1;
    }

    //회원 목록 조회
    public List<User> findAllUsers() {
        StringBuilder SQL = new StringBuilder(userSQLProps.getSELECT_ALL());

        return this.jdbcTemplate.query(SQL.toString(), userRowMapper);
    }

    //회원 상세 조회
    public User findUserById(String userId) {
        StringBuilder SQL = new StringBuilder(userSQLProps.getSELECT_BY_USER_ID());

        return this.jdbcTemplate.queryForObject(SQL.toString(), userRowMapper, userId);
    }

    //회원 등록
    public void saveUser(User user) {

        this.jdbcTemplate.update(userSQLProps.getINSERT_USER(),
                user.getName(),
                user.getEmail(),
                user.getGender());

        int userId = this.jdbcTemplate.queryForObject(userSQLProps.getSELECT_LAST(),Integer.class);

        this.jdbcTemplate.update(userSQLProps.getINSERT_ADDRESS(),
                userId,
                user.getZipCode(),
                user.getDetailAddr());
    }

    //회원 수정
    public void editUser(String userId, User user) {
        StringBuilder userSQL = new StringBuilder(userSQLProps.getUPDATE_USER_BY_USER_ID());
        StringBuilder addressSQL = new StringBuilder(userSQLProps.getUPDATE_ADDRESS_BY_USER_ID());

        this.jdbcTemplate.update(userSQL.toString(),
                user.getName(),
                user.getEmail(),
                user.getGender(), userId);

        this.jdbcTemplate.update(addressSQL.toString(),
                user.getZipCode(),
                user.getDetailAddr(),
                userId);
    }

    //회원 삭제
    public void deleteUser(String userId) {
        StringBuilder SQL = new StringBuilder(userSQLProps.getDELETE_BY_USER_ID());

        this.jdbcTemplate.update(SQL.toString(), userId);
    }
}
