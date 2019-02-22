package kr.co.ljy.jellyshop.product.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.ProductMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Product;

public class WriteProductController extends Controllers {
	private ProductMapper productmapper;
	
	public WriteProductController() {
		
		SqlSession session = MyAppSqlConfig.getSqlSession();
		productmapper = session.getMapper(ProductMapper.class);
		
	}

	public void service()  {
		try {
			Product product = new Product();
			System.out.println("*****상품등록화면입니다*****");
			product.setProductItem(input("상품품목을 입력하세요 : "));
			product.setProductName(input("상품명을 입력하세요 : "));
			product.setPrice(Integer.parseInt(input("상품가격을 입력하세요 : ")));
			product.setInAmount(Integer.parseInt(input("상품수량을 입력하세요 : ")));
			
			productmapper.WriteProductController(product);
			System.out.println("상품 등록 성공");
		} catch (Exception e) {
			System.out.println("*****상품 등록 실패*****");
			System.out.println("다시 입력해주세요.");
			this.service();
	
		}
	}
}