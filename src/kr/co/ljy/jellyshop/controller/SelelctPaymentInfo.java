package kr.co.ljy.jellyshop.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.dao.PayProdInfoMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.payment.controller.SelectByIdPaymentController;
import kr.co.ljy.jellyshop.vo.PayProdInfo;

public class SelelctPaymentInfo extends Controllers {
	int no = 0;
	
	List<PayProdInfo> list;
	private PayProdInfoMapper mapper;
	
	SelectByIdPaymentController spc = new SelectByIdPaymentController();
	
	public SelelctPaymentInfo() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(PayProdInfoMapper.class);
	}
	public void service() {
		System.out.println("*****구매내역화면*****");
		printj("=");
		list = mapper.selectPaymentLogByNo(LoginUserController.userInfo.getMemberNo());
		if(list.isEmpty()) {
			System.out.println("*****구매내역이 없습니다.*****");
		}
		for (PayProdInfo p : list) {
			if (no != p.getPaymentNo()) {
				
				no = p.getPaymentNo();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println(no + "번 주문내역");
				printj("-");
			}
			System.out.print(tab(p.getProductName()) + (p.getPrice()) +"\t\t" + p.getPayAmount() + "개" + "\t\t" + p.getPayAmount() * p.getPrice() + "원");
			
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		new UserMainController().service();
	}
}




