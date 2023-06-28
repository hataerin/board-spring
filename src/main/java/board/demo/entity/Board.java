package board.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "board")
public class Board {


    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardId; // 게시글id

    private String title; // 제목

    private String content; // 내용

    @ManyToOne
    @JoinColumn(name = "writer", insertable = false, updatable = false) //컬럼명
    private User writer; // 작성자

//    @Setter
//    @Column(name = "writer")
//    private Long writerId;
}
