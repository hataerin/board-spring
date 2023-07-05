package board.demo.mapper.slave;

import board.demo.model.Board;
import board.demo.model.BoardDetailDto;

import java.util.List;


public interface SlaveBoardMapper {

    // 게시판 목록 조회
    List<Board> findAll();

    // 게시판 상세 조회
    Board findById(Integer id);
    BoardDetailDto findDetailById(Integer id);

}
