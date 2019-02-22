package kr.co.ljy.jellyshop.product.controller;

import kr.co.ljy.jellyshop.controller.Controller;
import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.MainController;

public class SelectListProductMainController extends Controllers {
	
	private int choiceMenu() {
		System.out.println();
		printj("=");
		System.out.println("1. 품목으로 조회");
		System.out.println("2. 이름으로 조회");
		System.out.println("0. 메인으로");
		printj("=");
		System.out.print("번호를 입력하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public void service(){
			while (true) {
				Controller ctrl = null;
				switch (choiceMenu()) {
				case 1:  
					ctrl = new SelectListProductByItemController();
					break;
				case 2:  
					ctrl = new SelectListProductByNameController();
					break;
				case 0:  
					ctrl = new MainController();
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


