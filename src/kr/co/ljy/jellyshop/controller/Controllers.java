package kr.co.ljy.jellyshop.controller;

import java.util.Scanner;

public abstract class Controllers implements Controller {
   public Scanner sc = new Scanner(System.in);
   protected String input(String msg) {
      System.out.print(msg);
      return sc.nextLine();
   }
   
   protected String inputln(String msg) {
      System.out.print(msg);
      System.out.println();
      return sc.nextLine();
   }
   
   protected void printj(String ch) {
	   for (int i = 0; i < 60; i++) {
			System.out.print(ch);
		}
		System.out.println();
   }
   
   protected void printjj(String ch) {
	   for (int i = 0; i < 90; i++) {
			System.out.print(ch);
		}
		System.out.println();
   }
   
   protected String tab(String msg) {
	   if (msg.length() <= 3) {
		   return msg + "\t" + "\t";
	   } else {
		   return msg + "\t";
	   }
   }
}
