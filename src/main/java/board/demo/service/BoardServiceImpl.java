package board.demo.service;

import board.demo.mapper.BoardMapper;
import board.demo.model.Board;
import board.demo.model.BoardDetailDto;
import board.demo.model.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

    private BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    // 게시판 목록 조회
    @Override
    @Cacheable(value = "board", key = "'all'")
    @Transactional
    public List<Board> findAll() {
        log.warn("캐시적용: 게시판 상세조회");
        return boardMapper.findAll();
    }

    // 게시판 상세 조회
    @Override
    @Cacheable(value = "board", key = "#id")
    @Transactional
    public Board findById(Integer id) {
        log.warn("캐시적용: 게시판 상세조회");
        return boardMapper.findById(id);
    }

    @Override
    @Cacheable(value = "board", key = "#id")
    @Transactional
    public BoardDetailDto findDetailById(Integer id) {
        return boardMapper.findDetailById(id);
    }

    // 게시판 등록
    @Override
    @CacheEvict(value = "board", key = "'all'")
    @Transactional
    public void createBoard(BoardDto boardDto) {
        boardMapper.createBoard(boardDto);
    }

    // 게시판 수정
    @Override
    @Caching(evict = {
            @CacheEvict(value = "board", key = "'all'"),
            @CacheEvict(value = "board", key = "#id")
    })
    @Transactional
    public void updateBoard(Integer id, BoardDto boardDto) {
        boardMapper.updateBoard(id, boardDto);
    }

    // 게시판 삭제
    @Override
    @Caching(evict = {
            @CacheEvict(value = "board", key = "'all'"),
            @CacheEvict(value = "board", key = "#id")
    })
    @Transactional
    public void deleteBoard(Integer id) {
        boardMapper.deleteBoard(id);
    }

}
