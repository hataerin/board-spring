package board.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    // 회원id
    private Integer id;

    // 이름
    private String name;

    // 메일
    private String email;

    // 성별
    private Integer gender;

    // 주소id
    private Integer id;

    // 회원id
    private Integer userId;

    // 우편번호
    private Integer zipCode;

    // 상세주소
    private String detailAddress;
}
