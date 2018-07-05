package cn.spring.mvc.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LiuTao @date 2018年6月9日 下午2:02:33
 * @ClassName: CustAcct
 * @Description: 个人客户帐号(负债帐号)
 */
@Entity
@Table(name = "cust_account")
public class CustAccount implements Serializable {
	/**@Fields serialVersionUID : TODO(Describe)
	 */
	private static final long serialVersionUID = -7612563368846897333L;

	@Id
	@Column(name = "corpno", length = 4)
	private String corpno;// 法人代码
	@Id
	@Column(name = "custac", length = 35)
	private String custac;// 客户账号
	@Id
	@Column(name = "custno", length = 16)
	private String custno;// 客户号
	@Id
	@Column(name = "acctno", length = 40)
	private String acctno;// 负债账号
	@Column(name = "acctna", length = 100)
	private String acctna;// 账户名称
	@Column(name = "crcycd", length = 2)
	private String crcycd;// 货币代号
	@Column(name = "csextg", length = 1)
	private String csextg;// 账户钞汇标志
	@Column(name = "depttm", length = 6)
	private String depttm;// 存期
	@Column(name = "matudt", length = 8)
	private String matudt;// 到期日期
	@Column(name = "bgindt", length = 8)
	private String bgindt;// 起息日期
	@Column(name = "brchno", length = 10)
	private String brchno;// 账户所属机构
	@Column(name = "opendt", length = 8)
	private String opendt;// 开户日期
	@Column(name = "opensq", length = 32)
	private String opensq;// 开户流水
	@Column(name = "closdt", length = 8)
	private String closdt;// 销户日期
	@Column(name = "clossq", length = 32)
	private String clossq;// 销户流水
	@Column(name = "onlnbl")
	private double onlnbl;// 当前账户余额
	@Column(name = "upbldt", length = 8)
	private String upbldt;// 余额更新日期
	@Column(name = "lastbl")
	private double lastbl;// 上日账户余额
	@Column(name = "lstrdt", length = 8)
	private String lstrdt;// 上次交易日期
	@Column(name = "lstrsq", length = 32)
	private String lstrsq;// 上次交易流水
	@Column(name = "prodcd", length = 10)
	private String prodcd;// 产品编号
	@Column(name = "pddpfg", length = 1)
	private String pddpfg;// 产品定活标志
	@Column(name = "hdmxmy")
	private double hdmxmy;// 最大留存余额
	@Column(name = "hdmimy")
	private double hdmimy;// 最小留存余额
	@Column(name = "trsvtp", length = 1)
	private String trsvtp;// 转存方式
	@Column(name = "bkmony")
	private double bkmony;// 备用金额
	@Column(name = "opmony")
	private double opmony;// 开户金额
	@Column(name = "debttp", length = 2)
	private String debttp;// 存款种类
	@Column(name = "acctst", length = 1)
	private String acctst;// 账户状态
	@Column(name = "sleptg", length = 1)
	private String sleptg;// 形态转移标志
	@Column(name = "spectp", length = 1)
	private String spectp;// 负债账户性质
	@Column(name = "accttp", length = 1)
	private String accttp;// 结算账户标志
	@Column(name = "acctcd", length = 20)
	private String acctcd;// 核算代码
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
	public String getAcctno() {
		return acctno;
	}
	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}
	public String getAcctna() {
		return acctna;
	}
	public void setAcctna(String acctna) {
		this.acctna = acctna;
	}
	public String getCrcycd() {
		return crcycd;
	}
	public void setCrcycd(String crcycd) {
		this.crcycd = crcycd;
	}
	public String getCsextg() {
		return csextg;
	}
	public void setCsextg(String csextg) {
		this.csextg = csextg;
	}
	public String getDepttm() {
		return depttm;
	}
	public void setDepttm(String depttm) {
		this.depttm = depttm;
	}
	public String getMatudt() {
		return matudt;
	}
	public void setMatudt(String matudt) {
		this.matudt = matudt;
	}
	public String getBgindt() {
		return bgindt;
	}
	public void setBgindt(String bgindt) {
		this.bgindt = bgindt;
	}
	public String getBrchno() {
		return brchno;
	}
	public void setBrchno(String brchno) {
		this.brchno = brchno;
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
	public double getOnlnbl() {
		return onlnbl;
	}
	public void setOnlnbl(double onlnbl) {
		this.onlnbl = onlnbl;
	}
	public String getUpbldt() {
		return upbldt;
	}
	public void setUpbldt(String upbldt) {
		this.upbldt = upbldt;
	}
	public double getLastbl() {
		return lastbl;
	}
	public void setLastbl(double lastbl) {
		this.lastbl = lastbl;
	}
	public String getLstrdt() {
		return lstrdt;
	}
	public void setLstrdt(String lstrdt) {
		this.lstrdt = lstrdt;
	}
	public String getLstrsq() {
		return lstrsq;
	}
	public void setLstrsq(String lstrsq) {
		this.lstrsq = lstrsq;
	}
	public String getProdcd() {
		return prodcd;
	}
	public void setProdcd(String prodcd) {
		this.prodcd = prodcd;
	}
	public String getPddpfg() {
		return pddpfg;
	}
	public void setPddpfg(String pddpfg) {
		this.pddpfg = pddpfg;
	}
	public double getHdmxmy() {
		return hdmxmy;
	}
	public void setHdmxmy(double hdmxmy) {
		this.hdmxmy = hdmxmy;
	}
	public double getHdmimy() {
		return hdmimy;
	}
	public void setHdmimy(double hdmimy) {
		this.hdmimy = hdmimy;
	}
	public String getTrsvtp() {
		return trsvtp;
	}
	public void setTrsvtp(String trsvtp) {
		this.trsvtp = trsvtp;
	}
	public double getBkmony() {
		return bkmony;
	}
	public void setBkmony(double bkmony) {
		this.bkmony = bkmony;
	}
	public double getOpmony() {
		return opmony;
	}
	public void setOpmony(double opmony) {
		this.opmony = opmony;
	}
	public String getDebttp() {
		return debttp;
	}
	public void setDebttp(String debttp) {
		this.debttp = debttp;
	}
	public String getAcctst() {
		return acctst;
	}
	public void setAcctst(String acctst) {
		this.acctst = acctst;
	}
	public String getSleptg() {
		return sleptg;
	}
	public void setSleptg(String sleptg) {
		this.sleptg = sleptg;
	}
	public String getSpectp() {
		return spectp;
	}
	public void setSpectp(String spectp) {
		this.spectp = spectp;
	}
	public String getAccttp() {
		return accttp;
	}
	public void setAccttp(String accttp) {
		this.accttp = accttp;
	}
	public String getAcctcd() {
		return acctcd;
	}
	public void setAcctcd(String acctcd) {
		this.acctcd = acctcd;
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
