package board.demo.service;

import board.demo.mapper.master.MasterBoardMapper;
//import board.demo.mapper.slave.BoardMapper;
import board.demo.mapper.slave.SlaveBoardMapper;
import board.demo.mapper.slave.SlaveUserMapper;
import board.demo.model.Board;
import board.demo.model.BoardDetailDto;
import board.demo.model.BoardDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    private final MasterBoardMapper masterBoardMapper; //CUD
    private final SlaveBoardMapper slaveBoardMapper; // R

    public BoardServiceImpl(MasterBoardMapper masterBoardMapper, SlaveBoardMapper slaveBoardMapper) {
        this.masterBoardMapper = masterBoardMapper;
        this.slaveBoardMapper = slaveBoardMapper;
    }

    // 게시판 목록 조회
    @Override
    @Transactional
    public List<Board> findAll() {
        return masterBoardMapper.findAll();
    }

    // 게시판 상세 조회
    @Override
    @Transactional
    public Board findById(Integer id) {
        return masterBoardMapper.findById(id);
    }

    @Override
    @Transactional
    public BoardDetailDto findDetailById(Integer id) {
        return masterBoardMapper.findDetailById(id);
    }

    // 게시판 등록
    @Override
    @Transactional
    public void createBoard(BoardDto boardDto) {
        masterBoardMapper.createBoard(boardDto);
    }

    // 게시판 수정
    @Override
    @Transactional
    public void updateBoard(Integer id, BoardDto boardDto) {
        masterBoardMapper.updateBoard(id, boardDto);
    }

    // 게시판 삭제
    @Override
    @Transactional
    public void deleteBoard(Integer id) {
        masterBoardMapper.deleteBoard(id);
    }

}
