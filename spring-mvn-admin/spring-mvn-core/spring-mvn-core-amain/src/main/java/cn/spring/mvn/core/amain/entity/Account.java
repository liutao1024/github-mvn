package cn.spring.mvn.core.amain.entity;

import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author LiuTao @date 2018年6月9日 下午2:02:33
 * @ClassName: CustAcct
 * @Description: 个人客户帐号(负债帐号)
 */
@Table(name = "account")
public class Account {

	private String corpno;// 法人代码
	@Id
	private String custno;// 客户号
	@Id
	private String custac;// 电子账号
	@Id
	private String acctno;// 负债账号
	private String acctna;// 账户名称
	private String crcycd;// 货币代号
	private String csextg;// 账户钞汇标志
	private String depttm;// 存期
	private String matudt;// 到期日期
	private String bgindt;// 起息日期
	private String brchno;// 账户所属机构
	private String opendt;// 开户日期
	private String opensq;// 开户流水
	private String closdt;// 销户日期
	private String clossq;// 销户流水
	private double onlnbl;// 当前账户余额
	private String upbldt;// 余额更新日期
	private double lastbl;// 上日账户余额
	private String lstrdt;// 上次交易日期
	private String lstrsq;// 上次交易流水
	private String prodcd;// 产品编号
	private String pddpfg;// 产品定活标志
	private double hdmxmy;// 最大留存余额
	private double hdmimy;// 最小留存余额
	private String trsvtp;// 转存方式
	private double bkmony;// 备用金额
	private double opmony;// 开户金额
	private String debttp;// 存款种类
	private String acctst;// 账户状态
	private String sleptg;// 形态转移标志
	private String spectp;// 负债账户性质
	private String accttp;// 结算账户标志
	private String acctcd;// 核算代码
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctcd == null) ? 0 : acctcd.hashCode());
		result = prime * result + ((acctna == null) ? 0 : acctna.hashCode());
		result = prime * result + ((acctno == null) ? 0 : acctno.hashCode());
		result = prime * result + ((acctst == null) ? 0 : acctst.hashCode());
		result = prime * result + ((accttp == null) ? 0 : accttp.hashCode());
		result = prime * result + ((bgindt == null) ? 0 : bgindt.hashCode());
		long temp;
		temp = Double.doubleToLongBits(bkmony);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((brchno == null) ? 0 : brchno.hashCode());
		result = prime * result + ((closdt == null) ? 0 : closdt.hashCode());
		result = prime * result + ((clossq == null) ? 0 : clossq.hashCode());
		result = prime * result + ((corpno == null) ? 0 : corpno.hashCode());
		result = prime * result + ((crcycd == null) ? 0 : crcycd.hashCode());
		result = prime * result + ((csextg == null) ? 0 : csextg.hashCode());
		result = prime * result + ((custac == null) ? 0 : custac.hashCode());
		result = prime * result + ((custno == null) ? 0 : custno.hashCode());
		result = prime * result + ((datetm == null) ? 0 : datetm.hashCode());
		result = prime * result + ((debttp == null) ? 0 : debttp.hashCode());
		result = prime * result + ((depttm == null) ? 0 : depttm.hashCode());
		temp = Double.doubleToLongBits(hdmimy);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(hdmxmy);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lastbl);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((lstrdt == null) ? 0 : lstrdt.hashCode());
		result = prime * result + ((lstrsq == null) ? 0 : lstrsq.hashCode());
		result = prime * result + ((matudt == null) ? 0 : matudt.hashCode());
		temp = Double.doubleToLongBits(onlnbl);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((opendt == null) ? 0 : opendt.hashCode());
		result = prime * result + ((opensq == null) ? 0 : opensq.hashCode());
		temp = Double.doubleToLongBits(opmony);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((pddpfg == null) ? 0 : pddpfg.hashCode());
		result = prime * result + ((prodcd == null) ? 0 : prodcd.hashCode());
		result = prime * result + ((sleptg == null) ? 0 : sleptg.hashCode());
		result = prime * result + ((spectp == null) ? 0 : spectp.hashCode());
		result = prime * result + ((timetm == null) ? 0 : timetm.hashCode());
		result = prime * result + ((trsvtp == null) ? 0 : trsvtp.hashCode());
		result = prime * result + ((upbldt == null) ? 0 : upbldt.hashCode());
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
		Account other = (Account) obj;
		if (acctcd == null) {
			if (other.acctcd != null)
				return false;
		} else if (!acctcd.equals(other.acctcd))
			return false;
		if (acctna == null) {
			if (other.acctna != null)
				return false;
		} else if (!acctna.equals(other.acctna))
			return false;
		if (acctno == null) {
			if (other.acctno != null)
				return false;
		} else if (!acctno.equals(other.acctno))
			return false;
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
		if (bgindt == null) {
			if (other.bgindt != null)
				return false;
		} else if (!bgindt.equals(other.bgindt))
			return false;
		if (Double.doubleToLongBits(bkmony) != Double
				.doubleToLongBits(other.bkmony))
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
		if (crcycd == null) {
			if (other.crcycd != null)
				return false;
		} else if (!crcycd.equals(other.crcycd))
			return false;
		if (csextg == null) {
			if (other.csextg != null)
				return false;
		} else if (!csextg.equals(other.csextg))
			return false;
		if (custac == null) {
			if (other.custac != null)
				return false;
		} else if (!custac.equals(other.custac))
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
		if (debttp == null) {
			if (other.debttp != null)
				return false;
		} else if (!debttp.equals(other.debttp))
			return false;
		if (depttm == null) {
			if (other.depttm != null)
				return false;
		} else if (!depttm.equals(other.depttm))
			return false;
		if (Double.doubleToLongBits(hdmimy) != Double
				.doubleToLongBits(other.hdmimy))
			return false;
		if (Double.doubleToLongBits(hdmxmy) != Double
				.doubleToLongBits(other.hdmxmy))
			return false;
		if (Double.doubleToLongBits(lastbl) != Double
				.doubleToLongBits(other.lastbl))
			return false;
		if (lstrdt == null) {
			if (other.lstrdt != null)
				return false;
		} else if (!lstrdt.equals(other.lstrdt))
			return false;
		if (lstrsq == null) {
			if (other.lstrsq != null)
				return false;
		} else if (!lstrsq.equals(other.lstrsq))
			return false;
		if (matudt == null) {
			if (other.matudt != null)
				return false;
		} else if (!matudt.equals(other.matudt))
			return false;
		if (Double.doubleToLongBits(onlnbl) != Double
				.doubleToLongBits(other.onlnbl))
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
		if (Double.doubleToLongBits(opmony) != Double
				.doubleToLongBits(other.opmony))
			return false;
		if (pddpfg == null) {
			if (other.pddpfg != null)
				return false;
		} else if (!pddpfg.equals(other.pddpfg))
			return false;
		if (prodcd == null) {
			if (other.prodcd != null)
				return false;
		} else if (!prodcd.equals(other.prodcd))
			return false;
		if (sleptg == null) {
			if (other.sleptg != null)
				return false;
		} else if (!sleptg.equals(other.sleptg))
			return false;
		if (spectp == null) {
			if (other.spectp != null)
				return false;
		} else if (!spectp.equals(other.spectp))
			return false;
		if (timetm == null) {
			if (other.timetm != null)
				return false;
		} else if (!timetm.equals(other.timetm))
			return false;
		if (trsvtp == null) {
			if (other.trsvtp != null)
				return false;
		} else if (!trsvtp.equals(other.trsvtp))
			return false;
		if (upbldt == null) {
			if (other.upbldt != null)
				return false;
		} else if (!upbldt.equals(other.upbldt))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [corpno=" + corpno + ", custac=" + custac
				+ ", custno=" + custno + ", acctno=" + acctno + ", acctna="
				+ acctna + ", crcycd=" + crcycd + ", csextg=" + csextg
				+ ", depttm=" + depttm + ", matudt=" + matudt + ", bgindt="
				+ bgindt + ", brchno=" + brchno + ", opendt=" + opendt
				+ ", opensq=" + opensq + ", closdt=" + closdt + ", clossq="
				+ clossq + ", onlnbl=" + onlnbl + ", upbldt=" + upbldt
				+ ", lastbl=" + lastbl + ", lstrdt=" + lstrdt + ", lstrsq="
				+ lstrsq + ", prodcd=" + prodcd + ", pddpfg=" + pddpfg
				+ ", hdmxmy=" + hdmxmy + ", hdmimy=" + hdmimy + ", trsvtp="
				+ trsvtp + ", bkmony=" + bkmony + ", opmony=" + opmony
				+ ", debttp=" + debttp + ", acctst=" + acctst + ", sleptg="
				+ sleptg + ", spectp=" + spectp + ", accttp=" + accttp
				+ ", acctcd=" + acctcd + ", datetm=" + datetm + ", timetm="
				+ timetm + "]";
	}
}
