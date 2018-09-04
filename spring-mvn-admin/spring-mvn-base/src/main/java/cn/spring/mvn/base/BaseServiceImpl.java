package cn.spring.mvn.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.dialect.Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.spring.mvn.base.util.BaseUtil;
import cn.spring.mvn.base.util.BaseUtilHqlFilter;



@Service
@Repository("CommService")
@SuppressWarnings({"unchecked", "rawtypes"})
public class BaseServiceImpl<T> implements BaseService<T>{
	/**
	 * 实体类.class
	 */
	protected Class<T> entityClass;
	/**
	 * 实体类名称
	 */
	protected String entityClassName;
	/**
	 * 数据库方言
	 */
	private Dialect dialect;
	private Boolean booleanOne;
	private Boolean booleanTwo;
	private Boolean booleanThree;
	private Boolean booleanFour;
	
	@Autowired
	private BaseDao<T> commDaoImpl;
	/**
	 * <p>Title: </p> 
	 * <p>Description: 构造函数</p>
	 */
	public BaseServiceImpl() {
		this.entityClass = (Class<T>) getSuperClassGenricType(getClass(), 0);
		this.entityClassName = this.entityClass.getSimpleName();
	}
	
	
	@Override
	public Dialect getDialect() {
		return this.commDaoImpl.getDialect();
	}
	@Override
	public boolean isMySQL() {
		if (this.booleanOne == null) {
			if (this.dialect == null) {
				this.dialect = getDialect();
			}
			if (this.dialect != null) {
				String str = this.dialect.toString();
				this.booleanOne = Boolean.valueOf(StringUtils.containsIgnoreCase(str, "MySQL"));
			}
		}
		return this.booleanOne != null ? this.booleanOne.booleanValue() : false;
	}
	@Override
	public boolean isPostgreSQL() {
		if (this.booleanTwo == null) {
			if (this.dialect == null) {
				this.dialect = getDialect();
			}
			if (this.dialect != null) {
				String str = this.dialect.toString();
				this.booleanTwo = Boolean.valueOf(StringUtils.containsIgnoreCase(str, "PostgreSQL"));
			}
		}
		return this.booleanTwo != null ? this.booleanTwo.booleanValue() : false;
	}
	@Override
	public boolean isOracle() {
		if (this.booleanThree == null) {
			if (this.dialect == null) {
				this.dialect = getDialect();
			}
			if (this.dialect != null) {
				String str = this.dialect.toString();
				this.booleanThree = Boolean.valueOf(StringUtils.containsIgnoreCase(str, "Oracle"));
			}
		}
		return this.booleanThree != null ? this.booleanThree.booleanValue() : false;
	}
	@Override
	public boolean isSQLServer() {
		if (this.booleanFour == null) {
			if (this.dialect == null) {
				this.dialect = getDialect();
			}
			if (this.dialect != null) {
				String str = this.dialect.toString();
				this.booleanFour = Boolean.valueOf(StringUtils.containsIgnoreCase(str, "SQLServer"));
			}
		}
		return this.booleanFour != null ? this.booleanFour.booleanValue() : false;
	}
	//
	@Override
	public T saveEntity(T entity) throws Exception {
		return commDaoImpl.saveEntity(entity);
	}
	@Override
	public List<T> saveEntities(List<T> entities) throws Exception {
		return commDaoImpl.saveEntities(entities);
	}
	@Override
	public void saveOrUpdate(T entity) {
		this.commDaoImpl.saveOrUpdate(entity);
	}
	@Override
	public void deleteEntity(T entity) {
		commDaoImpl.deleteEntity(entity);
	}
	@Override
	public void deleteEntities(List<T> entities) {
		commDaoImpl.deleteEntities(entities);
	}
	@Override
	public T selectOneEntity(T entity) {
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BaseUtil.getParamMapWithOutNullValueByReflectObject(entity);
		String hqlStr = BaseUtil.getSqlStrByEntityNameAndParamMap(entityName, paramMap);
		return commDaoImpl.findOneByHqlParamMap(hqlStr, paramMap);
	}
	@Override
	public List<T> selectAllEntities(T entity) {
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BaseUtil.getParamMapWithOutNullValueByReflectObject(entity);
		String hqlStr = BaseUtil.getSqlStrByEntityNameAndParamMap(entityName, paramMap);
		return commDaoImpl.findAllByHqlParamMap(hqlStr, paramMap);
	}
	@Override
	public List<T> selectAllEntitiesWihtPageSize(T entity, int page, int size) {
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BaseUtil.getParamMapWithOutNullValueByReflectObject(entity);
		String hqlStr = BaseUtil.getSqlStrByEntityNameAndParamMap(entityName, paramMap);
		return commDaoImpl.findAllByHqlParamMapPageSize(hqlStr, paramMap, page, size);
	}
	@Override
	public void updateEntity(T entity) {
		commDaoImpl.updateEntity(entity);
	}
	@Override
	public void updateEntities(List<T> entities) {
		commDaoImpl.updateEntities(entities);
	}

	
	@Override
	public List<T> findByFilter(BaseUtilHqlFilter hqlFilter) {
		String str1 = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getName();
		String str2 = "select distinct t from " + str1 + " t";
		return commDaoImpl.findAllByHqlParamMap(str2 + hqlFilter.getWhereAndOrderHql(), hqlFilter.getParams());
	}
	@Override
	public List<T> findByFilter(BaseUtilHqlFilter hqlFilter, int page, int size) {
		String str1 = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getName();
		String str2 = "select distinct t from " + str1 + " t";
		return commDaoImpl.findAllByHqlParamMapPageSize(str2 + hqlFilter.getWhereAndOrderHql(), hqlFilter.getParams(), page, size);
	}
	
	@Override
	public long countByFilter() {
		return countByFilter(new BaseUtilHqlFilter());
	}
	@Override
	public void commit() {
		this.commDaoImpl.commit();
	}
	@Override
	public void rollback() {
		this.commDaoImpl.rollback();
	}

	

	@Override
	public long count(T entity) {
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BaseUtil.getParamMapWithOutNullValueByReflectObject(entity);
		String hqlStr = BaseUtil.getSqlStrByEntityNameAndParamMap(entityName, paramMap);
		return commDaoImpl.countByHqlParamMap(hqlStr, paramMap);
	}

	@Override
	public long countByFilter(BaseUtilHqlFilter paramHqlFilter) {
		return 0;
	}
	
	@Override
	public List<T> findAllByHql(String hqlStr) {
		return commDaoImpl.findAllByHql(hqlStr);
	}
	@Override
	public T findOneByHql(String hqlStr) {
		return commDaoImpl.findOneByHql(hqlStr);
	}


	@Override
	public List<T> findAllBySql(String sqlStr) {
		return (List<T>) commDaoImpl.findAllBySql(sqlStr);
	}
	/**
	 * @author LiuTao 
	 */
	@Override
	public T findOneBySql(String sqlStr) {
		return commDaoImpl.findOneBySql(sqlStr);
	}
	
	@Override
	public List<T> findAll(T entity){
		String hqlStr = "from " + entity.getClass().getSimpleName() ;
		return commDaoImpl.findAllByHql(hqlStr);
	}
	
	@Override
	public List<T> findAllByEntity(T entity){
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BaseUtil.getParamMapWithOutNullValueByReflectObject(entity);
		String hqlStr = BaseUtil.getSqlStrByEntityNameAndParamMap(entityName, paramMap);
		return commDaoImpl.findAllByHqlParamMap(hqlStr, paramMap);
	}
	
	/**
	 * @author LiuTao @date 2018年5月30日 下午2:38:22 
	 * @Title: getSuperClassGenricType 
	 * @Description: 
	 * @param clazz
	 * @param index
	 * @return
	 */
	public static Class<Object> getSuperClassGenricType(Class clazz, int index) {
		Type localType = clazz.getGenericSuperclass();
		if (!(localType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] arrayOfType = ((ParameterizedType) localType).getActualTypeArguments();
		if ((index >= arrayOfType.length) || (index < 0)) {
			return Object.class;
		}
		if (!(arrayOfType[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) arrayOfType[index];
	}


	@Override
	public List<T> findAllByEntityPageSize(T entity, int page, int size) {
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BaseUtil.getParamMapWithOutNullValueByReflectObject(entity);
		String hqlStr = BaseUtil.getSqlStrByEntityNameAndParamMap(entityName, paramMap);
		return commDaoImpl.findAllByHqlParamMapPageSize(hqlStr, paramMap, page, size);
	}


	@Override
	public List<T> findAllByHqlPageSize(String hqlStr, int page, int size) {
		List<T> list = commDaoImpl.findAllByHqlPageSize(hqlStr, page, size);
		return list;
	}


	@Override
	public List<T> findAllBySqlPageSize(String sqlStr, int page, int size) {
		return (List<T>) commDaoImpl.findAllBySqlPageSize(sqlStr, page, size);
	}
	
	@Override
	public Map<String, Object> findAllByEntityPageSizeWithCount(T entity, int page, int size) {
		Map<String, Object> rstMap = new HashMap<String, Object>();
		List<T> list = findAllByEntityPageSize(entity, page, size);
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BaseUtil.getParamMapWithOutNullValueByReflectObject(entity);
		String hqlStr = BaseUtil.getHqlByEntityNameAndParamMap(entityName, paramMap);
		long count = findAllByHql(hqlStr).size();
		rstMap.put("count", count);
		rstMap.put("result", list);
		rstMap.put("page", page);
		rstMap.put("size", size);
		return rstMap;
	}

	@Override
	public Map<String, Object> findAllByHqlPageSizeWithCount(String hqlStr, int page, int size) {
		Map<String, Object> rstMap = new HashMap<String, Object>();
		List<T> list = findAllByHqlPageSize(hqlStr, page, size);
		long count = findAllByHql(hqlStr).size();
		rstMap.put("count", count);
		rstMap.put("result", list);
		rstMap.put("page", page);
		rstMap.put("size", size);
		return rstMap;
	}

}
