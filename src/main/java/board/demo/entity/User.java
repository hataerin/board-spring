package board.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 DB에 위임. id값이 null로하면 auto_increment해줌
    private Integer userId; // 회원id

    private String name; // 이름

    private String email; // 메일

    private Integer gender; // 성별

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //LAZY(지연로딩): 기본적으로 연관관계 테이블을 조인하지 않고 조인이 필요한 경우에 Join을 합니다.
    private List<Board> boards;

//    @OneToOne(mappedBy = "owner")
//    private Integer addressId;

}

