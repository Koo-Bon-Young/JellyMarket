package kr.co.ljy.jellyshop.member.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.MainController;
import kr.co.ljy.jellyshop.dao.MemberMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Member;

public class DeleteMemberController extends Controllers{
	private MemberMapper mapper;
	public DeleteMemberController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(MemberMapper.class);
	}
	
	public void service() {
		printj("=");
		System.out.println("*****회원삭제화면*****");
		printj("=");
		
		Member m = new Member();
		
	
		while(true) {
			String id = input("ID를 입력하세요 :");
			String pwd = input("비밀번호를 입력하세요 : ");
			m.setMemberId(id);
			m.setPassword(pwd);
			Member list = mapper.selectMemberInfo(m);
			if(list == null) {
				System.out.println("ID와 비밀번호가 일치하지 않습니다.");
				continue;
			}
			
			mapper.deleteMember(m.getMemberId());
			System.out.println("*****회원정보가 삭제되었습니다.*****");
			new MainController().service();
	      }
	}
}

