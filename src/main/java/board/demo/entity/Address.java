package board.demo.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data //Getter + Setter + ToString + EqualsAndHashCode + RequiredArgsConstructor
public class Address {

    // 주소id
    private Integer id;

    // 회원id
    private Integer userId;

    // 우편번호
    private Integer zipCode;

    // 상세주소
    private String detailAddress;

}
