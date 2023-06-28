package board.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "board")
public class Board {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardId; // 게시글id

    private String title; // 제목

    private String content; // 내용

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Integer writer; // 작성자
}
