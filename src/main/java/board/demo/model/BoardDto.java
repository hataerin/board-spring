package board.demo.model;

import board.demo.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardDto {

    private Integer boardId;
    private String title;
    private String content;
    private Integer writer;
    private Integer editor;

    @Builder
    private BoardDto(Integer boardId,
                     String title,
                     String content,
                     Integer writer,
                     Integer editor) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.editor = editor;
    }

    public Board toEntity() {
        Board board = Board.builder()
                .boardId(this.boardId)
                .title(this.title)
                .content(this.content)
                .writer(this.writer)
                .editor(this.editor)
                .build();
        return board;
    }
    public Board toEntity(Integer boardId) {
        Board board = Board.builder()
                .boardId(boardId)
                .title(this.title)
                .content(this.content)
                .writer(this.writer)
                .editor(this.editor)
                .build();
        return board;
    }
}
