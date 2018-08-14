package com.boardapi.board.Controller;

import com.boardapi.board.Model.Board;
import com.boardapi.board.Service.BoardService;
import java.util.List;
import javax.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
@Slf4j
public class BoardController {

  @Autowired
  private BoardService boardService;

  @GetMapping
  public ResponseEntity<String> get() {
    return ResponseEntity.ok("OK");
  }

  @GetMapping("{categoryNo}")
  public ResponseEntity<List<Board>> getBoards(@PathVariable int categoryNo) {
    List<Board> response = boardService.getBoardsByCategoryNo(categoryNo);
    return ResponseEntity.ok(response);
  }

  @GetMapping("{categoryNo}/board/{boardNo}")
  public ResponseEntity<Board> getBoard(@PathVariable int categoryNo,
      @PathVariable int boardNo) {
    Board response = boardService.getBoardByCategoryNoAndBoardNo(categoryNo, boardNo);
    return ResponseEntity.ok(response);
  }

}
