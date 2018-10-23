package cn.spring.mvn.socket.tipc;

import java.util.List;

import cn.spring.mvn.socket.Output;

public class OutputR implements Output{
	private int count;
	private List<OutputI> ouputis;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<OutputI> getOuputis() {
		return ouputis;
	}
	public void setOuputis(List<OutputI> ouputis) {
		this.ouputis = ouputis;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((ouputis == null) ? 0 : ouputis.hashCode());
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
		OutputR other = (OutputR) obj;
		if (count != other.count)
			return false;
		if (ouputis == null) {
			if (other.ouputis != null)
				return false;
		} else if (!ouputis.equals(other.ouputis))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OutputR [count=" + count + ", ouputis=" + ouputis + "]";
	}
}