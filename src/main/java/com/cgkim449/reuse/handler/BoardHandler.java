package com.cgkim449.reuse.handler;

import com.cgkim449.reuse.domain.Board;
import com.cgkim449.util.ArrayList;
import com.cgkim449.util.Prompt;

import java.io.IOException;
import java.sql.Date;

public class BoardHandler {

  ArrayList boardList = new ArrayList();

  public void add() throws IOException {
    System.out.println("[게시물 등록]");

    Board board = new Board();
    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setRegisteredDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    boardList.add(board);

    System.out.println("게시글을 등록하였습니다.");
  }

  public void list() {
    System.out.println("[게시물 목록]");

    Object[] boards = boardList.toArray();

    for (Object obj : boards) {
      Board board = (Board) obj;
      System.out.printf("%d, %s, %s, %s, %d\n",
          board.getNo(),
          board.getTitle(),
          board.getWriter(),
          board.getRegisteredDate(),
          board.getViewCount());
    }
  }
}