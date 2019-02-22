package kr.co.ljy.jellyshop.statics.controller;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.MainController;

public class StaticsMainController extends Controllers {
	
	public String choiceMenu() {
		printj("=");
		System.out.println("1. 인기상품");
		System.out.println("2. 재고관리");
		System.out.println("3. 매출");
		System.out.println("0. 메인으로");
		printj("=");
		return input("메뉴를 선택하세요 : ");
	}
	
	public void service() {
		printj("=");
		System.out.println("*****통계화면*****");
		while (true) {
			switch(choiceMenu()) {
			case "1":
				new RankController().service();
			case "2":
				new StockManageMenuController().service();
			case "3":
				new ProfitController().service();
			case "0":
				new MainController().service();
			default:
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("다시 선택해주세요.");
			}
		}
	}
}
