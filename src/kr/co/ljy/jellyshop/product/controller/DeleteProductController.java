package kr.co.ljy.jellyshop.product.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.ProductMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;

public class DeleteProductController extends Controllers {
	private ProductMapper productmapper;
	private int selectnum;

	public DeleteProductController(int selectnum) {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		productmapper = session.getMapper(ProductMapper.class);
		this.selectnum = selectnum;
	}


	public void service() {
		while(true) {
			try {
				productmapper.DeleteProductController(selectnum);
				System.out.println("상품을 삭제하였습니다.");
				break;
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}

	
	}
}
