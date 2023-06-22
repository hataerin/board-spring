package board.demo.domain;

import board.demo.entity.Board;
import lombok.Builder;
import lombok.Data;

@Data
public class BoardDto {

    private Integer boardId;
    private String title;
    private String content;
    private Integer writer;

    public Board toEntity() {
        Board board = Board.builder()
                .id(this.boardId)
                .title(this.title)
                .content(this.content)
                .writer(this.writer)
                .build();
        return board;
    }

    @Builder
    public BoardDto(
            Integer boardId,
            String title,
            String content,
            Integer writer) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
