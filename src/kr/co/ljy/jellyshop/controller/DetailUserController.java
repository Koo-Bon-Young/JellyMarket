package kr.co.ljy.jellyshop.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.LoginUserController;
import kr.co.ljy.jellyshop.controller.MainController;
import kr.co.ljy.jellyshop.dao.MemberMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Member;

public class DetailUserController extends Controllers {
	private MemberMapper mapper;

	public DetailUserController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(MemberMapper.class);
	}

	public void service() {
		String birthDate = "";
		printj("=");
		System.out.println("*****나의정보조회화면*****");
		printj("=");

		Member m = new Member();

			Member list = mapper.selectMemberByNo(LoginUserController.userInfo.getMemberNo());

			if (list.getBirthDate() != null) {
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
			System.out.println("id : " + list.getMemberId());
			System.out.println("비밀번호 : " + list.getPassword());
			System.out.println("이름 : " + list.getMemberName());
			System.out.println("비밀번호 : " + list.getPassword());
			System.out.println("생년월일 : " + birthDate);
			System.out.println("전화번호 : " + list.getTelNumber());
			System.out.println("마일리지 : " + list.getMileage() + "점");
			System.out.println("회원등급 : " + grade);
			System.out.println("총누적금액 : " + list.getTotalPayAmount());

			new MainController().service();
		}

	
}