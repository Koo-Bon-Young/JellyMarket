package kr.co.ljy.jellyshop.product.controller;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;


import kr.co.ljy.jellyshop.controller.Controller;
import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.ProductMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;


public class AdminDetailProductMainController extends Controllers {

	public Scanner sc = new Scanner(System.in);

	private ProductMapper productMapper;
	int selectnum;
	
	public AdminDetailProductMainController(int selectnum) {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		productMapper = session.getMapper(ProductMapper.class);
		this.selectnum = selectnum;
	}
	

	public AdminDetailProductMainController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		productMapper = session.getMapper(ProductMapper.class);
	}


	private int choiceMenu() {
		System.out.println();
		printj("=");
		System.out.println("*****상세상품화면*****");
		printj("=");
		System.out.println("1. 상품수정");
		System.out.println("2. 삭제");
		System.out.println("0. 이전으로");
		printj("=");
		System.out.print("번호를 입력하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public void service(){
		
			while (true) {
				Controller ctrl = null;
				switch (choiceMenu()) {
				case 1:  // 상품수정
					ctrl = new AdminUpdateProductController(selectnum);
					break;
				case 2:  // 삭제
					ctrl = new AdminDeleteProductController(selectnum);
					break;
				case 0:
					ctrl = new AdminProductMainController();
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
