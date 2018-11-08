package cn.spring.mvn.basic.ibatis;

import java.util.List;

/**
 * @author LiuTao @date 2018年11月8日 下午1:37:05
 * @ClassName: IBatisDao 
 * @Description: TODO(Describe) 
 * @param <T>
 */
public interface IBatisDao<T> {
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:05:45 
	 * @Title: insertEntity 
	 * @Description: TODO(插入一条记录) 
	 * @param t
	 * @return
	 */
	int insertEntity(T t);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:05:50 
	 * @Title: insertEntities 
	 * @Description: TODO(批量插入记录) 
	 * @param list
	 * @return
	 */
	int insertEntities(List<T> list);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:05:54 
	 * @Title: updateEntity 
	 * @Description: TODO(更新一条记录) 
	 * @param t
	 * @return
	 */
	int updateEntity(T t);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:06:24 
	 * @Title: updateEntities 
	 * @Description: TODO(批量更新记录) 
	 * @param list
	 * @return
	 */
	int updateEntities(List<T> list);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:06:28 
	 * @Title: selectEntity 
	 * @Description: TODO(查询一条记录) 
	 * @param t
	 * @return
	 */
	T selectEntity(T t);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:06:33 
	 * @Title: selectEntities 
	 * @Description: TODO(查询list记录) 
	 * @param t
	 * @return
	 */
	List<T> selectEntities(T t);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:06:37 
	 * @Title: selectEntitiesCount 
	 * @Description: TODO(查询记录数) 
	 * @param t
	 * @return
	 */
	int selectEntitiesCount(T t);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:06:41 
	 * @Title: selectEntitiesWithCount 
	 * @Description: TODO(查询记录并返回记录数) 
	 * @param BPEntity
	 * @return
	 */
	IBatisPageResult<T> selectEntitiesWithCount(IBatisPageEntity<T> BPEntity);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:10:19 
	 * @Title: selectPageEntitiesWithCount 
	 * @Description: TODO(分页查询记录并返回记录数) 
	 * @param BPEntity
	 * @return
	 */
	IBatisPageResult<T> selectPageEntitiesWithCount(IBatisPageEntity<T> BPEntity);
}
