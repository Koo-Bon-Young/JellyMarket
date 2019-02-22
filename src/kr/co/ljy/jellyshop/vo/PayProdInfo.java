package kr.co.ljy.jellyshop.vo;

public class PayProdInfo {
	private int payProdInfoNo;
	private int memberNo;
	private int paymentNo;
	private int productNo;
	private String productName;
	private int price;
	private int payAmount;
	private int sumAmount;
	private int sumPrice;
	
	
	public int getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}
	public int getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(int sumAmount) {
		this.sumAmount = sumAmount;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getPayProdInfoNo() {
		return payProdInfoNo;
	}
	public void setPayProdInfoNo(int payProdInfoNo) {
		this.payProdInfoNo = payProdInfoNo;
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}
}
