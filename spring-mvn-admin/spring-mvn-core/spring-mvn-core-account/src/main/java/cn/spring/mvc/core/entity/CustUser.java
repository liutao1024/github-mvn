package cn.spring.mvc.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LiuTao @date 2018年6月9日 下午2:02:05
 * @ClassName: CustUser
 * @Description: 个人客户信息
 */
@Entity
@Table(name = "cust_user")
public class CustUser implements Serializable {
	/** @Fields serialVersionUID : TODO(Describe)
	 */
	private static final long serialVersionUID = -2873447728024852037L;
	
	@Column(name = "corpno", length = 4)
	private String corpno;// 法人代码
	@Column(name = "custno", length = 16)
	private String custno;// 客户号
	@Column(name = "custna", length = 100)
	private String custna;// 客户名称
	@Id
	@Column(name = "idtftp", length = 2)
	private String idtftp;// 证件类型
	@Id
	@Column(name = "idtfno", length = 80)
	private String idtfno;// 证件号码
	@Column(name = "birthd", length = 8)
	private String birthd;// 出生日期
	@Column(name = "sextyp", length = 1)
	private String sextyp;// 性别
	@Column(name = "addrcd", length = 50)
	private String addrcd;// 所在行政
	@Column(name = "teleno", length = 80)
	private String teleno;// 电话号码
	@Column(name = "emails", length = 200)
	private String emails;// 邮箱
	@Column(name = "postcd", length = 10)
	private String postcd;// 邮编
	@Column(name = "addres", length = 255)
	private String addres;// 地址
	@Column(name = "brchno", length = 10)
	private String brchno;// 开户部门
	@Column(name = "opendt", length = 8)
	private String opendt;// 开户日期
	@Column(name = "opensq", length = 32)
	private String opensq;// 开户流水
	@Column(name = "closdt", length = 8)
	private String closdt;// 销户日期
	@Column(name = "clossq", length = 32)
	private String clossq;// 销户流水
	@Column(name = "custst", length = 1)
	private String custst;// 客户状态
	@Column(name = "datetm", length = 8)
	private String datetm;// 维护日期
	@Column(name = "timetm", length = 19)
	private String timetm;// 时间戳
	@Column(name = "cuslvl", length = 2)
	private String cuslvl;// 客户级别
	@Column(name = "emplcu", length = 1)
	private String emplcu;//

	public String getCorpno() {
		return corpno;
	}

	public void setCorpno(String corpno) {
		this.corpno = corpno;
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

	public String getIdtftp() {
		return idtftp;
	}

	public void setIdtftp(String idtftp) {
		this.idtftp = idtftp;
	}

	public String getIdtfno() {
		return idtfno;
	}

	public void setIdtfno(String idtfno) {
		this.idtfno = idtfno;
	}

	public String getBirthd() {
		return birthd;
	}

	public void setBirthd(String birthd) {
		this.birthd = birthd;
	}

	public String getSextyp() {
		return sextyp;
	}

	public void setSextyp(String sextyp) {
		this.sextyp = sextyp;
	}

	public String getAddrcd() {
		return addrcd;
	}

	public void setAddrcd(String addrcd) {
		this.addrcd = addrcd;
	}

	public String getTeleno() {
		return teleno;
	}

	public void setTeleno(String teleno) {
		this.teleno = teleno;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getPostcd() {
		return postcd;
	}

	public void setPostcd(String postcd) {
		this.postcd = postcd;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
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

	public String getCustst() {
		return custst;
	}

	public void setCustst(String custst) {
		this.custst = custst;
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

	public String getCuslvl() {
		return cuslvl;
	}

	public void setCuslvl(String cuslvl) {
		this.cuslvl = cuslvl;
	}

	public String getEmplcu() {
		return emplcu;
	}

	public void setEmplcu(String emplcu) {
		this.emplcu = emplcu;
	}
}