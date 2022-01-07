package com.cgkim449.reuse;

import com.cgkim449.reuse.handler.BoardHandler;
import com.cgkim449.reuse.handler.MemberHandler;
import com.cgkim449.util.Prompt;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        BoardHandler boardHandler = new BoardHandler();
        BoardHandler boardHandler2 = new BoardHandler();
        BoardHandler boardHandler3 = new BoardHandler();
        BoardHandler boardHandler4 = new BoardHandler();
        BoardHandler boardHandler5 = new BoardHandler();
        BoardHandler boardHandler6 = new BoardHandler();

        MemberHandler memberHandler = new MemberHandler();

        loop:
        while (true) {
            String command = Prompt.inputString("명령: ");

            switch (command) {
                case "/member/add": memberHandler.add(); break;
                case "/member/list": memberHandler.list(); break;
                case "/board/add": boardHandler.add(); break;
                case "/board/list": boardHandler.list(); break;
                case "/board2/add": boardHandler2.add(); break;
                case "/board2/list": boardHandler2.list(); break;
                case "/board3/add": boardHandler3.add(); break;
                case "/board3/list": boardHandler3.list(); break;
                case "/board4/add": boardHandler4.add(); break;
                case "/board4/list": boardHandler4.list(); break;
                case "/board5/add": boardHandler5.add(); break;
                case "/board5/list": boardHandler5.list(); break;
                case "/board6/add": boardHandler6.add(); break;
                case "/board6/list": boardHandler6.list(); break;
                case "quit":
                case "exit":
                    System.out.println("bye");
                    break loop;
                default: System.out.println("실행할 수 없는 명령입니다.");
            }
            System.out.println();
        }

        Prompt.close();
    }
}
