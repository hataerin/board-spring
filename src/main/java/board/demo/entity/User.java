package board.demo.entity;

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


}
