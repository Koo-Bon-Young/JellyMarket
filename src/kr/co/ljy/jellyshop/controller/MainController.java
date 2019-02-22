package kr.co.ljy.jellyshop.controller;


import kr.co.ljy.jellyshop.member.controller.MemberMainController;
import kr.co.ljy.jellyshop.payment.controller.SelectByIdPaymentController;
import kr.co.ljy.jellyshop.product.controller.ProductMainController;
import kr.co.ljy.jellyshop.qna.controller.ListUserQnaController;
import kr.co.ljy.jellyshop.qna.controller.SelectListAdminQnaController;
import kr.co.ljy.jellyshop.statics.controller.StaticsMainController;


public class MainController extends Controllers {
 
   
	private void exit() {
		System.out.println("*****젤리샵 시스템을 종료합니다.*****");
		// 프로세스 중단.
		System.exit(0);
	}

	private int choiceMenu() {
		printj("=");
		System.out.println("1. 회원관리");
		System.out.println("2. 상품조회");
		System.out.println("3. 계산");
		System.out.println("4. 통계");
		System.out.println("5. Q&A");
		System.out.println("0. 종료");
		printj("=");
		return Integer.parseInt(input("번호를 입력하세요 : "));
	}

	public void service() {
		try {
			printj("=");
			System.out.println("*****젤리샵*****");

			while (true) {
				Controller ctrl = null;
				switch (choiceMenu()) {
				case 1: // 회원관리
					ctrl = new MemberMainController();
					break;
				case 2: // 상품조회
					ctrl = new ProductMainController();
					break;
				case 3: // 계산
					ctrl = new SelectByIdPaymentController();
					break;
				case 4: // 통계
					ctrl = new StaticsMainController();
					break;
				case 5: // 문의글
					ctrl = new ListUserQnaController();
					break;
				case 0:
					exit();
				default:
					System.out.println("잘못된 메뉴번호 입니다.");
					System.out.println("다시 선택해 주세요.");
				}

				if (ctrl != null) {
					ctrl.service();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("잘못 입력하셨습니다.");
			this.service();
		}
	}

}
