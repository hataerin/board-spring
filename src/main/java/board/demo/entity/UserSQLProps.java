package board.demo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:sql/user/user.xml")
@PropertySource("classpath:sql/user/address.xml")
@ConfigurationProperties(prefix = "user")
@Data
public class UserSQLProps {
    private String SELECT_ALL;
    private String SELECT_BY_USER_ID;

    private String INSERT_USER;
    private String SELECT_LAST;
    private String INSERT_ADDRESS;

    private String UPDATE_USER_BY_USER_ID;
    private String UPDATE_ADDRESS_BY_USER_ID;

    private String DELETE_BY_USER_ID;
}
