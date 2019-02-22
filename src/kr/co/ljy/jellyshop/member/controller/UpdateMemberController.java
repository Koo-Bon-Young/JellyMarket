package kr.co.ljy.jellyshop.member.controller;


import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.MainController;
import kr.co.ljy.jellyshop.dao.MemberMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Member;

public class UpdateMemberController extends Controllers{
   private MemberMapper mapper;
   public UpdateMemberController() {
      SqlSession session = MyAppSqlConfig.getSqlSession();
      mapper = session.getMapper(MemberMapper.class);
   }
   public void service() {
      printj("=");
      System.out.println("*****회원수정화면*****");
      printj("=");
      
      Member m = new Member();
      outer:
      while(true) {
    	  System.out.print("회원번호를 입력하세요 : ");
    	  int no = Integer.parseInt(sc.nextLine());
        
        Member list = mapper.selectMemberByNo(no);
         
        if(list == null) {
            System.out.println("일치하는 정보가 없습니다.");
            System.out.println("다시 입력하세요.");
            printj("=");
            continue outer;
         }
        
         m.setMemberNo(no);
         m.setMemberName(input("이름 : "));
         m.setTelNumber(input("전화번호 : "));
         m.setPassword((input("비밀번호 : ")));
        
         if(m.getMemberName().equals("") && m.getPassword().equals("") && 
        		 m.getTelNumber().equals("")) {
            System.out.println();
        	System.out.println("수정에 실패했습니다.");
            System.out.println("다시 입력해주세요.");
            printj("=");
            continue outer;
         }
         
         if(m.getMemberName().equals("")) {
            m.setMemberName(list.getMemberName());
         }
         if(m.getTelNumber().equals("")) {
            m.setTelNumber(list.getTelNumber());
         }
         if(m.getPassword().equals("")) {
            m.setPassword(list.getPassword());
         }
      
         mapper.updateMember(m);
         System.out.println("*****회원정보가 수정되었습니다.*****");
         new MainController().service();
      }
   }
}