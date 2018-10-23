package cn.spring.mvn.socket.tipc;

import cn.spring.mvn.socket.Input;

public class InputR implements Input{
	private String custno;
	private String custna;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custna == null) ? 0 : custna.hashCode());
		result = prime * result + ((custno == null) ? 0 : custno.hashCode());
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
		InputR other = (InputR) obj;
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
		return true;
	}
	@Override
	public String toString() {
		return "InputR [custno=" + custno + ", custna=" + custna + "]";
	}
}