package com.boardapi.board.Service;

import com.boardapi.board.Model.Board;
import com.boardapi.board.Repository.BoardRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  public List<Board> getBoardsByCategoryNo(int categoryNo, Integer pageNumber, Integer pageSize) {
    //TODO pageNumber 예외처리
    if (pageNumber == null) {
      return boardRepository.findAllByCategoryNo(categoryNo);
    }
    if (pageSize == null) {
      pageSize = 10; //default
    }

    return boardRepository
        .findAllByCategoryNo(categoryNo, new PageRequest(pageNumber - 1, pageSize));
  }

  public Board getBoardByCategoryNoAndBoardNo(int categoryNo, int boardNo) {
    return boardRepository.findBoardByCategoryNoAndBoardNo(categoryNo, boardNo);
  }
}
