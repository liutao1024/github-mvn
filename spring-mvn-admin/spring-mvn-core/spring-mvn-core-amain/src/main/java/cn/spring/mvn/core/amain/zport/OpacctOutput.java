package cn.spring.mvn.core.amain.zport;


/**
 * @Author LiuTao @Date 2018年11月17日 下午1:29:12
 * @ClassName: OpacctInput 
 * @Description: 核心开户输出接口
 * 				包含三要素
 */
public class OpacctOutput {
	private String accountName;
	private String custNumber;
	private String electronNumber;
	private String accountNumber;
	private String bankCardNumber;
	private String openAccountSerial;
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getCustNumber() {
		return custNumber;
	}
	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}
	public String getElectronNumber() {
		return electronNumber;
	}
	public void setElectronNumber(String electronNumber) {
		this.electronNumber = electronNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankCardNumber() {
		return bankCardNumber;
	}
	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}
	public String getOpenAccountSerial() {
		return openAccountSerial;
	}
	public void setOpenAccountSerial(String openAccountSerial) {
		this.openAccountSerial = openAccountSerial;
	}
	@Override
	public String toString() {
		return "OpacctOutput [accountName=" + accountName + ", custNumber="
				+ custNumber + ", electronNumber=" + electronNumber
				+ ", accountNumber=" + accountNumber + ", bankCardNumber="
				+ bankCardNumber + ", openAccountSerial=" + openAccountSerial
				+ "]";
	}
	
}
