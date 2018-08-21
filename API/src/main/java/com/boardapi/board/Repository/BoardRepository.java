package com.boardapi.board.Repository;

import com.boardapi.board.Model.Board;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {

  List<Board> findAllByCategoryNo(int categoryNo);

  List<Board> findAllByCategoryNo(int categoryNo, Pageable Pageable);

  Board findBoardByCategoryNoAndBoardNo(int categoryNo, int boardNo);
}
