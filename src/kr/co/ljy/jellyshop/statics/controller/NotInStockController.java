package kr.co.ljy.jellyshop.statics.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.StaticsMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Product;

public class NotInStockController extends Controllers {

private StaticsMapper mapper;
	
	public NotInStockController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(StaticsMapper.class);
	}
	
	public void service() {
		printj("=");
		System.out.println("*****재고없음화면*****");
		printj("=");
		System.out.println("제품명" + "\t" + "\t" + "품목" + "\t" + "\t"+ "갯수");
		printj("=");
		List<Product> list = mapper.selectNotInStockProductList();
		if (list.isEmpty()) {
			System.out.println("재고가 없는 상품이 존재하지 않습니다.");
		}
		for (Product p : list) {
			System.out.println(tab(p.getProductName()) + tab(p.getProductItem()) + p.getInAmount() + "개");
		}
		new StockManageController().service();
	}

}
