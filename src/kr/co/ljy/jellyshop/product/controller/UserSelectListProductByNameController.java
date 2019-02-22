//상품명으로 검색

package kr.co.ljy.jellyshop.product.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.ProductMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Product;

public class UserSelectListProductByNameController extends Controllers  {
	private ProductMapper productmapper;
	List<Product> list;
	int selectnum;
	
	public UserSelectListProductByNameController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		productmapper = session.getMapper(ProductMapper.class);
		
	}

	public UserSelectListProductByNameController(ProductMapper productMapper) {
		this.productmapper = productMapper;
	}

	public void service() throws Exception {
		try {
		list = productmapper.SelectListProductByNameController(input("\n상품이름을 입력하세요 : "));
		if (list.isEmpty()) {
			System.out.println("다시 입력하세요");
			this.service();
		}
		} catch (Exception e) {
			System.out.println("다시 입력하세요");
			this.service();
		}
		
		System.out.println("상품번호\t상품품목\t상품이름");
		for (Product p : list) {
			System.out.print(p.getProductNo()+"\t\t");
			System.out.print(tab(p.getProductItem()));
			System.out.print(p.getProductName());
			System.out.println();
			
		}
		System.out.println("처리하실 상품번호를 선택하세요 : ");
		selectnum = sc.nextInt();
		
		UserDetailProductMainController ctrl = new UserDetailProductMainController(selectnum);
		ctrl.service();
	
	}
}
