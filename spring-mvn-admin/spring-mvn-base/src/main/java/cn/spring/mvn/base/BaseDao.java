package cn.spring.mvn.base;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.dialect.Dialect;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
/**
 * @author LiuTao @date 2018年5月24日 下午5:31:46
 * @ClassName: CommDao 
 * @Description: TODO(Dao类最基础的增删查改) 
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public abstract interface BaseDao<T> {
	
	public abstract Dialect getDialect();//获取数据库方言

	public abstract T save(T entity) throws Exception;//保存单个实体
	public abstract void saveOrUpdate(T entity);//单个实体保存或更新
	public abstract T saveEntity (T entity) throws Exception;//单个实体保存
	public abstract List<T> saveEntities (List<T> entities) throws Exception;//保存多个实体
	public abstract void update(T entity);
	public abstract void updateEntity (T entity);//单个实体更新
	public abstract void updateEntities (List<T> entities);//列表更新
	public abstract void delete(T entity);//删除
	public abstract void deleteEntity(T entity);//删除单个实体
	public abstract void deleteEntities(List<T> entities);

	public abstract T get(Class<T> theClass, Serializable id);
	public abstract T load(Class<T> theClass, Serializable id);
	
	public abstract T findOneByHql(String hqlStr);
	public abstract T findOneByHqlParamMap(String hqlStr, Map<String, Object> paramMap);
	public abstract List<T> findAllByHql(String hqlStr);
	public abstract List<T> findAllByHqlPageSize(String hqlStr, int page, int size);
	public abstract List<T> findAllByHqlParamMap(String hqlStr, Map<String, Object> paramMap);
	public abstract List<T> findAllByHqlParamMapPageSize(String hqlStr, Map<String, Object> paramMap, int page, int size);
	public abstract T findOneBySql(String sqlStr);
	public abstract T findOneBySqlParamMap(String sqlStr, Map<String, Object> paramMap);
	public abstract List<Map> findAllBySql(String sqlStr);
	public abstract List<Map> findAllBySqlPageSize(String sqlStr, int page, int size);
	public abstract List<Map> findAllBySqlParamMap(String sqlStr, Map<String, Object> paramMap);
	public abstract List<Map> findAllBySqlParamMapPageSize(String sqlStr, Map<String, Object> paramMap, int page, int size);
	public abstract List<Map> findAllBySqlParamMapColumnsCharCase(String sqlStr, Map<String, Object> paramMap, List<String> columns, int charCase);
	public abstract List<Map> findAllBySqlParamMapColumnsCharCasePageSize(String sqlStr, Map<String, Object> paramMap, List<String> columns, int charCase, int page, int size);
	public abstract int executeBySql(String sqlStr);
	public abstract int executeBySqlParamMap(String sqlStr, Map<String, Object> paramMap);
	public abstract int executeByHql(String hqlStr);
	public abstract int executeByHqlParamMap(String hqlStr, Map<String, Object> paramMap);
	
	
	public abstract long countByHql(String hqlStr);
	public abstract long countByHqlParamMap(String hqlStr, Map<String, Object> paramMap);
	public abstract BigInteger countBySql(String sqlStr);
	public abstract BigInteger countBySqlParamMap(String sqlStr, Map<String, Object> paramMap);
	
	public abstract void commit();
	public abstract void rollback();
	
	public abstract void doWork(Work work);
	public abstract <R> R doReturningWork(ReturningWork<R> returningWork);

	public abstract void flush();
	public abstract void evict(T entity);

	public abstract void merge(T entity);
	public abstract void clearSession();
	
}
