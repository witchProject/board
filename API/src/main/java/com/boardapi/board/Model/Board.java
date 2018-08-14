package com.boardapi.board.Model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "board")
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int boardNo;

  @Column
  private String name;

  @Column
  private String content;

  @Column
  private int visitorCnt;

  @Column
  private Integer memberNo;

  @Column
  private String memberId;

  @Column
  private LocalDateTime registerYmdt;

  @Column
  private int categoryNo;

}
