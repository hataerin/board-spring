package board.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.relational.core.mapping.Table;

@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
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


}
