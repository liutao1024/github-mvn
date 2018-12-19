package cn.spring.mvn.core.amain.zport;

import cn.spring.mvn.core.amain.entity.Customer;

/**
 * @Author LiuTao @Date 2018年11月17日 下午1:29:12
 * @ClassName: OpacctInput 
 * @Description: 核心开户输入接口
 * 				包含三要素
 */
public class OpacctInput {
	private String userName;
	private String certificateType;
	private String certificateNumber;
	private String phoneNumber;
	private String bankCardNumber;
	private Customer customer;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}
	public String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBankCardNumber() {
		return bankCardNumber;
	}
	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "OpacctInput [userName=" + userName + ", certificateType="
				+ certificateType + ", certificateNumber=" + certificateNumber
				+ ", phoneNumber=" + phoneNumber + ", bankCardNumber="
				+ bankCardNumber + ", customer=" + customer + "]";
	}
}
