package kr.co.ljy.jellyshop.vo;

import java.util.Date;
import java.util.List;

public class Product {
	private int ProductNo;
	private String ProductItem;
	private String ProductName;
	private int Price;
	private int InAmount;
	private Date InDate;
	private List<PayProdInfo> payProdInfo;
	
	public List<PayProdInfo> getPayProdInfo() {
		return payProdInfo;
	}
	public void setPayProdInfo(List<PayProdInfo> payProdInfo) {
		this.payProdInfo = payProdInfo;
	}
	public int getProductNo() {
		return ProductNo;
	}
	public void setProductNo(int productNo) {
		ProductNo = productNo;
	}
	public String getProductItem() {
		return ProductItem;
	}
	public void setProductItem(String productItem) {
		ProductItem = productItem;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getInAmount() {
		return InAmount;
	}
	public void setInAmount(int inAmount) {
		InAmount = inAmount;
	}
	public Date getInDate() {
		return InDate;
	}
	public void setInDate(Date inDate) {
		InDate = inDate;
	}
}
