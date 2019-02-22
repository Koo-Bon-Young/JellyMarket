package kr.co.ljy.jellyshop.member.controller;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.MainController;

public class MemberMainController extends Controllers{
	
	private int choiceMenu() {
		System.out.println("*****회원관리화면*****");
		printj("=");
		System.out.println("1.회원등록");
		System.out.println("2.회원정보조회");
		System.out.println("3.회원수정");
		System.out.println("4.회원삭제");
		System.out.println("0.메인으로");
		printj("=");
		return Integer.parseInt(input("번호를 입력하세요 : "));
	}
	public void service() {
		printj("=");
		while (true) {
			
			switch (choiceMenu()) {
			case 1:  // 회원등록
				new WriteMemberController().service();	
			case 2:  // 회원정보조회
				new DetailMemberController().service();
				break;
			case 3:  // 회원수정
				new UpdateMemberController().service();	
				break;
			case 4:  // 회원삭제
				new DeleteMemberController().service();	
				break;
			case 0:  // 메인으로
				new MainController().service();
			
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
			}
			
		}
	}	
}
