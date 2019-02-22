package kr.co.ljy.jellyshop.member.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.MainController;
import kr.co.ljy.jellyshop.dao.MemberMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Member;

public class WriteMemberController extends Controllers {
	private MemberMapper mapper;
	public WriteMemberController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(MemberMapper.class);
	}

	public void service() {
		//회원등록
		printj("=");
		System.out.println("*****회원등록화면*****");
		printj("=");
		
		outer:
		while(true) {
			Member m = new Member();
			m.setMemberId(input("ID를 입력하세요 : "));
			m.setMemberName(input("이름을 입력하세요 : "));
			m.setTelNumber(input("전화번호를 입력하세요 : "));
			m.setPassword((input("비밀번호를 입력하세요 : ")));
			m.setBirthDate(input("생년월일을 입력하세요 : "));
			
			
			if(m.getMemberId().equals("") || m.getMemberName().equals("") || m.getTelNumber().equals("") || m.getPassword().equals("")) {  
				printj("=");
				System.out.println("등록에 실패했습니다.");
				System.out.println("다시 입력해주세요.");
				System.out.println();
				continue outer;
			}
			mapper.insertMember(m);
			
			System.out.println("*****회원정보가 등록되었습니다.*****");
			System.out.println();
			new MainController().service();
		}
	}
}

