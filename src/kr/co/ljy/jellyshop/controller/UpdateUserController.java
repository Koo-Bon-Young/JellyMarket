package kr.co.ljy.jellyshop.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.dao.MemberMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Member;

public class UpdateUserController extends Controllers {
	private MemberMapper memberMapper;

	public UpdateUserController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		memberMapper = session.getMapper(MemberMapper.class);
	}

	public void service() {
		printj("=");
		System.out.println("*****회원수정화면*****");
		printj("=");

		Member m = new Member();

		Member list = memberMapper.selectMemberByNo(LoginUserController.userInfo.getMemberNo());

		m.setMemberNo(LoginUserController.userInfo.getMemberNo());
		m.setMemberName(input("이름 : "));
		m.setTelNumber(input("전화번호 : "));
		m.setPassword((input("비밀번호 : ")));

		if (m.getMemberName().equals("")) {
			m.setMemberName(list.getMemberName());
		}
		if (m.getTelNumber().equals("")) {
			m.setTelNumber(list.getTelNumber());
		}
		if (m.getPassword().equals("")) {
			m.setPassword(list.getPassword());
		}

		memberMapper.updateMember(m);
		System.out.println("*****회원정보가 수정되었습니다.*****");
		new UserMainController().service();
	}
}