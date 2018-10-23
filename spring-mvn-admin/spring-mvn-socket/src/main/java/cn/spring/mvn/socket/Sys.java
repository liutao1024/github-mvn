package cn.spring.mvn.socket;

/**
 * @author LiuTao @date 2018年10月19日 下午3:19:22
 * @ClassName: Sys 
 * @Description: sys 常量字段
 */
public class Sys {
	// 渠道系统部分
	private String servtp;// 渠道类型
	private String servno;// 渠道号
	private String servdt;// 渠道日期
	private String servtm;// 渠道时间
	private String servsq;// 渠道流水
	// 核心系统部分
	private String tranbr;// 交易机构
	private String tranus;// 交易柜员
	private String trandt;// 交易日期
	private String trantm;// 交易时间
	private String transq;// 交易流水
	private String status;// 交易状态
	private String mesage;// 交易信息
	public String getServtp() {
		return servtp;
	}
	public void setServtp(String servtp) {
		this.servtp = servtp;
	}
	public String getServno() {
		return servno;
	}
	public void setServno(String servno) {
		this.servno = servno;
	}
	public String getServdt() {
		return servdt;
	}
	public void setServdt(String servdt) {
		this.servdt = servdt;
	}
	public String getServtm() {
		return servtm;
	}
	public void setServtm(String servtm) {
		this.servtm = servtm;
	}
	public String getServsq() {
		return servsq;
	}
	public void setServsq(String servsq) {
		this.servsq = servsq;
	}
	public String getTranbr() {
		return tranbr;
	}
	public void setTranbr(String tranbr) {
		this.tranbr = tranbr;
	}
	public String getTranus() {
		return tranus;
	}
	public void setTranus(String tranus) {
		this.tranus = tranus;
	}
	public String getTrandt() {
		return trandt;
	}
	public void setTrandt(String trandt) {
		this.trandt = trandt;
	}
	public String getTrantm() {
		return trantm;
	}
	public void setTrantm(String trantm) {
		this.trantm = trantm;
	}
	public String getTransq() {
		return transq;
	}
	public void setTransq(String transq) {
		this.transq = transq;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMesage() {
		return mesage;
	}
	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mesage == null) ? 0 : mesage.hashCode());
		result = prime * result + ((servdt == null) ? 0 : servdt.hashCode());
		result = prime * result + ((servno == null) ? 0 : servno.hashCode());
		result = prime * result + ((servsq == null) ? 0 : servsq.hashCode());
		result = prime * result + ((servtm == null) ? 0 : servtm.hashCode());
		result = prime * result + ((servtp == null) ? 0 : servtp.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tranbr == null) ? 0 : tranbr.hashCode());
		result = prime * result + ((trandt == null) ? 0 : trandt.hashCode());
		result = prime * result + ((transq == null) ? 0 : transq.hashCode());
		result = prime * result + ((trantm == null) ? 0 : trantm.hashCode());
		result = prime * result + ((tranus == null) ? 0 : tranus.hashCode());
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
		Sys other = (Sys) obj;
		if (mesage == null) {
			if (other.mesage != null)
				return false;
		} else if (!mesage.equals(other.mesage))
			return false;
		if (servdt == null) {
			if (other.servdt != null)
				return false;
		} else if (!servdt.equals(other.servdt))
			return false;
		if (servno == null) {
			if (other.servno != null)
				return false;
		} else if (!servno.equals(other.servno))
			return false;
		if (servsq == null) {
			if (other.servsq != null)
				return false;
		} else if (!servsq.equals(other.servsq))
			return false;
		if (servtm == null) {
			if (other.servtm != null)
				return false;
		} else if (!servtm.equals(other.servtm))
			return false;
		if (servtp == null) {
			if (other.servtp != null)
				return false;
		} else if (!servtp.equals(other.servtp))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tranbr == null) {
			if (other.tranbr != null)
				return false;
		} else if (!tranbr.equals(other.tranbr))
			return false;
		if (trandt == null) {
			if (other.trandt != null)
				return false;
		} else if (!trandt.equals(other.trandt))
			return false;
		if (transq == null) {
			if (other.transq != null)
				return false;
		} else if (!transq.equals(other.transq))
			return false;
		if (trantm == null) {
			if (other.trantm != null)
				return false;
		} else if (!trantm.equals(other.trantm))
			return false;
		if (tranus == null) {
			if (other.tranus != null)
				return false;
		} else if (!tranus.equals(other.tranus))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sys [servtp=" + servtp + ", servno=" + servno + ", servdt="
				+ servdt + ", servtm=" + servtm + ", servsq=" + servsq
				+ ", tranbr=" + tranbr + ", tranus=" + tranus + ", trandt="
				+ trandt + ", trantm=" + trantm + ", transq=" + transq
				+ ", status=" + status + ", mesage=" + mesage + "]";
	}
}