package board.demo.repository;

import board.demo.connection.DBConnectionUtil;
import board.demo.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Slf4j
@Repository
public class AddressRepository {

    public Address save(Integer userId, Address address) throws SQLException {
        String sql = "insert into address (user_id, zip_code, detail_addr) values(?, ?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, userId);
            pstmt.setInt(2, address.getZipCode());
            pstmt.setString(3, address.getDetailAddress());
            pstmt.executeUpdate();
            return address;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }


    }

    private void close (Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}
