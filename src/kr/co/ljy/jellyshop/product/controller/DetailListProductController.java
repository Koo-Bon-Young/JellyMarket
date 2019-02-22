//상품상세정보
package kr.co.ljy.jellyshop.product.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.ProductMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Product;

public class DetailListProductController extends Controllers {
	
	private ProductMapper productmapper;
	private int selectnum;
	
	public DetailListProductController(int selectnum) {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		productmapper = session.getMapper(ProductMapper.class);
		this.selectnum = selectnum;
	}
	
	public void service() {
		while (true) {
			try {
				Product pd = productmapper.selectProductInfo(selectnum);
				System.out.println("품목\t\t상품명\t\t가격\t\t수량");
				System.out.print(tab(pd.getProductItem()));
				System.out.print(tab(pd.getProductName()));
				System.out.print(pd.getPrice() + "\t\t");
				System.out.print(pd.getInAmount());

				DetailProductMainController ctrl = new DetailProductMainController(selectnum);
				ctrl.service();
			} catch (Exception e) {
				System.out.println("*잘못 입력한 값이 있습니다.*");
				System.out.println("*다시 입력해주세요.*");
				continue;
			}
		}
	}
}
	
