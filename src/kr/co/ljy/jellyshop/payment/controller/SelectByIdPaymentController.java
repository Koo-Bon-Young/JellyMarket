//회원아이디입력받기
package kr.co.ljy.jellyshop.payment.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.PayInfoMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Member;

public class SelectByIdPaymentController extends Controllers {
	public static String id;
	String grade;
	private PayInfoMapper mapper;
	public static float ratePoint;
	public SelectByIdPaymentController() {
		
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(PayInfoMapper.class);
	}
	
	public void service() {
		while(true) {
			printj("=");
			id = (input("회원 ID 입력 : "));
			Member m = mapper.selectMemberById(id);
			printj("=");
			
			if (m != null) {
				switch (m.getGrade()) {
				case "D":
					grade = "VIP";
					ratePoint = 0.1f;
					break;
				case "C":
					grade = "GOLD";
					ratePoint = 0.05f;
					break;
				case "B":
					grade = "SILVER";
					ratePoint = 0.03f;
					break;
				case "A":
					grade = "일반";
					ratePoint = 0.01f;
					break;			
				}
			} else {
				System.out.println("등록되지 않은 ID입니다.");
				System.out.println("다시 입력해 주세요.");
				this.service();
			}
			
			System.out.println("회원등급 : " + grade);
			System.out.println("회원명 : " + m.getMemberName());
			System.out.println("마일리지 : " + m.getMileage() + "점");
			System.out.println("누적구매금액 : " + m.getTotalPayAmount() + "원");
			printj("=");
			new PaymentMainController().service();
		}
	}
}
