package board.demo.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Board {
    // 게시글id
    private Integer id;

    // 제목
    private String title;

    // 내용
    private String content;

    // 작성자
    private Integer writer;
}
