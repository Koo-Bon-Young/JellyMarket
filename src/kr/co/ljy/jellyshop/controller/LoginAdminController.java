package kr.co.ljy.jellyshop.controller;


public class LoginAdminController extends Controllers{
	private String id;
	private String pwd;
	
	public LoginAdminController() {}
	public void service() {
		
		Boolean flag = true; // 로그인 안됨... false 로그인됨 while 나가야돼 
		while(flag) {
			id = input("ID를 입력하세요 : ");
			pwd = input("비밀번호를 입력하세요 : ");
			
			if((id.equals("jelly") && pwd.equals("jelly"))== false ) {
				System.out.println("ID와 비밀번호가 일치하지 않습니다.");

				continue;
			}
			System.out.println("*****관리자로 로그인되었습니다.*****");
			
			System.out.println();
			new MainController().service();
			flag = false;
		}
	}
}

