package kr.co.ljy.jellyshop.statics.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.StaticsMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.PayProdInfo;

public class ProfitController extends Controllers {

	private StaticsMapper mapper;
	List<PayProdInfo> list;
	PayProdInfo ppi;
	
	int star;
	int no;
	int total;
	
	public ProfitController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(StaticsMapper.class);
	}
	public void service() {
		System.out.println("*****매출정보*****");
		printj("=");
		total = mapper.selectTotalProfit();
		list = mapper.selectTotalPrice();
		System.out.println("순위 상품명 (비율)\t\t매출금액\t판매량");
		printj("-");
		for (PayProdInfo p : list) {
			star = Math.round(p.getSumPrice()/1000);
			System.out.print(no + "위 " + (p.getProductName()) + "(" + (p.getSumPrice()*100)/total + "%) " + "\t\t" + p.getSumPrice() + "원\t\t");
			for (int i = 0; i < star; i++) {
				System.out.print("*");
			}
			if (star > 10) {
				System.out.print("\t♥ HIT ♥ !");
			}
			no++;
			System.out.println();
		}
	}
}