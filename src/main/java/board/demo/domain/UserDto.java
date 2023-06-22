package board.demo.domain;

import board.demo.entity.User;
import lombok.*;

@Data //Getter + Setter + ToString + EqualsAndHashCode + RequiredArgsConstructor
public class UserDto {


    private Integer userId; // 회원id
    private String name; // 이름
    private String email; // 메일
    private Integer gender; // 성별
    private Integer zipCode; // 우편번호
    private String detailAddress; // 상세주소

    public User toEntity() {
        User user = User.builder()
                .id(this.userId)
                .name(this.name)
                .email(this.email)
                .gender(this.gender)
                .zipCode(this.zipCode)
                .detailAddr(this.detailAddress)
                .build();

        return user;
    }

    @Builder
    public UserDto(
            Integer userId,
            String name,
            String email,
            Integer gender,
            Integer zipCode,
            String detailAddress) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.zipCode = zipCode;
        this.detailAddress = detailAddress;
    }
}
