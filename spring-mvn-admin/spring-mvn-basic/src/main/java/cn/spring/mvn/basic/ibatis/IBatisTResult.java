package cn.spring.mvn.basic.ibatis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuTao @date 2018年11月13日 下午5:53:46
 * @ClassName: IBatisTResult 
 * @Description: TODO(Describe) 
 * @param <T>
 */
public class IBatisTResult<T> {
	// 传入的参数
	private T entity; 
	// 总共记录条数
	private Long count;
	// 目前是第几页
	private Integer page;
	// 每页记录数
	private Integer size;
	// 想要的结果集
	private List<T> resultList = new ArrayList<T>();
	
	public IBatisTResult(){
		super();
	}
	public IBatisTResult(List<T> resultList){
		super();
		this.count = (long) resultList.size();
		this.resultList = resultList;
	}
	public IBatisTResult(Long count, List<T> resultList){
		super();
		this.count = count;
		this.resultList = resultList;
	}
	public IBatisTResult(Integer page, Integer size, List<T> resultList){
		super();
		Integer totalCount = resultList.size();
		this.count = (long) totalCount;
		Integer start = page * size;
		Integer end = (page + 1) * size;
		List<T> realList = new ArrayList<T>();
		if(start <= totalCount){//起始数不大于总数时
			if(end > totalCount){
				end = totalCount;
			}
			realList = resultList.subList(start, end);//此处的List需要根据page和size进行组装
		}
		this.resultList = realList;
	}
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
}