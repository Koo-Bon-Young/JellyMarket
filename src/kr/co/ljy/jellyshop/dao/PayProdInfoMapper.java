package kr.co.ljy.jellyshop.dao;

import java.util.List;

import kr.co.ljy.jellyshop.vo.Member;
import kr.co.ljy.jellyshop.vo.PayInfo;
import kr.co.ljy.jellyshop.vo.PayProdInfo;
import kr.co.ljy.jellyshop.vo.Product;

public interface PayProdInfoMapper {
	Product selectProductInfoByName(String productName);
	void insertPayProductInfo(PayProdInfo payProdInfo);
	List<PayProdInfo> selectPayProdInfoByLatestNo();
	int selectTotalPayProdInfo(int payProdNo);
	int selectPayProdLatestNo();
	List<Product> selectPayProdByNo(int productName);
	List<Product> selectPayProdInfoByNo(int productNo);
	Member selectMemberById(String id);
	void updateProductInAmount(Product product);
	int selectProductInAmount(int productNo);
	void updateMileageAndTotalAmount(Member member);
	void updateMemberGrade(Member member);
	String selectMemberGrade(String memberId);
	int selectTotalPay(String memberId);
	void insertPayInfo(PayInfo payInfo);
	List<PayProdInfo> selectPaymentLogByNo(int memberNo);
}
