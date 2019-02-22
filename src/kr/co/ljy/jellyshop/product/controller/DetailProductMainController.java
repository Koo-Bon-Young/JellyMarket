package kr.co.ljy.jellyshop.product.controller;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.comment.controller.ListCommentController;
import kr.co.ljy.jellyshop.controller.Controller;
import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.ProductMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.qna.controller.SelectListAdminQnaController;
import kr.co.ljy.jellyshop.qna.controller.WriteUserQnaController;

public class DetailProductMainController extends Controllers {

	public Scanner sc = new Scanner(System.in);

	private ProductMapper productMapper;
	int selectnum;
	
	public DetailProductMainController(int selectnum) {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		productMapper = session.getMapper(ProductMapper.class);
		this.selectnum = selectnum;
	}
	

	private int choiceMenu() {
		System.out.println();
		printj("=");
		System.out.println("*****상세상품화면입니다*****");
		printj("=");
		System.out.println("1. 상품평");
		System.out.println("2. 상품문의");
		System.out.println("3. 상품수정");
		System.out.println("4. 삭제");
		System.out.println("0. 이전으로");
		printj("=");
		System.out.print("번호를 입력하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public void service(){
		
			while (true) {
				Controller ctrl = null;
				switch (choiceMenu()) {
				case 1:  // 상품평
					ctrl = new ListCommentController(selectnum);
					break;
				case 2:  // 상품문의
					ctrl = new WriteUserQnaController(selectnum);
					break;
				case 3:  // 상품수정
					ctrl = new UpdateProductController(selectnum);
					break;
				case 4:  // 삭제
					ctrl = new DeleteProductController(selectnum);
					break;
				case 0:
					ctrl = new ProductMainController();
				}
			if (ctrl != null) {
				try {
					ctrl.service();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
