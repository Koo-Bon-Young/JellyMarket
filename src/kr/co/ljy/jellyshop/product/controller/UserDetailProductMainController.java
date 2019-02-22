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

public class UserDetailProductMainController extends Controllers {

	public Scanner sc = new Scanner(System.in);

	private ProductMapper productMapper;
	int selectnum;
	
	public UserDetailProductMainController(int selectnum) {
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
//		System.out.println("2. 장바구니 넣기");
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
				case 3:
//					ctrl = new Cart();
				case 0:
					
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
