package cn.spring.mvn.basic.ibatis;

import java.util.ArrayList;
import java.util.List;

public class IBatisPageResult<T> {
	// 总共记录条数
	private Integer totalCount;
	// 结果集
	private List<T> resultList = new ArrayList<T>();
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
}
