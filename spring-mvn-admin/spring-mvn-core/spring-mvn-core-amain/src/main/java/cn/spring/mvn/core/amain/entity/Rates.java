package cn.spring.mvn.core.amain.entity;

/**
 * @author LiuTao @date 2018年11月6日 下午1:54:25
 * @ClassName: Rates 
 * @Description: 利率信息表
 */
public class Rates {
	private String corpno;//法人代码
	private String rateno;//利率编号
	private String ratena;//利率名称
	private String ratevl;//利率值
	private String descri;//利率描述
	public String getCorpno() {
		return corpno;
	}
	public void setCorpno(String corpno) {
		this.corpno = corpno;
	}
	public String getRateno() {
		return rateno;
	}
	public void setRateno(String rateno) {
		this.rateno = rateno;
	}
	public String getRatena() {
		return ratena;
	}
	public void setRatena(String ratena) {
		this.ratena = ratena;
	}
	public String getRatevl() {
		return ratevl;
	}
	public void setRatevl(String ratevl) {
		this.ratevl = ratevl;
	}
	public String getDescri() {
		return descri;
	}
	public void setDescri(String descri) {
		this.descri = descri;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corpno == null) ? 0 : corpno.hashCode());
		result = prime * result + ((descri == null) ? 0 : descri.hashCode());
		result = prime * result + ((ratena == null) ? 0 : ratena.hashCode());
		result = prime * result + ((rateno == null) ? 0 : rateno.hashCode());
		result = prime * result + ((ratevl == null) ? 0 : ratevl.hashCode());
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
		Rates other = (Rates) obj;
		if (corpno == null) {
			if (other.corpno != null)
				return false;
		} else if (!corpno.equals(other.corpno))
			return false;
		if (descri == null) {
			if (other.descri != null)
				return false;
		} else if (!descri.equals(other.descri))
			return false;
		if (ratena == null) {
			if (other.ratena != null)
				return false;
		} else if (!ratena.equals(other.ratena))
			return false;
		if (rateno == null) {
			if (other.rateno != null)
				return false;
		} else if (!rateno.equals(other.rateno))
			return false;
		if (ratevl == null) {
			if (other.ratevl != null)
				return false;
		} else if (!ratevl.equals(other.ratevl))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Rates [corpno=" + corpno + ", rateno=" + rateno + ", ratena="
				+ ratena + ", ratevl=" + ratevl + ", descri=" + descri + "]";
	}
}
