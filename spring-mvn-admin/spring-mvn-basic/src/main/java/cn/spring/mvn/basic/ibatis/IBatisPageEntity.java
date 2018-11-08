package cn.spring.mvn.basic.ibatis;


public class IBatisPageEntity<T> {
	private Integer page; //目前是第几页
	private Integer size; //每页大小
	private T entity; //传入的参数
	private String orderColumn;
	private String orderTurn = "ASC";
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
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	public String getOrderColumn() {
		return orderColumn;
	}
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	public String getOrderTurn() {
		return orderTurn;
	}
	public void setOrderTurn(String orderTurn) {
		this.orderTurn = orderTurn;
	}
}