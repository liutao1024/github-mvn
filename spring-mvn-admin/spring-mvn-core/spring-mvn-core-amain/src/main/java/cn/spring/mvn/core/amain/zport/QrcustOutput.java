package cn.spring.mvn.core.amain.zport;

import java.util.List;

import cn.spring.mvn.core.amain.entity.Customer;

public class QrcustOutput{
	int count;
	List<Customer> infos;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Customer> getInfos() {
		return infos;
	}
	public void setInfos(List<Customer> infos) {
		this.infos = infos;
	}
	@Override
	public String toString() {
		return "QrcustOutput [count=" + count + ", infos=" + infos + "]";
	}
	
}

