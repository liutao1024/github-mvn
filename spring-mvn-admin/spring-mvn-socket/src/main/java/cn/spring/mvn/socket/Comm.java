package cn.spring.mvn.socket;

/**
 * @author LiuTao @date 2018年10月19日 下午3:19:40
 * @ClassName: Comm 
 * @Description: comm 常量字段
 */
public class Comm {
	private String corpno;// 法人代码
	private String prcscd;// 交易处理码 (接口码)
	public String getCorpno() {
		return corpno;
	}
	public void setCorpno(String corpno) {
		this.corpno = corpno;
	}
	public String getPrcscd() {
		return prcscd;
	}
	public void setPrcscd(String prcscd) {
		this.prcscd = prcscd;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corpno == null) ? 0 : corpno.hashCode());
		result = prime * result + ((prcscd == null) ? 0 : prcscd.hashCode());
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
		Comm other = (Comm) obj;
		if (corpno == null) {
			if (other.corpno != null)
				return false;
		} else if (!corpno.equals(other.corpno))
			return false;
		if (prcscd == null) {
			if (other.prcscd != null)
				return false;
		} else if (!prcscd.equals(other.prcscd))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Comm [corpno=" + corpno + ", prcscd=" + prcscd + "]";
	}
	
}
