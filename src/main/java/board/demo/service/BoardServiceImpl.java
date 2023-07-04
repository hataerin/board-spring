//package board.demo.service;
//
//import board.demo.mapper.BoardMapper;
//import board.demo.model.Board;
//import board.demo.model.BoardDto;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class BoardServiceImpl implements BoardService{
//
//    private BoardMapper boardMapper;
//
//    public BoardServiceImpl(BoardMapper boardMapper) {
//        this.boardMapper = boardMapper;
//    }
//
//    // 게시판 목록 조회
//    @Override
//    @Transactional
//    public List<Board> findAll() {
//        return boardMapper.findAll();
//    }
//
//    // 게시판 상세 조회
//    @Override
//    @Transactional
//    public Board findById(Integer id) {
//        return boardMapper.findById(id);
//    }
//
//    // 게시판 등록
//    @Override
//    @Transactional
//    public void createBoard(BoardDto boardDto) {
//        boardMapper.createBoard(boardDto);
//    }
//
//    // 게시판 수정
//    @Override
//    @Transactional
//    public void updateBoard(Integer id, BoardDto boardDto) {
//        boardMapper.updateBoard(id, boardDto);
//    }
//
//    // 게시판 삭제
//    @Override
//    @Transactional
//    public void deleteBoard(Integer id) {
//        boardMapper.deleteBoard(id);
//    }
//
//}
