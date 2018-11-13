package cn.spring.mvn.basic.ibatis;

import java.util.List;

public interface IBatisService<T> {
	Integer insertEntity(T t);
	Integer insertEntities(List<T> ts);
	Integer deleteEntity(T t);
	Integer deleteEntities(List<T> ts);
	T selectOneEntity(T t);
	List<T> selectEntities(T t);
	Long selectEntitiesCount(T t);
	IBatisTResult<T> selectEntitiesWithCount(T t);
	IBatisTResult<T> selectPageEntitiesWithCount(T t);
	IBatisTResult<T> selectEntitiesWithCountByCondition(IBatisTParam<T> iBatisParam);
	IBatisTResult<T> selectPageEntitiesWithCountByCondition(IBatisTParam<T> iBatisParam);
	
}
