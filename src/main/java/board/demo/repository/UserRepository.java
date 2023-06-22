//package board.demo.repository;
//
//import board.demo.connection.DBConnectionUtil;
//import board.demo.entity.User;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Repository;
//
//import java.sql.*;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//@Repository
//@Slf4j
//public class UserRepository {
//
//    //회원 등록
//    public User save(User user) throws SQLException {
//        String sql1 = "insert into user (name, email, gender) values(?, ?, ?)";
////        String sql2 = "insert into address (user_id, zip_code, detail_addr) values(?, ?, ?)";
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            con = getConnection();
//            pstmt = con.prepareStatement(sql1);
//
//            pstmt.setString(1, user.getName()); //parameterIndex
//            pstmt.setString(2, user.getEmail());
//            pstmt.setInt(3, user.getGender());
//            pstmt.executeUpdate();
//
////            pstmt = con.prepareStatement(sql2);
////            pstmt.setInt(4, userAddressDto.getUserId());
////            pstmt.setInt(5, userAddressDto.getZipCode());
////            pstmt.setString(6, userAddressDto.getDetailAddress());
////            pstmt.executeUpdate();
//
//            return user;
//        } catch (SQLException e) {
//            log.error("db error", e);
//            throw e;
//        }finally {
//            close(con, pstmt, null);
//        }
//    }
//
//
//    //회원 목록 조회
//    public List<User> findAll(List<User> users) throws SQLException{
//        String sql = "select * from user";
//
//        Connection con = null; //DB와 연결
//        PreparedStatement pstmt = null; //DB에 쿼리 날림
//        ResultSet rs = null; //결과값
//
//        try {
//            con = getConnection();
//            pstmt = con.prepareStatement(sql);
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                User user = User.builder()
//                        .id(rs.getInt("id"))
//                        .name(rs.getString("name"))
//                        .email(rs.getString("email"))
//                        .gender(rs.getInt("gender"))
//                        .build();
//                users.add(user);
//            }
//
//            return users;
//        } catch (SQLException e) {
//            log.error("db error", e);
//            throw e;
//        } finally {
//            close(con, pstmt, rs);
//        }
//    }
//
//
//    //회원 상세 조회
//    public User findById(Integer userId) throws SQLException {
//        String sql = "select * from user where id = ?";
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            con = getConnection();
//            pstmt = con.prepareStatement(sql);
//            pstmt.setInt(1, userId);
//
//            rs = pstmt.executeQuery(); //조회할때는 executeQuery사용
//
//            if (rs.next()) {
//                User user = User.builder()
//                        .id(rs.getInt("id"))
//                        .name(rs.getString("name"))
//                        .email(rs.getString("email"))
//                        .gender(rs.getInt("gender"))
//                        .build();
//                return user;
//            } else {
//                throw new NoSuchElementException("member not found userId=" + userId);
//            }
//        } catch (SQLException e) {
//            log.error("db error", e);
//            throw e;
//        } finally {
//            close(con, pstmt, rs);
//        }
//    }
//
//
//    //회원 수정
//    public void update(Integer userId, String name, String email, Integer gender) throws SQLException {
//        String sql = "update user set name=?, email=?, gender=? where id=?";
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        User user = findById(userId);
//
//        try {
//            con = getConnection();
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, name);
//            pstmt.setString(2, email);
//            pstmt.setInt(3, gender);
//            pstmt.setInt(4, user.getId());
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            log.error("db error", e);
//            throw e;
//        } finally {
//            close(con, pstmt, null);
//        }
//    }
//
//
//    //회원 삭제
//    public void delete(Integer userId) throws SQLException {
//        String sql = "delete from user where id=?";
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            con = getConnection();
//            pstmt = con.prepareStatement(sql);
//            pstmt.setInt(1, userId);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            log.error("db error", e);
//            throw e;
//        } finally {
//            close(con, pstmt, null);
//        }
//    }
//
//
//    private void close(Connection con, Statement stmt, ResultSet rs) {
//        if (rs != null) {
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                log.info("error", e);
//            }
//        }
//        if (stmt != null) {
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                log.info("error", e);
//            }
//        }
//        if (con != null) {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                log.info("error", e);
//            }
//        }
//    }
//
//    private Connection getConnection() {
//        return DBConnectionUtil.getConnection();
//    }
//}
