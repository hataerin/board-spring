package board.demo.model;

import board.demo.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserDto {

    private Integer userId;
    private String name;
    private String email;
    private Integer gender;

    @Builder
    private UserDto (Integer userId,
                     String name,
                     String email,
                     Integer gender) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public User toEntity() {
        User user = User.builder()
                .userId(this.userId)
                .name(this.name)
                .email(this.email)
                .gender(this.gender)
                .build();
        return user;
    }
}
