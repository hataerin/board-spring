package board.demo.entity;

import board.demo.model.BoardDto;
import board.demo.model.UserDto;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Board {

    @Id
    @Column("board_id")
    private Integer boardId;
    private String title;
    private String content;
    private Integer writer;
    private Integer editor;

    @Builder
    private Board (Integer boardId,
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


    public BoardDto toDto(Board board) {
        return BoardDto.builder()
                .boardId(board.boardId)
                .title(board.title)
                .content(board.content)
                .writer(board.writer)
                .editor(board.editor)
                .build();
    }
}
