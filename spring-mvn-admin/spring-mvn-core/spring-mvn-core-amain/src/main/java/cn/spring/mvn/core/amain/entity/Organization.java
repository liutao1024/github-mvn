package cn.spring.mvn.core.amain.entity;

/**
 * @author LiuTao @date 2018年11月6日 下午1:52:58
 * @ClassName: Organization 
 * @Description: 组织机构表
 */
public class Organization {
	
	private String corpno;//法人代码
	private String brchno;//机构号
	private String brchna;//机构名称
	private String parbrc;//父级机构号
	private String brchad;//机构地址
	public String getCorpno() {
		return corpno;
	}
	public void setCorpno(String corpno) {
		this.corpno = corpno;
	}
	public String getBrchno() {
		return brchno;
	}
	public void setBrchno(String brchno) {
		this.brchno = brchno;
	}
	public String getBrchna() {
		return brchna;
	}
	public void setBrchna(String brchna) {
		this.brchna = brchna;
	}
	public String getParbrc() {
		return parbrc;
	}
	public void setParbrc(String parbrc) {
		this.parbrc = parbrc;
	}
	public String getBrchad() {
		return brchad;
	}
	public void setBrchad(String brchad) {
		this.brchad = brchad;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brchad == null) ? 0 : brchad.hashCode());
		result = prime * result + ((brchna == null) ? 0 : brchna.hashCode());
		result = prime * result + ((brchno == null) ? 0 : brchno.hashCode());
		result = prime * result + ((corpno == null) ? 0 : corpno.hashCode());
		result = prime * result + ((parbrc == null) ? 0 : parbrc.hashCode());
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
		Organization other = (Organization) obj;
		if (brchad == null) {
			if (other.brchad != null)
				return false;
		} else if (!brchad.equals(other.brchad))
			return false;
		if (brchna == null) {
			if (other.brchna != null)
				return false;
		} else if (!brchna.equals(other.brchna))
			return false;
		if (brchno == null) {
			if (other.brchno != null)
				return false;
		} else if (!brchno.equals(other.brchno))
			return false;
		if (corpno == null) {
			if (other.corpno != null)
				return false;
		} else if (!corpno.equals(other.corpno))
			return false;
		if (parbrc == null) {
			if (other.parbrc != null)
				return false;
		} else if (!parbrc.equals(other.parbrc))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Organization [corpno=" + corpno + ", brchno=" + brchno
				+ ", brchna=" + brchna + ", parbrc=" + parbrc + ", brchad="
				+ brchad + "]";
	}
}