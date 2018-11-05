package cn.spring.mvn.core.entity;

/**
 * @author LiuTao @date 2018年11月5日 下午5:31:22
 * @ClassName: CoreProduct 
 * @Description: 核心产品表
 */
public class CoreProduct {
	private String prodno;
	private String prodtp;
	private String prodna;
	private String descri;

	public String getProdno() {
		return prodno;
	}

	public void setProdno(String prodno) {
		this.prodno = prodno;
	}

	public String getProdna() {
		return prodna;
	}

	public void setProdna(String prodna) {
		this.prodna = prodna;
	}

	public String getProdtp() {
		return prodtp;
	}

	public void setProdtp(String prodtp) {
		this.prodtp = prodtp;
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
		result = prime * result + ((descri == null) ? 0 : descri.hashCode());
		result = prime * result + ((prodna == null) ? 0 : prodna.hashCode());
		result = prime * result + ((prodno == null) ? 0 : prodno.hashCode());
		result = prime * result + ((prodtp == null) ? 0 : prodtp.hashCode());
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
		CoreProduct other = (CoreProduct) obj;
		if (descri == null) {
			if (other.descri != null)
				return false;
		} else if (!descri.equals(other.descri))
			return false;
		if (prodna == null) {
			if (other.prodna != null)
				return false;
		} else if (!prodna.equals(other.prodna))
			return false;
		if (prodno == null) {
			if (other.prodno != null)
				return false;
		} else if (!prodno.equals(other.prodno))
			return false;
		if (prodtp == null) {
			if (other.prodtp != null)
				return false;
		} else if (!prodtp.equals(other.prodtp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CoreProduct [prodno=" + prodno + ", prodna=" + prodna
				+ ", prodtp=" + prodtp + ", descri=" + descri + "]";
	}
}