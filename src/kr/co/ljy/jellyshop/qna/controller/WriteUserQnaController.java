package kr.co.ljy.jellyshop.qna.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.LoginUserController;
import kr.co.ljy.jellyshop.controller.UserMainController;
import kr.co.ljy.jellyshop.dao.MemberMapper;
import kr.co.ljy.jellyshop.dao.QnaMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Member;
import kr.co.ljy.jellyshop.vo.Qna;

public class WriteUserQnaController extends Controllers{
   private QnaMapper qnaMapper;
   private MemberMapper memberMapper;
   private int selectnum;

   public WriteUserQnaController(int selectnum) {
      SqlSession session = MyAppSqlConfig.getSqlSession();
      qnaMapper = session.getMapper(QnaMapper.class);
      memberMapper = session.getMapper(MemberMapper.class);
      this.selectnum = selectnum;
   }
   public void service() {
	
      Member list = memberMapper.selectMemberByNo(LoginUserController.userInfo.getMemberNo());
      printj("=");
      System.out.println("*****Qna등록*****");
      printj("=");
      Qna qna = new Qna();
      qna.setMemberNo(list.getMemberNo());
      qna.setProductNo(selectnum);
      qna.setAskTitle(input("문의제목을 입력하세요 : "));
      qna.setAskContent(input("문의내용을 입력하세요 : "));
      
      qnaMapper.insertQna(qna);
      System.out.println("문의가 등록되었습니다.");
      System.out.println();
      
      new UserMainController().service();
   }
   
}