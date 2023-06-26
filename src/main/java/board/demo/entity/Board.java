package board.demo.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Board {
    // 게시글id
    private Long id;

    // 제목
    private String title;

    // 내용
    private String content;

    // 작성자
    private Integer writer;

    @Builder
    public Board(Long id,
                 String title,
                 String content,
                 Integer writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
