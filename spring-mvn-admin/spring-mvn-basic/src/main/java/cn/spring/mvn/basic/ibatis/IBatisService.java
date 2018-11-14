package cn.spring.mvn.basic.ibatis;

import java.util.List;

public interface IBatisService<T> {
	//增
	Integer insertEntity(T t);
	Integer insertEntities(List<T> ts);
	Integer insertEntityByCondition(IBatisTParam<T> iBatisParam);
	//删
	Integer deleteEntity(T t);
	Integer deleteEntities(List<T> ts);
	Integer deleteEntityByCondition(IBatisTParam<T> iBatisParam);
	//查
	T selectOneEntity(T t);
	List<T> selectEntities(T t);
	Long selectEntitiesCount(T t);
	IBatisTResult<T> selectEntitiesWithCount(T t);
	IBatisTResult<T> selectPageEntitiesWithCount(T t, Integer page, Integer size);
	IBatisTResult<T> selectEntitiesWithCountByCondition(IBatisTParam<T> iBatisParam);
	IBatisTResult<T> selectPageEntitiesWithCountByCondition(IBatisTParam<T> iBatisParam);
	IBatisTResult<T> selectEntitiesWithCountByTK(IBatisTParam<T> iBatisParam);
	IBatisTResult<T> selectPageEntitiesWithCountByTKAndPageHelper(IBatisTParam<T> iBatisParam);
	//改
	Integer updateEntity(T t);
	Integer updateEntities(List<T> ts);
	Integer updateEntityByCondition(IBatisTParam<T> iBatisParam);
	
}
