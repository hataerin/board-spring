package board.demo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private Integer id; // 회원id

    private String name; // 이름

    private String email; // 메일

    private Integer gender; // 성별

    public UserDto toDto() {
        return UserDto.builder()
                .id(this.id)
                .name(this.name)
                .email(this.email)
                .gender(this.gender)
                .build();
    }

    @Builder
    private User (Integer id,
                  String name,
                  String email,
                  Integer gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
