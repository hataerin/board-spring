package board.demo.model;

import board.demo.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
public class BoardDto {

    private Integer num;
    private String title;
    private String contents;
    private Integer writeName;
    private Integer modifyName;


    @Builder
    private BoardDto(Integer num,
                     String title,
                     String contents,
                     Integer writeName,
                     Integer modifyName) {
        this.num = num;
        this.title = title;
        this.contents = contents;
        this.writeName = writeName;
        this.modifyName = modifyName;
    }

    public Board toEntity() {
        Board board = Board.builder()
                .boardId(this.num)
                .title(this.title)
                .content(this.contents)
                .writer(this.writeName)
                .editor(this.modifyName)
                .build();
        return board;
    }
    public Board toEntity(Integer boardId) {
        Board board = Board.builder()
                .boardId(boardId)
                .title(this.title)
                .content(this.contents)
                .writer(this.writeName)
                .editor(this.modifyName)
                .build();
        return board;
    }
}
