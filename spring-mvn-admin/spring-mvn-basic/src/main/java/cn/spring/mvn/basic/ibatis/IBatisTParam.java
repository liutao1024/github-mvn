package cn.spring.mvn.basic.ibatis;

import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Id;
import javax.persistence.Table;

import cn.spring.mvn.basic.tools.BasicReflection;
import cn.spring.mvn.basic.util.BasicUtil;

/**
 * @author LiuTao @date 2018年11月14日 下午2:16:56
 * @ClassName: IBatisTParam 
 * @Description: 	其中泛型T需要遵循以下规则
 * 					<p>1.表名默认使用类名,驼峰转下划线(只对大写字母进行处理),如UserInfo默认对应的表名为user_info.<p>
 * 					<p>2.对不符合第一条默认规则的可以通过@Table(name = "tableName")的方式进行指定表名<p>
 * 					<p>3.字段默认和@Column一样,都会作为表字段,表字段默认为Java对象的Field名字驼峰转下划线形式<p>
 * 					<p>4.可以使用@Column(name = "fieldName")指定不符合第3条规则的字段名<p>
 * 					<p>5.使用@Transient注解可以忽略字段,添加该注解的字段不会作为表字段使用<p>
 * 					<p>6.建议一定是有一个@Id注解作为主键的字段,可以有多个@Id注解的字段作为联合主键<p>
 * 					<p>7.如果是MySQL的自增字段,加上@GeneratedValue(generator = "JDBC")即可.如果是其他数据库,可以参考官网文档<p>
 * @param <T>
 */
public class IBatisTParam<T> {
	private T entity; //传入的参数
	
	private Integer page; //目前是第几页
	private Integer size; //每页记录数
	private String tableName;//数据库表名
	private Map<String, Object> paramMap;//作为条件的参数
	private Map<String, Object> PKMap;//主键更新时需要的where条件
	private String orderColumn;//排序的列
	private String orderTurn = "ASC";//排序方式(顺序[ASC],倒序[DSC])
	
	//不能有这个无参构造因为需要保证在new IBatisTParam<T>时entity必传
//	public IBatisTParam(){
//		super();
//	}
	//insert,delete,update时的构造函数
	public IBatisTParam(T entity){
		super();
		this.entity = entity;
		this.tableName = this.getTableName();
		this.paramMap = this.getParamMap();
		this.PKMap = this.getPKMap();
	}
	//select不分页查询时构造函数
	public IBatisTParam(T entity, String orderColumn, String orderTurn) {
		super();
		this.entity = entity;
		this.tableName = this.getTableName();
		this.paramMap = this.getParamMap();
		this.PKMap = this.getPKMap();
		this.orderColumn = orderColumn;
		this.orderTurn = BasicUtil.isNull(orderTurn) ? this.orderTurn : orderTurn;
	}
	//select分页查询时的构造函数
	public IBatisTParam(T entity, Integer page, Integer size, String orderColumn, String orderTurn) {
		super();
		this.entity = entity;
		this.page = page;
		this.size = size;
		this.tableName = this.getTableName();
		this.paramMap = this.getParamMap();
		this.PKMap = this.getPKMap();
		this.orderColumn = orderColumn;
		this.orderTurn = BasicUtil.isNull(orderTurn) ? this.orderTurn : orderTurn;
	}
	//国际惯例全参的构造函数
	public IBatisTParam(T entity, Integer page, Integer size, String tableName, Map<String, Object> paramMap, Map<String, Object> pKMap, String orderColumn, String orderTurn) {
		super();
		this.entity = entity;
		this.page = page;
		this.size = size;
		this.tableName = tableName;
		this.paramMap = paramMap;
		this.PKMap = pKMap;
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
		Table annotation = (Table) BasicReflection.getClassAnnotationByReflectObjectAnnotationClass(this.entity, clazz);
		String ClassName = this.entity.getClass().getSimpleName();
		if(BasicUtil.isNotNull(annotation)){//Table注解不为空且name属性有值时取其值
			tableName = annotation.name();
		}else {//否则按照驼峰命名规则将类名转成表明,如 UserInfo----->user_info
			tableName = BasicUtil.presentHumpNamedToUnderScoreString(ClassName, false);
		}
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Map<String, Object> getParamMap() {
		paramMap = BasicReflection.getMapByReflectWithOutNullObject(this.entity);
		return paramMap;
	}
	public void setParamMap(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}
	public Map<String, Object> getPKMap() {
		PKMap = BasicReflection.getMapByReflectAttributeAnnotationClassObejct(this.entity, Id.class);
		if(BasicUtil.isNull(PKMap)){//如果实体类T中没有定义@Id时
			for (Entry<String, Object> entry : paramMap.entrySet()) {
				PKMap.put(entry.getKey(), entry.getValue());
				break;
			}
		}
		return PKMap;
	}
	public void setPKMap(Map<String, Object> PKMap) {
		this.PKMap = PKMap;
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