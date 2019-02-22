package kr.co.ljy.jellyshop.statics.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.StaticsMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Product;

public class ListStockController extends Controllers {

	private StaticsMapper mapper;
	
	public ListStockController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(StaticsMapper.class);
	}
	
	public void service() {
		printj("=");
		System.out.println("제품명" + "\t" + "\t" + "품목" + "\t" + "\t"+ "갯수");
		printj("=");
		List<Product> list = mapper.selectProductList();
		for (Product p : list) {
			System.out.println(tab(p.getProductName()) + tab(p.getProductItem()) + p.getInAmount() + "개");
		}
		new StockManageController().service();
	}
}
