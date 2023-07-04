//package board.demo.mapper.slave;
//
//import board.demo.model.Board;
//import board.demo.model.BoardDetailDto;
//import board.demo.model.BoardDto;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//
//import java.util.List;
//
//
//public interface BoardMapper {
//
//    // 게시판 목록 조회
//    List<Board> findAll();
//
//    // 게시판 상세 조회
//    Board findById(Integer id);
//    BoardDetailDto findDetailById(Integer id);
//
//    // 게시판 등록
//    void createBoard(@Param("board") BoardDto board);
//
//    // 게시판 수정
//    void updateBoard(@Param("id") Integer id, @Param("board") BoardDto board);
//
//    // 게시판 삭제
//    void deleteBoard(@Param("id") Integer id);
//}
