package kr.co.ljy.jellyshop.payment.controller;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.MainController;
import kr.co.ljy.jellyshop.dao.PayProdInfoMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.PayProdInfo;
import kr.co.ljy.jellyshop.vo.Product;


public class PaymentMainController extends Controllers {
	public static ArrayList<PayProdInfo> list;
	int num;
	public static int no;
	public static int sum;
	private PayProdInfoMapper mapper;
	
	public PaymentMainController() {
		list = new ArrayList<>();
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(PayProdInfoMapper.class);
	}
	
	public void service() {
		System.out.println("계산할 상품을 입력 (0.전체취소 - 메인으로 이동	1. 결제)");
		no = mapper.selectPayProdLatestNo() + 1; 	// 가장 최근 결제번호 조회

		//		List<PayProdInfo> chk = mapper.selectPayProdInfoByLatestNo();	
//		if(chk != null) {
//			no = mapper.selectPayProdLatestNo() + 1; 
//		} else {
//			no = 1;
//		}
		
		outer:
		while (true) {
			// 결제할 상품명 입력
			System.out.print("상품명 : ");
			String input = sc.nextLine();	
			Product p = mapper.selectProductInfoByName(input);
			
			if (input.equals("0")) {
				while (true) {
					switch (inputln("메인으로 나갈까요? (Y. 네	N. 아니요)")) {
					case "y":
						new MainController().service();
					case "n":
						continue outer;
					default:
						System.out.println("잘못 입력하셨습니다.");
					}
				}
			}
			
			if ((input.equals("1") && (list.isEmpty() == false))) {
				while (true) {
					switch (inputln("결제할까요? (Y. 네	N. 아니요)")) {
					case "y":
						new PaymentController().service();
					case "n":
						continue outer;
					default:
						System.out.println("잘못 입력하셨습니다.");
					}
				}
			}
			
			if (p == null) {
				System.out.println("********* 해당 상품은 존재하지 않습니다. *********");
				continue outer;
			}
			
			if (p.getInAmount() == 0) {
				System.out.println("재고가 없습니다.");
				continue outer;
			}
			
			PayProdInfo ppi = new PayProdInfo();
			ppi.setPaymentNo(no);
			ppi.setProductNo(p.getProductNo());
			ppi.setProductName(p.getProductName());
			ppi.setPrice(p.getPrice());
			
			
			while (true) {
				try {
					System.out.print("수량 : ");
					num = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("잘못 입력하셨습니다.");
					continue;
				}
			}
			if (p.getInAmount() < num) {
				System.out.println("재고가 부족합니다. (남은 수량 : " + p.getInAmount() + "개)");
				continue;
			}
			ppi.setPayAmount(num);
			list.add(ppi);
			sum = 0;
			for (PayProdInfo pi : list) {
				sum += pi.getPayAmount() * pi.getPrice();
			}
			
			printj("=");
			System.out.println(tab("상품명") + tab("수량") + tab("가격") + tab("합계"));
			printj("-");
			for (PayProdInfo pi : list) {
				System.out.print(tab(pi.getProductName()) + pi.getPayAmount() + "\t" + "\t" + pi.getPrice() + "\t" + "\t" + pi.getPayAmount() * pi.getPrice());
				System.out.println();
			}
			printj("=");
			System.out.println("총 합계 : " + "\t" + "\t" + "\t" + "\t" + "\t" + sum);
			printj("=");					
			
		}
		
		/*
		outer:
		while (true) {
			// 결제할 상품명 입력
			System.out.print("상품명 : ");
			String input = sc.nextLine();	
			Product p = mapper.selectProductInfoByName(input);
			List<PayProdInfo> chk = mapper.selectPayProdInfoByLatestNo();
			
			if (input.equals("1") && (chk.isEmpty() == false)) {
				while (true) {
					switch (inputln("결제할까요? (Y. 네	N. 아니요)")) {
					case "y":
						new PaymentController().service();
					case "n":
						continue outer;
					default:
						System.out.println("잘못 입력하셨습니다.");
					}
				}
			}
			
			if (p == null) {
				System.out.println("********* 해당 상품은 존재하지 않습니다. *********");
				continue outer;
			}
			
			PayProdInfo ppi = new PayProdInfo();
			ppi.setPayProdNo(no);
			ppi.setProductNo(p.getProductNo());
			ppi.setProductName(p.getProductName());
			ppi.setPrice(p.getPrice());
			System.out.print("수량 : ");
			int num = Integer.parseInt(sc.nextLine());
			// --> 수량 감소 처리
			ppi.setPayAmount(num);
			mapper.insertPayProductInfo(ppi);
			
			List<PayProdInfo> list = mapper.selectPayProdInfoByLatestNo();
			int sum = mapper.selectTotalPayProdInfo();
			printj("=");
			System.out.println(tab("상품명") + tab("수량") + tab("가격") + tab("합계"));
			printj("-");
			for (PayProdInfo pi : list) {
				System.out.print(tab(pi.getProductName()) + pi.getPayAmount() + "\t" + "\t" + pi.getPrice() + "\t" + "\t" + pi.getPayAmount() * pi.getPrice());
				System.out.println();
			}
			printj("=");
			System.out.println("총 합계 : " + "\t" + "\t" + "\t" + "\t" + "\t" + sum);
			printj("=");					
		}
		 */
	}
}
