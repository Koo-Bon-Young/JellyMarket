//상품명 입력받기
package kr.co.ljy.jellyshop.payment.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.MainController;
import kr.co.ljy.jellyshop.dao.PayProdInfoMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Member;
import kr.co.ljy.jellyshop.vo.PayInfo;
import kr.co.ljy.jellyshop.vo.PayProdInfo;
import kr.co.ljy.jellyshop.vo.Product;


public class PaymentController extends Controllers {
	int total;
	int point;
	String grade;
	private PayProdInfoMapper mapper;
	
	SelectByIdPaymentController spc = new SelectByIdPaymentController();
	
	public PaymentController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(PayProdInfoMapper.class);
	}
	
	public void service() {
		Member m = mapper.selectMemberById(SelectByIdPaymentController.id);
		int total = PaymentMainController.sum;
		printj("=");
		outer:
		while (true) {
			switch(inputln("마일리지를 사용할까요? (Y. 네	   N. 아니요)")) {
			case "y":
				printj("=");
				while (true) {
					point = Integer.parseInt(input("사용할 마일리지 입력 : "));
					if (point > m.getMileage()) {
						System.out.println("마일리지가 부족합니다. (보유 마일리지 : " + m.getMileage() + "원)");
					} else {
						break;
					}
				}
				break outer;
			case "n":
				point = 0;
				printj("=");
				break outer;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
		total = (int)(total - point);
		int mileage = (int)(total * SelectByIdPaymentController.ratePoint);
		int sum = total;
		
		System.out.println("합계금액 : " + sum + "원");
		System.out.println("적립금액 : " + mileage + "원");
		
		PayProdInfo ppi = new PayProdInfo();
		Member mem = new Member();
		mem.setMemberId(m.getMemberId());
		mem.setMileage(m.getMileage() + mileage);
		mem.setTotalPayAmount(m.getTotalPayAmount() + sum);
		mapper.updateMileageAndTotalAmount(mem);
		System.out.println("총 마일리지 : " + mem.getMileage() + "점");
		System.out.println("*****결제가 완료 되었습니다. *****");
		System.out.println("*****마일리지 적립 완료*****");
		
//		for (PayProdInfo pi : PaymentMainController.list) {
//			System.out.print(tab(pi.getProductName()) + pi.getPayAmount() + "\t" + "\t" + pi.getPrice() + "\t" + "\t" + pi.getPayAmount() * pi.getPrice());
//			System.out.println();
//		}
		
		
		for (PayProdInfo p : PaymentMainController.list) {
			ppi.setMemberNo(m.getMemberNo());
			ppi.setPaymentNo(p.getPaymentNo());
			ppi.setProductNo(p.getProductNo());
			ppi.setProductName(p.getProductName());
			ppi.setPrice(p.getPrice());
			ppi.setPayAmount(p.getPayAmount());
			mapper.insertPayProductInfo(ppi);
		}
		System.out.println("*****결제완료*****");
		
		Product prod = new Product();
		for (PayProdInfo p : PaymentMainController.list) {
			prod.setProductNo(p.getProductNo());
			prod.setInAmount(mapper.selectProductInAmount(p.getProductNo()) - p.getPayAmount());
			mapper.updateProductInAmount(prod);
		}
		int totalPay = mapper.selectTotalPay(m.getMemberId());
		
		if (totalPay < 10000) {
			grade = "A";
		} else if (totalPay < 50000) {
			grade = "B";
		} else if (totalPay < 100000) {
			grade = "C";
		} else {
			grade = "D";
		}
		
		Member member = new Member();
		member.setMemberId(m.getMemberId());
		member.setGrade(grade);
		mapper.updateMemberGrade(member);
		
		PayInfo p = new PayInfo();
		p.setMemberNo(m.getMemberNo());
		p.setPaymentNo(ppi.getPaymentNo());
		p.setTotalPrice(sum);
		mapper.insertPayInfo(p);
		System.out.println("*****결제정보 등록 완료*****");
		
		System.out.println("0. 메인으로 이동   1. 계속 결제하기");
		String choiceNum = sc.nextLine();
		switch (choiceNum) {
		case "0":
			new MainController().service();
		case "1":
			new PaymentMainController().service();
		}
	}
}


