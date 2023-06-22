package board.demo.service;


import board.demo.domain.BoardDto;
import board.demo.entity.Board;
import board.demo.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    //게시판 목록 조회
    public List<BoardDto> getAllBoards() {
        List<Board> boardList = this.boardRepository.findAllBoard();

        if (boardList.isEmpty()) {
            return null;
        }

        List<BoardDto> boardDtoList = new ArrayList<BoardDto>();

        for (Board board : boardList) {
            BoardDto boardDto = BoardDto.builder()
                    .boardId(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .build();

            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    //게시판 상세 조회
    public BoardDto getBoardById(Long id) {
        Board board = this.boardRepository.findBoardById(id);

        if (board == null) {
            return null;
        }

        BoardDto boardDto = BoardDto.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .build();

        return boardDto;
    }

    //게시판 등록
    public void createBoard(BoardDto boardDto) {
        this.boardRepository.saveBoard(boardDto.toEntity());
    }

    //게시판 수정
    public void modifyBoard(Long id, BoardDto boardDto) {
        this.boardRepository.editBoard(id, boardDto.toEntity());
    }

    //게시판 삭제
    public void removeBoard(Long id) {
        this.boardRepository.deleteBoard(id);
    }

}
