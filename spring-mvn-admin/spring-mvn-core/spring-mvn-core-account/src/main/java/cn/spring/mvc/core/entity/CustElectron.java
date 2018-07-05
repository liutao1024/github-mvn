package cn.spring.mvc.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author LiuTao @date 2018年6月9日 下午2:49:33
 * @ClassName: CustElectron 
 * @Description: 客户电子帐号
 */
@Entity
@Table(name = "cust_electron")
public class CustElectron implements Serializable {
	/**@Fields serialVersionUID : TODO(Describe)
	 */
	private static final long serialVersionUID = 4162583305577294244L;
	
	@Id
	@Column(name = "corpno", length = 4)
	private String corpno;// 法人代码
	@Id
	@Column(name = "custac", length = 35)
	private String custac;// 电子账号
	@Id
	@Column(name = "custno", length = 16)
	private String custno;// 客户号
	@Column(name = "custna", length = 100)
	private String custna;// 客户名称
	@Column(name = "cacttp", length = 10)
	private String cacttp;// 客户账号类型
	@Column(name = "opendt", length = 8)
	private String opendt;// 开户日期
	@Column(name = "opensq", length = 32)
	private String opensq;// 开户流水
	@Column(name = "closdt", length = 8)
	private String closdt;// 销户日期
	@Column(name = "clossq", length = 32)
	private String clossq;// 销户流水
	@Column(name = "cardno", length = 40)
	private String cardno;// 绑定卡号
	@Column(name = "accttp", length = 1)
	private String accttp;// 电子账户性质'
	@Column(name = "brchno", length = 10)
	private String brchno;// 开户机构
	@Column(name = "acctst", length = 1)
	private String acctst;// 账号状态
	@Column(name = "intrvl")
	private String intrvl;// 利率
	@Column(name = "datetm", length = 8)
	private String datetm;// 维护日期
	@Column(name = "timetm")
	private String timetm;// 时间戳
	public String getCorpno() {
		return corpno;
	}
	public void setCorpno(String corpno) {
		this.corpno = corpno;
	}
	public String getCustac() {
		return custac;
	}
	public void setCustac(String custac) {
		this.custac = custac;
	}
	public String getCustno() {
		return custno;
	}
	public void setCustno(String custno) {
		this.custno = custno;
	}
	public String getCustna() {
		return custna;
	}
	public void setCustna(String custna) {
		this.custna = custna;
	}
	public String getCacttp() {
		return cacttp;
	}
	public void setCacttp(String cacttp) {
		this.cacttp = cacttp;
	}
	public String getOpendt() {
		return opendt;
	}
	public void setOpendt(String opendt) {
		this.opendt = opendt;
	}
	public String getOpensq() {
		return opensq;
	}
	public void setOpensq(String opensq) {
		this.opensq = opensq;
	}
	public String getClosdt() {
		return closdt;
	}
	public void setClosdt(String closdt) {
		this.closdt = closdt;
	}
	public String getClossq() {
		return clossq;
	}
	public void setClossq(String clossq) {
		this.clossq = clossq;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getAccttp() {
		return accttp;
	}
	public void setAccttp(String accttp) {
		this.accttp = accttp;
	}
	public String getBrchno() {
		return brchno;
	}
	public void setBrchno(String brchno) {
		this.brchno = brchno;
	}
	public String getAcctst() {
		return acctst;
	}
	public void setAcctst(String acctst) {
		this.acctst = acctst;
	}
	public String getIntrvl() {
		return intrvl;
	}
	public void setIntrvl(String intrvl) {
		this.intrvl = intrvl;
	}
	public String getDatetm() {
		return datetm;
	}
	public void setDatetm(String datetm) {
		this.datetm = datetm;
	}
	public String getTimetm() {
		return timetm;
	}
	public void setTimetm(String timetm) {
		this.timetm = timetm;
	}
}