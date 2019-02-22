package kr.co.ljy.jellyshop.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.dao.MemberMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Member;

public class LoginUserController extends Controllers{
	
	private MemberMapper memberMapper;
	public static Member userInfo;
	
	public LoginUserController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		memberMapper = session.getMapper(MemberMapper.class);
		
	}
	public void service() {
		Member m = new Member();
		Boolean flag = true; // 로그인 안됨... false 로그인됨 while 나가야돼 
		while(flag) {
			String id = input("ID를 입력하세요 : ");
			String pwd = input("비밀번호를 입력하세요 : ");
			m.setMemberId(id);
			m.setPassword(pwd);
			userInfo = memberMapper.selectMemberInfo(m);
			
			if(userInfo == null) {
				System.out.println("ID와 비밀번호가 일치하지 않습니다.");

				continue;
			}
			
			
			memberMapper.selectUserlogin(id);
			// 해당되는 id에 대한 member가져오기
			System.out.println(m.getMemberId() + "님으로 로그인되었습니다.");
			
			System.out.println();
			new UserMainController().service();
			flag = false;
		}
	}
}

