package kr.co.ljy.jellyshop.qna.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.LoginUserController;
import kr.co.ljy.jellyshop.controller.UserMainController;
import kr.co.ljy.jellyshop.dao.MemberMapper;
import kr.co.ljy.jellyshop.dao.QnaMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Member;
import kr.co.ljy.jellyshop.vo.Qna;

public class ListUserQnaController extends Controllers{
	private QnaMapper qnaMapper;
	private MemberMapper mapper;
	public ListUserQnaController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		qnaMapper = session.getMapper(QnaMapper.class);
		mapper = session.getMapper(MemberMapper.class);
		
	}
	public void service() {
		Member list = mapper.selectMemberByNo(LoginUserController.userInfo.getMemberNo());
		List<Qna> qnaList = qnaMapper.selectMyQnaList(list.getMemberNo());
		for(Qna q : qnaList) {
			System.out.println("회원번호 : " + q.getMemberNo());
			System.out.println("문의번호 : " + q.getAskNo());
			System.out.println("문의제목 : " + q.getAskTitle());
			System.out.println("문의날짜 : " + q.getAskRegDate());
		}
		if(qnaList.isEmpty()) {
			System.out.println("문의글이 없습니다.");
		
		new UserMainController().service();
	
	}
	
	}
}