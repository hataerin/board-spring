package board.demo.repository;

import board.demo.entity.Board;
import board.demo.entity.BoardSQLProps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class BoardRepository {

    private final JdbcTemplate jdbcTemplate;
    private final BoardSQLProps boardSQLProps;
    //RowMapper: 이름과 맞는 메서드와 매칭 (Object Relation Mapping)
    private final RowMapper<Board> boardMapper = BeanPropertyRowMapper.newInstance(Board.class);


    public BoardRepository(JdbcTemplate jdbcTemplate, BoardSQLProps boardSQLProps) {
        this.jdbcTemplate = jdbcTemplate;
        this.boardSQLProps = boardSQLProps;
    }

    //게시판 목록 조회
    public List<Board> findAllBoard() {

        StringBuilder SQL = new StringBuilder(boardSQLProps.getSELECT_ALL()); //SQL 변수명 고치기 -> sql

        return this.jdbcTemplate.query(SQL.toString(), boardMapper);
    }

    //게시판 상세 조회
    public Board findBoardById(Long id) {
        StringBuilder SQL = new StringBuilder(boardSQLProps.getSELECT_BY_ID());

        return this.jdbcTemplate.queryForObject(SQL.toString(), boardMapper, id);
    }

    // 게시판 작성자별 조회


    //게시판 등록
    public void saveBoard(Board board) {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(boardSQLProps.getINSERT_BOARD());

        //개선사항: 입력값이 많을 경우? 객체로 넘기기 -> JDBC Template +
        this.jdbcTemplate.update(SQL.toString(),
                board.getTitle(),
                board.getContent(),
                board.getWriter());
    }

    //게시판 수정
    public void editBoard(Long id, Board board) {

        StringBuilder SQL = new StringBuilder(boardSQLProps.getUPDATE_BY_ID());

        this.jdbcTemplate.update(SQL.toString(),
                board.getTitle(),
                board.getContent(),
                board.getWriter(),
                id);
    }

    //게시판 삭제
    public void deleteBoard(Long id) {

        StringBuilder SQL = new StringBuilder(boardSQLProps.getDELETE_BY_ID());

        this.jdbcTemplate.update(SQL.toString(), id);
    }
}
