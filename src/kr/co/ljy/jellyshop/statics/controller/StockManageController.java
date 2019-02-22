package kr.co.ljy.jellyshop.statics.controller;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.MainController;

public class StockManageController extends Controllers {

	public void service() {
		printj("=");
		while (true) {
			switch (inputln("재고조회 (1. 전체조회	 2. 재고없음   0. 메인으로 돌아가기)")) {
			case "1":
				new ListStockController().service();
			case "2":
				new NotInStockController().service();
			case "0":
				new MainController().service();
			default:
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("다시 선택해주세요.");
			}
		}
	}	
}
			
	