package kr.co.ljy.jellyshop.product.controller;

import kr.co.ljy.jellyshop.controller.Controller;
import kr.co.ljy.jellyshop.controller.Controllers;

public class AdminSearchMain extends Controllers {
	private int choiceMenu() {
		System.out.println("*****조회방법선택화면입니다*****");
		printj("=");
		System.out.println("1. 품목검색");
		System.out.println("2. 이름검색");
		printj("=");
		System.out.print("번호를 입력하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public void service(){
		while (true) {
			Controller ctrl = null;
			switch (choiceMenu()) {
			case 1:  // 상품조회
				ctrl = new AdminSelectListProductByItemController();
				break;
			case 2:  // 상품이름검색
				ctrl = new AdminSelectListProductByNameController();
				break;
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
			}
			
			if (ctrl != null) {
				try {
					ctrl.service();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
