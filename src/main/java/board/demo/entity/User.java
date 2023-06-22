package board.demo.entity;

import lombok.*;


//@Data //Getter + Setter + ToString + EqualsAndHashCode + RequiredArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class User {
    // 회원id
    private Integer id;

    // 이름
    private String name;

    // 메일
    private String email;

    // 성별
    private Integer gender;

    // 우편번호
    private Integer zipCode;

    // 상세주소
    private String detailAddr;

    @Builder
    public User(Integer id,
                String name,
                String email,
                Integer gender,
                Integer zipCode,
                String detailAddr) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.zipCode = zipCode;
        this.detailAddr = detailAddr;
    }


}
