package board.demo.domain;

import board.demo.entity.Board;
import lombok.Builder;
import lombok.Data;

@Data
public class BoardDto {

    private Long num;
    private String title;
    private String content;
    private Integer writer;

    public Board toEntity() {
        Board board = Board.builder()
                .id(this.num)
                .title(this.title)
                .content(this.content)
                .writer(this.writer)
                .build();
        return board;
    }

    @Builder //builder사용하는거 좋음
    public BoardDto(
            Long num,
            String title,
            String content,
            Integer writer) {
        this.num = num;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
