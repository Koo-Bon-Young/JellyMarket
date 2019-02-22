package kr.co.ljy.jellyshop.statics.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.StaticsMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.PayProdInfo;

public class RankController extends Controllers {
	private StaticsMapper mapper;
	List<PayProdInfo> list;
	PayProdInfo ppi;
	
	int star;
	int no;
	int total;
	
	public RankController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(StaticsMapper.class);
	}
	public void service() {
		System.out.println("*****인기상품*****");
		printj("=");
		total = mapper.selectTotalAmount();
		list = mapper.selectHotProduct();
		System.out.println("순위 상품명 (비율)\t\t판매갯수");
		printj("-");
		for (PayProdInfo p : list) {
			star = p.getSumAmount();
			System.out.print(no + "위 " + (p.getProductName()) + "(" + (100*star)/total + "%) " + "\t\t");
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




