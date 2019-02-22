package kr.co.ljy.jellyshop.statics.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.StaticsMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Product;

public class InventoryMenageController extends Controllers{
	private StaticsMapper mapper;
	List<Product> list;
	int amount;
	int prodNo;
	
	public InventoryMenageController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(StaticsMapper.class);
	}
	
	public void service() {
		System.out.println("*****재고추가화면*****");
		printj("=");	
		list = mapper.searchProductByName((input("상품이름으로 검색 : ")));
		System.out.println(tab("상품번호") + tab("품목") + tab("상품이름") + "수량");
		printj("-");
		for (Product p : list) {
		System.out.println(p.getProductNo() +"\t\t" + tab(p.getProductItem()) + tab(p.getProductName()) + p.getInAmount());
		}		
		
		if(list.isEmpty()) {
			System.out.println("잘못 입력하셨습니다.");
			this.service();
		}
		printj("=");
		Product product = new Product();
		
		while (true) {
			try {
				prodNo = Integer.parseInt(input("재고를 추가할 상품번호을 입력하세요 : "));
				break;
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}
		
		while (true) {
			try {
				amount = Integer.parseInt(input("추가할 수량을 입력하세요 : "));
				break;
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}
		Product p = mapper.selectProductByNo(prodNo);
		product.setProductNo(prodNo);
		product.setInAmount(p.getInAmount() + amount);
		mapper.updateProductInAmount(product);
		System.out.println("*****재고가 추가되었습니다*****");
		new StockManageMenuController().service();
	}
}







