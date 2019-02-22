package kr.co.ljy.jellyshop.dao;

import java.util.List;

import kr.co.ljy.jellyshop.vo.PayProdInfo;
import kr.co.ljy.jellyshop.vo.Product;

public interface StaticsMapper {
	List<Product> selectProductList();
	List<Product> selectNotInStockProductList();
	List<Product> selectProductListByItem(String productItem);
	List<Product> selectNotInStockProductListByItem(String productItem);
	List<Product> searchProductByName(String productName);
	void updateProductInAmount(Product productNo);
	Product selectProductByNo(int productNo);
	List<PayProdInfo> selectHotProduct();
	int selectTotalAmount();
	List<PayProdInfo> selectTotalPrice();
	int selectTotalProfit();
}
