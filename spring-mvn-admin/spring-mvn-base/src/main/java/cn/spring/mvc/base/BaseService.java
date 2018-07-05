package cn.spring.mvc.base;

import java.util.List;
import java.util.Map;

import org.hibernate.dialect.Dialect;

import cn.spring.mvc.base.util.BaseUtilHqlFilter;

/**
 * @author LiuTao @date 2018年5月24日 下午5:32:32
 * @ClassName: CommService 
 * @Description: TODO(Service类最基础的增删查改) 
 * @param <T>
 */
public interface BaseService<T> {
	//系统级接口
	public abstract Dialect getDialect();
	public abstract boolean isMySQL();
	public abstract boolean isPostgreSQL();
	public abstract boolean isOracle();
	public abstract boolean isSQLServer();

	//数据级接口
	public abstract T saveEntity (T entity) throws Throwable;
	public abstract List<T> saveEntities (List<T> entities) throws Throwable;
	public abstract void saveOrUpdate(T entity);
	public abstract void deleteEntity(T entity);
	public abstract void deleteEntities(List<T> entities);
	public abstract T selectOneEntity(T entity);
	public abstract List<T> selectAllEntities(T entity);
	public abstract List<T> selectAllEntitiesWihtPageSize(T entity, int page, int size);
	public abstract void updateEntity (T entity);
	public abstract void updateEntities (List<T> entities);
	public abstract long count(T entity);
	
	public abstract List<T> findByFilter(BaseUtilHqlFilter paramHqlFilter);
	@Deprecated
	public abstract List<T> findByFilter(BaseUtilHqlFilter paramHqlFilter, int paramInt1, int paramInt2);

	public abstract long countByFilter();
	public abstract long countByFilter(BaseUtilHqlFilter paramHqlFilter);
	
	public abstract void commit();
	public abstract void rollback();
	
	
	/**
	 * @author LiuTao @date 2018年5月30日 下午4:21:05 
	 * @Title: findAllByHql 
	 * @Description: 当实例Entity的变量有默认值时使用 
	 * @param hqlStr
	 * @return
	 */
	public abstract List<T> findAllByHql(String hqlStr);
	/**
	 * @author LiuTao @date 2018年5月30日 下午4:21:11 
	 * @Title: findAllBySql 
	 * @Description:  当实例Entity的变量有默认值时使用
	 * @param sqlStr
	 * @return
	 */
	public abstract List<T> findAllBySql(String sqlStr);

	/**
	 * @author LiuTao @date 2018年5月30日 下午6:06:14 
	 * @Title: findAllByEntity
	 * @Description: TODO(Describe) 
	 * @param entity
	 * @return
	 */
	public abstract List<T> findAll(T entity);
	
	public abstract List<T> findAllByEntityPageSize(T entity, int page, int size);
	public abstract List<T> findAllByHqlPageSize(String hqlStr, int page, int size);
	public abstract List<T> findAllBySqlPageSize(String sqlStr, int page, int size);
	public abstract Map<String, Object> findAllByEntityPageSizeWithCount(T entity, int page, int size);
	public abstract Map<String, Object> findAllByHqlPageSizeWithCount(String hqlStr, int page, int size);
}
