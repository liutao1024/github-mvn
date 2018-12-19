package cn.spring.mvn.core.amain.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author LiuTao @Date 2018年11月17日 下午2:47:41
 * @ClassName: BankCard 
 * @Description: 绑定卡信息
 */
@Table(name = "bank_card")
public class BankCard {
	@Id
	private String bankType;
	@Id
	private String bankCardNumber;
	private Date bindingDate;
	private String electronNumber;
	private String customerName;
	private Date openDate;
	private String openBankName;
	private String openBankNunmber;
	private String openBankAddress;
	public String getBankType() {
		return bankType;
	}
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	public String getBankCardNumber() {
		return bankCardNumber;
	}
	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}
	public Date getBindingDate() {
		return bindingDate;
	}
	public void setBindingDate(Date bindingDate) {
		this.bindingDate = bindingDate;
	}
	public String getElectronNumber() {
		return electronNumber;
	}
	public void setElectronNumber(String electronNumber) {
		this.electronNumber = electronNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public String getOpenBankName() {
		return openBankName;
	}
	public void setOpenBankName(String openBankName) {
		this.openBankName = openBankName;
	}
	public String getOpenBankNunmber() {
		return openBankNunmber;
	}
	public void setOpenBankNunmber(String openBankNunmber) {
		this.openBankNunmber = openBankNunmber;
	}
	public String getOpenBankAddress() {
		return openBankAddress;
	}
	public void setOpenBankAddress(String openBankAddress) {
		this.openBankAddress = openBankAddress;
	}
	@Override
	public String toString() {
		return "BankCard [bankType=" + bankType + ", bankCardNumber="
				+ bankCardNumber + ", bindingDate=" + bindingDate
				+ ", electronNumber=" + electronNumber + ", customerName="
				+ customerName + ", openDate=" + openDate + ", openBankName="
				+ openBankName + ", openBankNunmber=" + openBankNunmber
				+ ", openBankAddress=" + openBankAddress + "]";
	}
	
}
