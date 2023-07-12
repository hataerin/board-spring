package board.demo.model;

import board.demo.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardDto {

    private Integer num;
    private String title;
    private String content;
    private Integer writeName;
    private Integer modifyName;

    @Builder
    private BoardDto(Integer num,
                     String title,
                     String content,
                     Integer writeName,
                     Integer modifyName) {
        this.num = num;
        this.title = title;
        this.content = content;
        this.writeName = writeName;
        this.modifyName = modifyName;
    }

    public Board toEntity() {
        Board board = Board.builder()
                .boardId(this.num)
                .title(this.title)
                .content(this.content)
                .writer(this.writeName)
                .editor(this.modifyName)
                .build();
        return board;
    }
    public Board toEntity(Integer boardId) {
        Board board = Board.builder()
                .boardId(boardId)
                .title(this.title)
                .content(this.content)
                .writer(this.writeName)
                .editor(this.modifyName)
                .build();
        return board;
    }
}
