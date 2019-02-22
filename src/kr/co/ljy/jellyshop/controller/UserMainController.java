package kr.co.ljy.jellyshop.controller;

import kr.co.ljy.jellyshop.product.controller.UserSearchMain;
import kr.co.ljy.jellyshop.qna.controller.ListUserQnaController;

public class UserMainController extends Controllers {
	
	public UserMainController() {

	}

	private void exit() {
		System.out.println("*****로그아웃 되었습니다.*****");
		System.out.println("*****젤리샵 시스템을 종료합니다.*****");
		System.exit(0);
	}

	private int choiceMenu() {
		printj("=");
		System.out.println("1. 상품조회");
		System.out.println("2. 장바구니");
		System.out.println("3. 구매내역");
		System.out.println("4. 정보수정");
		System.out.println("5. 나의 문의글");
		System.out.println("0. 종료");
		printj("=");
		return Integer.parseInt(input("번호를 입력하세요 : "));
	}

	public void service() {
		printj("=");
		System.out.println("*****젤리샵 방문을 환영합니다.*****");

		while (true) {

			switch (choiceMenu()) {
			case 1: // 상품조회
				new UserSearchMain().service();
				break;
//          case 2: //장바구니
//            new CartMainController();
//               break;
			case 3: // 구매내역
				new SelelctPaymentInfo().service();
				break;
			case 4: // 정보수정
				new UpdateUserController().service();
				break;
			case 5: // 나의 문의글
				new ListUserQnaController().service();
				break;
			case 0:
				exit();

			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
			}
		}
	}
}
