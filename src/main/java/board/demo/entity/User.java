package board.demo.entity;

import board.demo.model.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@RequiredArgsConstructor
@Getter
@Setter
@Table("user")
public class User {

    @Id
    @Column("user_id")
    private Integer userId; // 회원id

    private String name; // 이름

    private String email; // 메일

    private Integer gender; // 성별

    @Builder
    private User (Integer userId,
                     String name,
                     String email,
                     Integer gender) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public UserDto toDto(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .gender(user.getGender())
                .build();
    }


}
