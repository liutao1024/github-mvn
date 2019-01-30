package cn.spring.mvn.basic.hibernat;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Order;
/**
 * @Author LiuTao @Date 2019年1月30日 上午11:04:33
 * @ClassName: HibernatOrder
 * @Description: Hibernate排序使用的工具类-针对中文排序
 */
public class HibernatOrder extends Order {
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 5571348706914497131L;
	private String propertyName;
	
	protected HibernatOrder(String propertyName, boolean ascending) {
		super(propertyName, ascending);//
		this.propertyName = propertyName;// TODO Auto-generated constructor stub
	}
	protected HibernatOrder(String propertyName) {
		super(propertyName, false);//降序
		this.propertyName = propertyName;// TODO Auto-generated constructor stub
	}
	/**
	 * 只考虑按一个字段排序的情况
	 */
	public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
		String[] columns = criteriaQuery.getColumnsUsingProjection(criteria, propertyName);
		return " convert (" + columns[0] + " using gbk) asc ";
	}
	public static HibernatOrder getOrder(String propertyName) {
//		Order a = new Order
		return new HibernatOrder(propertyName);
	}
}
