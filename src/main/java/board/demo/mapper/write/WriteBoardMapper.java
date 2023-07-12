package board.demo.mapper.write;

import board.demo.model.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WriteBoardMapper {

    // 게시판 등록
    void createBoard(@Param("board") BoardDto board);

    // 게시판 수정
    void updateBoard(@Param("id") Integer id, @Param("board") BoardDto board);

    // 게시판 삭제
    void deleteBoard(@Param("id") Integer id);
}
