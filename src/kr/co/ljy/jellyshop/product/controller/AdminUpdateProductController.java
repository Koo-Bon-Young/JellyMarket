package kr.co.ljy.jellyshop.product.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.ProductMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Product;

public class AdminUpdateProductController extends Controllers {
	private ProductMapper productMapper;
	int selectnum;


	public AdminUpdateProductController(int selectnum) {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		productMapper = session.getMapper(ProductMapper.class);
		this.selectnum = selectnum;;
	}


	public void service() {
		while (true) {
			try {
		System.out.println("*****상품수정화면입니다*****");
		Product product = new Product();		
		product.setProductNo(selectnum);
		product.setProductName(input("상품명을 입력하세요 : "));
		product.setProductItem(input("품목을 입력하세요 : "));
		product.setPrice(Integer.parseInt(input("가격을 입력하세요 : ")));
		product.setInAmount(Integer.parseInt(input("수량을 입력하세요 : ")));
		productMapper.UpdateProductController(product);
		System.out.println("*****상품정보 수정완료*****");
		break;
		} catch (Exception e) {
			System.out.println("*잘못 입력한 값이 있습니다.*");
			System.out.println("*다시 입력해주세요.*");
			continue;
		}
	}
}


}