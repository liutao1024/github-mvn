package cn.spring.mvn.socket.tipc;

public class OutputI {
	private String custno;
	private String custna;
	private String custsx;
	private String custag;
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
	public String getCustsx() {
		return custsx;
	}
	public void setCustsx(String custsx) {
		this.custsx = custsx;
	}
	public String getCustag() {
		return custag;
	}
	public void setCustag(String custag) {
		this.custag = custag;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custag == null) ? 0 : custag.hashCode());
		result = prime * result + ((custna == null) ? 0 : custna.hashCode());
		result = prime * result + ((custno == null) ? 0 : custno.hashCode());
		result = prime * result + ((custsx == null) ? 0 : custsx.hashCode());
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
		OutputI other = (OutputI) obj;
		if (custag == null) {
			if (other.custag != null)
				return false;
		} else if (!custag.equals(other.custag))
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
		if (custsx == null) {
			if (other.custsx != null)
				return false;
		} else if (!custsx.equals(other.custsx))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OutputI [custno=" + custno + ", custna=" + custna + ", custsx="
				+ custsx + ", custag=" + custag + "]";
	}
	
}
