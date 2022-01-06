package com.cgkim449.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Date;

public class Prompt {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static String inputString(String title) throws IOException {
    bw.write(title);
    bw.flush();
    return br.readLine();
  }

  public static int inputInt(String title) throws IOException {
    return Integer.parseInt(inputString(title));
  }

  public static Date inputDate(String title) throws IOException {
    return Date.valueOf(inputString(title));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }
}