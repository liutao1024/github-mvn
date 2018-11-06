package cn.spring.mvn.core.amain.entity;

/**
 * @author LiuTao @date 2018年6月9日 下午2:49:33
 * @ClassName: CustElectron 
 * @Description: 客户电子帐号
 */
public class Electron {
	
	private String corpno;// 法人代码
	private String custac;// 电子账号
	private String custno;// 客户号
	private String custna;// 客户名称
	private String cacttp;// 客户账号类型
	private String opendt;// 开户日期
	private String opensq;// 开户流水
	private String closdt;// 销户日期
	private String clossq;// 销户流水
	private String cardno;// 绑定卡号
	private String accttp;// 电子账户性质
	private String brchno;// 开户机构
	private String acctst;// 账号状态
	private String intrvl;// 利率
	private String datetm;// 维护日期
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctst == null) ? 0 : acctst.hashCode());
		result = prime * result + ((accttp == null) ? 0 : accttp.hashCode());
		result = prime * result + ((brchno == null) ? 0 : brchno.hashCode());
		result = prime * result + ((cacttp == null) ? 0 : cacttp.hashCode());
		result = prime * result + ((cardno == null) ? 0 : cardno.hashCode());
		result = prime * result + ((closdt == null) ? 0 : closdt.hashCode());
		result = prime * result + ((clossq == null) ? 0 : clossq.hashCode());
		result = prime * result + ((corpno == null) ? 0 : corpno.hashCode());
		result = prime * result + ((custac == null) ? 0 : custac.hashCode());
		result = prime * result + ((custna == null) ? 0 : custna.hashCode());
		result = prime * result + ((custno == null) ? 0 : custno.hashCode());
		result = prime * result + ((datetm == null) ? 0 : datetm.hashCode());
		result = prime * result + ((intrvl == null) ? 0 : intrvl.hashCode());
		result = prime * result + ((opendt == null) ? 0 : opendt.hashCode());
		result = prime * result + ((opensq == null) ? 0 : opensq.hashCode());
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
		Electron other = (Electron) obj;
		if (acctst == null) {
			if (other.acctst != null)
				return false;
		} else if (!acctst.equals(other.acctst))
			return false;
		if (accttp == null) {
			if (other.accttp != null)
				return false;
		} else if (!accttp.equals(other.accttp))
			return false;
		if (brchno == null) {
			if (other.brchno != null)
				return false;
		} else if (!brchno.equals(other.brchno))
			return false;
		if (cacttp == null) {
			if (other.cacttp != null)
				return false;
		} else if (!cacttp.equals(other.cacttp))
			return false;
		if (cardno == null) {
			if (other.cardno != null)
				return false;
		} else if (!cardno.equals(other.cardno))
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
		if (custac == null) {
			if (other.custac != null)
				return false;
		} else if (!custac.equals(other.custac))
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
		if (datetm == null) {
			if (other.datetm != null)
				return false;
		} else if (!datetm.equals(other.datetm))
			return false;
		if (intrvl == null) {
			if (other.intrvl != null)
				return false;
		} else if (!intrvl.equals(other.intrvl))
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
		if (timetm == null) {
			if (other.timetm != null)
				return false;
		} else if (!timetm.equals(other.timetm))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Electron [corpno=" + corpno + ", custac=" + custac
				+ ", custno=" + custno + ", custna=" + custna + ", cacttp="
				+ cacttp + ", opendt=" + opendt + ", opensq=" + opensq
				+ ", closdt=" + closdt + ", clossq=" + clossq + ", cardno="
				+ cardno + ", accttp=" + accttp + ", brchno=" + brchno
				+ ", acctst=" + acctst + ", intrvl=" + intrvl + ", datetm="
				+ datetm + ", timetm=" + timetm + "]";
	}
}