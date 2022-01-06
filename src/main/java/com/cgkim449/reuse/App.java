package com.cgkim449.reuse;

import com.cgkim449.reuse.handler.BoardHandler;
import com.cgkim449.reuse.handler.MemberHandler;
import com.cgkim449.util.Prompt;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        loop:
        while (true) {
            String command = Prompt.inputString("명령: ");

            switch (command) {
                case "/member/add": MemberHandler.add(); break;
                case "/member/list": MemberHandler.list(); break;
                case "/board/add": BoardHandler.add(); break;
                case "/board/list": BoardHandler.list(); break;
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
