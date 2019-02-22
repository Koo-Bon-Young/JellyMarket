package kr.co.ljy.jellyshop.vo;

import java.util.Date;

public class Qna {
	private int askNo;
	private int productNo;
	private int memberNo;
	private String askTitle;
	private String askContent;
	private String ansTitle;
	private String ansContent;
	private Date askRegDate;
	private Date ansRegDate;
	
	public int getAskNo() {
		return askNo;
	}
	public void setAskNo(int askNo) {
		this.askNo = askNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getAskTitle() {
		return askTitle;
	}
	public void setAskTitle(String askTitle) {
		this.askTitle = askTitle;
	}
	public String getAskContent() {
		return askContent;
	}
	public void setAskContent(String askContent) {
		this.askContent = askContent;
	}
	public String getAnsTitle() {
		return ansTitle;
	}
	public void setAnsTitle(String ansTitle) {
		this.ansTitle = ansTitle;
	}
	public String getAnsContent() {
		return ansContent;
	}
	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}
	public Date getAskRegDate() {
		return askRegDate;
	}
	public void setAskRegDate(Date askRegDate) {
		this.askRegDate = askRegDate;
	}
	public Date getAnsRegDate() {
		return ansRegDate;
	}
	public void setAnsRegDate(Date ansRegDate) {
		this.ansRegDate = ansRegDate;
	}
	
	

}