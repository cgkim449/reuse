package com.cgkim449.reuse.handler;

import com.cgkim449.reuse.domain.Board;
import com.cgkim449.reuse.domain.Member;
import com.cgkim449.util.ArrayList;
import com.cgkim449.util.Prompt;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MemberHandler {

  ArrayList<Member> memberList = new ArrayList<>();

  public void add() throws IOException {
    System.out.println("[회원 등록]");

    Member member = new Member();
    member.setNo(Prompt.inputInt("번호? "));
    member.setName(Prompt.inputString("이름? "));
    member.setEmail(Prompt.inputString("이메일? "));
    member.setPassword(Prompt.inputString("암호? "));
    member.setPhoto(Prompt.inputString("사진? "));
    member.setTel(Prompt.inputString("전화? "));
    member.setRegisteredDate(new java.sql.Date(System.currentTimeMillis()));

    memberList.add(member);
  }

  public void list() {
    System.out.println("[회원 목록]");

    Member[] members = memberList.toArray(Member[].class);

    for (Member member : members) {
      System.out.printf("%d, %s, %s, %s, %s\n",
              member.getNo(),
              member.getName(),
              member.getEmail(),
              member.getTel(),
              member.getRegisteredDate());
    }
  }

  public Member findByName(String name) {
    Member[] members = memberList.toArray(Member[].class);

    for (Member member : members) {
      if (member.getName().equals(name)) {
        return member;
      }
    }
    return null;
  }
}