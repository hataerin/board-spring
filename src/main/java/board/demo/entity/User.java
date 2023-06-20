package board.demo.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    // 회원id
    private Integer id;

    // 이름
    private String name;

    // 메일
    private String email;

    // 성별
    private Integer gender;

}
