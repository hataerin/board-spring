package board.demo.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:board/board.xml")
@ConfigurationProperties(prefix = "board")
@Data
public class BoardSQLProps {
    private String SELECT_ALL;
    private String SELECT_BY_ID;

    private String INSERT_BOARD;

    private String UPDATE_BY_ID;

    private String DELETE_BY_ID;

}
