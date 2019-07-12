package app.future.commons.bean;


import app.future.commons.base.PageModel;

import java.math.BigDecimal;
import java.util.Date;

public class Card {

	private PageModel model;
	
	private String customerId;
	
	private String customerName;
	
	private String cardNum;
	
	private String cardType;
	
	private BigDecimal cardMoney;
	
	private String cardStatus;
	
	private Date createTime;
	
	private Date modifyTime;
	
	private Date validEndDate;
	
	private String remark;
	
	private String res1;
	private String res2;
	private String res3;
	private String res4;
	private String res5;

	public Card() {
	}
	
	public Card(String customerId, String customerName, String cardNum,
			String cardType, String cardStatus, Date createTime,
			Date validEndDate,BigDecimal cardMoney,String remark) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.cardNum = cardNum;
		this.cardType = cardType;
		this.cardStatus = cardStatus;
		this.createTime = createTime;
		this.validEndDate = validEndDate;
		this.cardMoney = cardMoney;
		this.remark = remark;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getValidEndDate() {
		return validEndDate;
	}

	public void setValidEndDate(Date validEndDate) {
		this.validEndDate = validEndDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRes1() {
		return res1;
	}

	public void setRes1(String res1) {
		this.res1 = res1;
	}

	public String getRes2() {
		return res2;
	}

	public void setRes2(String res2) {
		this.res2 = res2;
	}

	public String getRes3() {
		return res3;
	}

	public void setRes3(String res3) {
		this.res3 = res3;
	}

	public String getRes4() {
		return res4;
	}

	public void setRes4(String res4) {
		this.res4 = res4;
	}

	public String getRes5() {
		return res5;
	}

	public void setRes5(String res5) {
		this.res5 = res5;
	}

	public BigDecimal getCardMoney() {
		return cardMoney;
	}

	public void setCardMoney(BigDecimal cardMoney) {
		this.cardMoney = cardMoney;
	}

	public PageModel getModel() {
		return model;
	}

	public void setModel(PageModel model) {
		this.model = model;
	}

}
