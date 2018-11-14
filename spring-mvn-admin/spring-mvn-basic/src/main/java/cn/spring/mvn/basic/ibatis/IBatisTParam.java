package cn.spring.mvn.basic.ibatis;

import java.util.Map;

import javax.persistence.Table;

import cn.spring.mvn.basic.util.BasicUtil;


public class IBatisTParam<T> {
	private T entity; //传入的参数
	
	private Integer page; //目前是第几页
	private Integer size; //每页记录数
	private String tableName;//数据库表名
	private Map<String, Object> paramMap;//
	private String orderColumn;//排序的列
	private String orderTurn = "ASC";//排序方式(顺序[ASC],倒序[DSC])
	
	
	
	public IBatisTParam(T entity, Integer page, Integer size, String orderColumn, String orderTurn) {
		super();
		this.entity = entity;
		//需要考虑到非分页
		this.page = page;
		this.size = size;
		this.tableName = this.getTableName();
		this.paramMap = this.getParamMap();
		this.orderColumn = orderColumn;
		this.orderTurn = orderTurn;
	}
	
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
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
	public String getTableName() {
		Class<?> clazz = Table.class;
		Table annotation = (Table) BasicUtil.getAnnotationByReflectAnnotationClass(this.entity, clazz);
		String annotationName = annotation.name();
		String ClassName = entity.getClass().getSimpleName();
		if(BasicUtil.isNotNull(annotationName)){//Table注解不为空且name属性有值时取其值
			tableName = annotationName;
		}else {//否则按照驼峰命名规则将类名转成表明,如 UserInfo----->user_info
			tableName = BasicUtil.presentHumpNamedToUnderScoreString(ClassName, false);
		}
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Map<String, Object> getParamMap() {
		paramMap = BasicUtil.getMapByReflectWithObject(this.entity);
		return paramMap;
	}
	public void setParamMap(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
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
	
	@Override
	public String toString() {
		return "IBatisPageEntity [entity=" + entity + ", page=" + page
				+ ", size=" + size + ", tableName=" + tableName + ", paramMap="
				+ paramMap + ", orderColumn=" + orderColumn + ", orderTurn="
				+ orderTurn + "]";
	}
	
}