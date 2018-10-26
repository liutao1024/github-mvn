package cn.spring.mvn.core.account.zport;

import java.util.List;

import cn.spring.mvn.core.account.entity.CustUser;

public class QrcustOutput{
	int count;
	List<CustUser> infos;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<CustUser> getInfos() {
		return infos;
	}
	public void setInfos(List<CustUser> infos) {
		this.infos = infos;
	}
	@Override
	public String toString() {
		return "QrcustOutput [count=" + count + ", infos=" + infos + "]";
	}
	
}

