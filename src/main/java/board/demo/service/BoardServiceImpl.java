//package board.demo.service;
//
//import board.demo.mapper.read.ReadBoardMapper;
//import board.demo.mapper.write.WriteBoardMapper;
//import board.demo.model.Board;
//import board.demo.model.BoardDetailDto;
//import board.demo.model.BoardDto;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class BoardServiceImpl implements BoardService{
//
//    private ReadBoardMapper readBoardMapper;
//    private WriteBoardMapper writeBoardMapper;
//
//    public BoardServiceImpl(ReadBoardMapper readBoardMapper, WriteBoardMapper writeBoardMapper) {
//        this.readBoardMapper = readBoardMapper;
//        this.writeBoardMapper = writeBoardMapper;
//    }
//
//    // 게시판 목록 조회
//    @Override
//    @Transactional
//    public List<Board> findAll() {
//        return readBoardMapper.findAll();
//    }
//
//    // 게시판 상세 조회
//    @Override
//    @Transactional
//    public Board findById(Integer id) {
//        return readBoardMapper.findById(id);
//    }
//
//    @Override
//    @Transactional
//    public BoardDetailDto findDetailById(Integer id) {
//        return readBoardMapper.findDetailById(id);
//    }
//
//    // 게시판 등록
//    @Override
//    @Transactional
//    public void createBoard(BoardDto boardDto) {
//        writeBoardMapper.createBoard(boardDto);
//    }
//
//    // 게시판 수정
//    @Override
//    @Transactional
//    public void updateBoard(Integer id, BoardDto boardDto) {
//        writeBoardMapper.updateBoard(id, boardDto);
//    }
//
//    // 게시판 삭제
//    @Override
//    @Transactional
//    public void deleteBoard(Integer id) {
//        writeBoardMapper.deleteBoard(id);
//    }
//
//}
