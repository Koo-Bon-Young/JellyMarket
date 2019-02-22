package kr.co.ljy.jellyshop.statics.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.MainController;
import kr.co.ljy.jellyshop.dao.StaticsMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Product;

public class ViewStockController extends Controllers {
	String stock = "❏";
	String notInStock = "✖";
	int no = 0;
	int choiceNum;
	
	private StaticsMapper mapper;
	
	public ViewStockController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(StaticsMapper.class);
	}
	
	public void service() {
//		List<Product> list = mapper.selectProductList();
		List<Product> jelly = mapper.selectProductListByItem("젤리");
		List<Product> choco = mapper.selectProductListByItem("초콜릿");
		List<Product> marsh = mapper.selectProductListByItem("마시멜로우");
		List<Product> candy = mapper.selectProductListByItem("사탕");
		List<Product> jel = mapper.selectNotInStockProductListByItem("젤리");
		List<Product> cho = mapper.selectNotInStockProductListByItem("초콜릿");
		List<Product> mar = mapper.selectNotInStockProductListByItem("마시멜로우");
		List<Product> can = mapper.selectNotInStockProductListByItem("사탕");
		printj("=");
		System.out.println("*****재고뷰어화면*****");
		System.out.println("✖ : 재고없음");
		printj("=");
		
		System.out.println("젤리");
		for (Product c : jelly) {
			if (c.getInAmount() == 0) {
				System.out.print(notInStock + "  ");
				no++;
				if (no == 5) System.out.println();
			} else {
				System.out.print(stock + "  ");
				no++;
				if (no == 5) System.out.println();
			}
		}
		
		no = 0;
		System.out.println();
		System.out.println();
		
		System.out.println("초콜릿");
		for (Product c : choco) {
			if (c.getInAmount() == 0) {
				System.out.print(notInStock + "  ");
				no++;
				if (no == 5) System.out.println();
			} else {
				System.out.print(stock + "  ");
				no++;
				if (no == 5) System.out.println();
			}
		}
		
		no = 0;
		System.out.println();
		System.out.println();
		
		System.out.println("마시멜로우");
		for (Product c : marsh) {
			if (c.getInAmount() == 0) {
				System.out.print(notInStock + "  ");
				no++;
				if (no == 5) System.out.println();
			} else {
				System.out.print(stock + "  ");
				no++;
				if (no == 5) System.out.println();
			}
		}
		
		no = 0;
		System.out.println();
		System.out.println();
		
		System.out.println("사탕");
		for (Product c : candy) {
			if (c.getInAmount() == 0) {
				System.out.print(notInStock + "  ");
				no++;
				if (no == 5) System.out.println();
			} else {
				System.out.print(stock + "  ");
				no++;
				if (no == 5) System.out.println();
			}
		}
		while (true) {
			System.out.println();
			System.out.println("조회할 품목을 입력하세요 (0. 메인으로 나가기)");
			String item = sc.nextLine();
			printj("=");
			switch(item) {
			case "젤리":
				for (Product c : jel) {
					System.out.println(tab(c.getProductName()) + "재고없음");
				}
				printj("=");
				break;
			case "초콜릿":
				for (Product c : cho) {
					System.out.println(tab(c.getProductName()) + "재고없음");
				}
				printj("=");
				break;
			case "마시멜로우":
				for (Product c : mar) {
					System.out.println(tab(c.getProductName()) + "재고없음");
				}
				printj("=");
				break;
			case "사탕":
				for (Product c : can) {
					System.out.println(tab(c.getProductName()) + "재고없음");
				}
				printj("=");
				break;
			case "0":
				new MainController().service();
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
}








