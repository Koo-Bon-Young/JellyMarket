package kr.co.ljy.jellyshop.member.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.MainController;
import kr.co.ljy.jellyshop.dao.MemberMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Member;

public class DetailMemberController extends Controllers{
	int no;
	private MemberMapper mapper;
	public DetailMemberController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(MemberMapper.class);
	}
	public void service() {
		String birthDate = "";
		printj("=");
	    System.out.println("*****회원조회화면*****");
	    printj("=");
		
	    Member m = new Member();
	    outer:
	    while(true) {
		System.out.print("회원번호를 입력하세요 : ");
		try {
			no = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("잘못입력 하셨습니다.");
				continue outer;
		}
		Member list = mapper.selectMemberByNo(no);
		
		if(list == null) {
			 System.out.println("일치하는 정보가 없습니다.");
	         System.out.println("다시 입력하세요.");
	         printj("=");
	         continue outer;
		}
		m.setMemberNo(no);
		if(list.getBirthDate() != null ) {		
			birthDate = list.getBirthDate();
		}
		String grade = list.getGrade();
		switch(grade) {
		case "A":
			grade = "일반";
			break;
		case "B":
			grade = "SILVER";
			break;
		case "C":
			grade = "GOLD";
			break;
		case "D":
			grade = "VIP";
			break;
		}
		System.out.println("ID : "+ list.getMemberId());
	    System.out.println("이름 : " + list.getMemberName());
	    System.out.println("비밀번호 : " + list.getPassword());
	    System.out.println("생년월일 : "+ birthDate);
	    System.out.println("전화번호 : "+ list.getTelNumber());
	    System.out.println("마일리지 : " + list.getMileage() + "점");
	    System.out.println("회원등급 : " + grade);
	    System.out.println("총누적금액 : "+ list.getTotalPayAmount() + "원");
	    
	    new MainController().service();
	    }
	    
	}
}
