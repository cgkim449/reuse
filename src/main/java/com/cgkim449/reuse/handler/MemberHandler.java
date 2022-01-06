package com.cgkim449.reuse.handler;

import java.io.IOException;
import java.sql.Date;
import com.cgkim449.util.Prompt;

public class MemberHandler {

  static class Member {
    int no;
    String name;
    String email;
    String password;
    String photo;
    String tel;
    Date registeredDate;
  }

  static final int LENGTH = 100;
  static Member[] list = new Member[LENGTH];
  static int size = 0;

  public static void add() throws IOException {
    System.out.println("[회원 등록]");
    
    Member member = new Member();
    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new java.sql.Date(System.currentTimeMillis());
    
    list[size++] = member;
  }
  
  public static void list() {
    System.out.println("[회원 목록]");
    
    for (int i = 0; i < size; i++) {
      Member member = list[i];
      System.out.printf("%d, %s, %s, %s, %s\n",
          member.no, 
          member.name, 
          member.email, 
          member.tel, 
          member.registeredDate);
    }
  }
  
  public static Member findByName(String name) {
    for (int i = 0; i < size; i++) {
      Member member = list[i];
      if (member.name.equals(name)) {
        return member;
      }
    }
    return null;
  }
}