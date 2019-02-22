package kr.co.ljy.jellyshop.controller;

public class LoginMainController extends Controllers {
	public static int chk;
	private int choiceMenu() {

		System.out.println("*****젤리샵 로그인*****");
		printj("=");
		System.out.println("1. 관리자 로그인");
		System.out.println();
		System.out.println("2. 사용자 로그인");

		printj("=");
		return Integer.parseInt(input("번호를 입력하세요 : "));
	}

	public void service() {
		try {
			printj("=");
			
			while (true) {
				Controller ctrl = null;
				switch (choiceMenu()) {
				case 1: // 관리자로그인화면
					ctrl = new LoginAdminController();
					chk = 0;
					break;
				case 2: // 사용자로그인화면
					ctrl = new LoginUserController();
					chk = 1;
					break;
				case 2019: // 치트키
					ctrl = new MainController();

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
