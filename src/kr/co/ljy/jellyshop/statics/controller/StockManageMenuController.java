package kr.co.ljy.jellyshop.statics.controller;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.MainController;

public class StockManageMenuController extends Controllers {
	public String choiceMenu() {
		printj("=");
		System.out.println("1. 재고조회");
		System.out.println("2. 재고추가");		
		System.out.println("3. 재고뷰어");
		System.out.println("0. 메인으로");
		printj("=");
		return input("메뉴를 선택하세요 : ");
	}
	
	public void service() {
		printj("=");
		System.out.println("*****재고관리화면*****");
		while (true) {
			switch(choiceMenu()) {
			case "1":
				new StockManageController().service();
			case "2":
				new InventoryMenageController().service();
			case "3":
				new ViewStockController().service();
			case "0":
				new MainController().service();
			default:
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("다시 선택해주세요.");
			}
		}
	}
}
