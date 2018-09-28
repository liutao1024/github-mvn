package cn.spring.mvn.core.account.entity;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addrcd == null) ? 0 : addrcd.hashCode());
		result = prime * result + ((addres == null) ? 0 : addres.hashCode());
		result = prime * result + ((birthd == null) ? 0 : birthd.hashCode());
		result = prime * result + ((brchno == null) ? 0 : brchno.hashCode());
		result = prime * result + ((closdt == null) ? 0 : closdt.hashCode());
		result = prime * result + ((clossq == null) ? 0 : clossq.hashCode());
		result = prime * result + ((corpno == null) ? 0 : corpno.hashCode());
		result = prime * result + ((cuslvl == null) ? 0 : cuslvl.hashCode());
		result = prime * result + ((custna == null) ? 0 : custna.hashCode());
		result = prime * result + ((custno == null) ? 0 : custno.hashCode());
		result = prime * result + ((custst == null) ? 0 : custst.hashCode());
		result = prime * result + ((datetm == null) ? 0 : datetm.hashCode());
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result + ((emplcu == null) ? 0 : emplcu.hashCode());
		result = prime * result + ((idtfno == null) ? 0 : idtfno.hashCode());
		result = prime * result + ((idtftp == null) ? 0 : idtftp.hashCode());
		result = prime * result + ((opendt == null) ? 0 : opendt.hashCode());
		result = prime * result + ((opensq == null) ? 0 : opensq.hashCode());
		result = prime * result + ((postcd == null) ? 0 : postcd.hashCode());
		result = prime * result + ((sextyp == null) ? 0 : sextyp.hashCode());
		result = prime * result + ((teleno == null) ? 0 : teleno.hashCode());
		result = prime * result + ((timetm == null) ? 0 : timetm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustUser other = (CustUser) obj;
		if (addrcd == null) {
			if (other.addrcd != null)
				return false;
		} else if (!addrcd.equals(other.addrcd))
			return false;
		if (addres == null) {
			if (other.addres != null)
				return false;
		} else if (!addres.equals(other.addres))
			return false;
		if (birthd == null) {
			if (other.birthd != null)
				return false;
		} else if (!birthd.equals(other.birthd))
			return false;
		if (brchno == null) {
			if (other.brchno != null)
				return false;
		} else if (!brchno.equals(other.brchno))
			return false;
		if (closdt == null) {
			if (other.closdt != null)
				return false;
		} else if (!closdt.equals(other.closdt))
			return false;
		if (clossq == null) {
			if (other.clossq != null)
				return false;
		} else if (!clossq.equals(other.clossq))
			return false;
		if (corpno == null) {
			if (other.corpno != null)
				return false;
		} else if (!corpno.equals(other.corpno))
			return false;
		if (cuslvl == null) {
			if (other.cuslvl != null)
				return false;
		} else if (!cuslvl.equals(other.cuslvl))
			return false;
		if (custna == null) {
			if (other.custna != null)
				return false;
		} else if (!custna.equals(other.custna))
			return false;
		if (custno == null) {
			if (other.custno != null)
				return false;
		} else if (!custno.equals(other.custno))
			return false;
		if (custst == null) {
			if (other.custst != null)
				return false;
		} else if (!custst.equals(other.custst))
			return false;
		if (datetm == null) {
			if (other.datetm != null)
				return false;
		} else if (!datetm.equals(other.datetm))
			return false;
		if (emails == null) {
			if (other.emails != null)
				return false;
		} else if (!emails.equals(other.emails))
			return false;
		if (emplcu == null) {
			if (other.emplcu != null)
				return false;
		} else if (!emplcu.equals(other.emplcu))
			return false;
		if (idtfno == null) {
			if (other.idtfno != null)
				return false;
		} else if (!idtfno.equals(other.idtfno))
			return false;
		if (idtftp == null) {
			if (other.idtftp != null)
				return false;
		} else if (!idtftp.equals(other.idtftp))
			return false;
		if (opendt == null) {
			if (other.opendt != null)
				return false;
		} else if (!opendt.equals(other.opendt))
			return false;
		if (opensq == null) {
			if (other.opensq != null)
				return false;
		} else if (!opensq.equals(other.opensq))
			return false;
		if (postcd == null) {
			if (other.postcd != null)
				return false;
		} else if (!postcd.equals(other.postcd))
			return false;
		if (sextyp == null) {
			if (other.sextyp != null)
				return false;
		} else if (!sextyp.equals(other.sextyp))
			return false;
		if (teleno == null) {
			if (other.teleno != null)
				return false;
		} else if (!teleno.equals(other.teleno))
			return false;
		if (timetm == null) {
			if (other.timetm != null)
				return false;
		} else if (!timetm.equals(other.timetm))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustUser [corpno=" + corpno + ", custno=" + custno
				+ ", custna=" + custna + ", idtftp=" + idtftp + ", idtfno="
				+ idtfno + ", birthd=" + birthd + ", sextyp=" + sextyp
				+ ", addrcd=" + addrcd + ", teleno=" + teleno + ", emails="
				+ emails + ", postcd=" + postcd + ", addres=" + addres
				+ ", brchno=" + brchno + ", opendt=" + opendt + ", opensq="
				+ opensq + ", closdt=" + closdt + ", clossq=" + clossq
				+ ", custst=" + custst + ", datetm=" + datetm + ", timetm="
				+ timetm + ", cuslvl=" + cuslvl + ", emplcu=" + emplcu + "]";
	}
}