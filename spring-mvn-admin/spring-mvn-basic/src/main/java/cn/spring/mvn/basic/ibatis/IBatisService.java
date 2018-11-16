package cn.spring.mvn.basic.ibatis;

import java.util.List;

import tk.mybatis.mapper.entity.Example;

public interface IBatisService<T> {
	//增
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:10:49 
	 * @Title: insertEntity 
	 * @Description: SQL语句插入实体类T记录
	 * @param t
	 * @return
	 */
	Integer insertEntity(T t);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:10:40 
	 * @Title: insertEntities 
	 * @Description: SQL语句插入实体类T的List记录
	 * @param ts
	 * @return
	 */
	Integer insertEntities(List<T> ts);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:10:57 
	 * @Title: insertEntityByCondition 
	 * @Description: IBatis根据IBatisTParam类按配置插入实体类T记录 
	 * @param iBatisParam
	 * @return
	 */
	Integer insertEntityByCondition(IBatisTParam<T> iBatisParam);
	//删
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:01 
	 * @Title: deleteEntity 
	 * @Description:  SQL语句删除实体类T记录
	 * @param t
	 * @return
	 */
	Integer deleteEntity(T t);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:04 
	 * @Title: deleteEntities 
	 * @Description: SQL语句删除实体类T的List记录
	 * @param ts
	 * @return
	 */
	Integer deleteEntities(List<T> ts);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:08 
	 * @Title: deleteEntityByCondition 
	 * @Description: IBatis根据IBatisTParam类按配置删除实体类T记录
	 * @param iBatisParam
	 * @return
	 */
	Integer deleteEntityByCondition(IBatisTParam<T> iBatisParam);
	//改
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:52 
	 * @Title: updateEntity 
	 * @Description: SQL语句更新实体T 
	 * @param t
	 * @return
	 */
	Integer updateEntity(T t);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:55 
	 * @Title: updateEntities 
	 * @Description: SQL语句更新实体类T的List
	 * @param ts
	 * @return
	 */
	Integer updateEntities(List<T> ts);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:58 
	 * @Title: updateEntityByCondition 
	 * @Description: IBatis根据IBatisTParam类按配置更新实体类T
	 * @param iBatisParam
	 * @return
	 */
	Integer updateEntityByCondition(IBatisTParam<T> iBatisParam);
	//查
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:12 
	 * @Title: selectOneEntity 
	 * @Description: TSQL语句查询一条实体类T记录
	 * @param t
	 * @return
	 */
	T selectOneEntity(T t);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:17 
	 * @Title: selectEntities 
	 * @Description: SQL语句查询实体类T的List
	 * @param t
	 * @return
	 */
	List<T> selectEntities(T t);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:20 
	 * @Title: selectEntitiesCount 
	 * @Description: SQL语句查询实体类T的记录数
	 * @param t
	 * @return
	 */
	Long selectEntitiesCount(T t);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:26 
	 * @Title: selectEntitiesWithCount 
	 * @Description: SQL语句查询实体类T记录数 
	 * @param t
	 * @return
	 */
	IBatisTResult<T> selectEntitiesWithCount(T t);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:30 
	 * @Title: selectPageEntitiesWithCount 
	 * @Description: SQL语句查询实体类T记录并根据page和size分页返回
	 * @param t
	 * @param page
	 * @param size
	 * @return
	 */
	IBatisTResult<T> selectPageEntitiesWithCount(T t, Integer page, Integer size);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:36 
	 * @Title: selectEntitiesWithCountByCondition 
	 * @Description:  IBatis根据IBatisTParam类按配置查询实体类T 
	 * @param iBatisParam
	 * @return
	 */
	IBatisTResult<T> selectEntitiesWithCountByCondition(IBatisTParam<T> iBatisParam);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:40 
	 * @Title: selectPageEntitiesWithCountByCondition 
	 * @Description: IBatis根据IBatisTParam类按配置查询实体类T
	 * @param iBatisParam
	 * @return
	 */
	IBatisTResult<T> selectPageEntitiesWithCountByCondition(IBatisTParam<T> iBatisParam);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:44 
	 * @Title: selectEntitiesWithCountByTK 
	 * @Description: IBatis根据IBatisTParam类按TK查询实体类T
	 * @param iBatisParam
	 * @return
	 */
	IBatisTResult<T> selectEntitiesWithCountByTK(IBatisTParam<T> iBatisParam);
	/**
	 * @Author LiuTao @Date 2018年11月15日 上午9:11:48 
	 * @Title: selectPageEntitiesWithCountByTKAndPageHelper 
	 * @Description: IBatis根据IBatisTParam类按TK+PageHelper查询实体类T 
	 * @param iBatisParam
	 * @return
	 */
	IBatisTResult<T> selectPageEntitiesWithCountByTK(IBatisTParam<T> iBatisParam);
	
	List<T> selectEntitiesByTK(T t);
	List<T> selectEntitiesByTKExample(T t);
	List<T> selectEntitiesByTKExampleCriteria(Example example);
	List<T> selectEntitiesByTKRowBounds(T t, Integer page, Integer size);
	List<T> selectEntitiesByTKExampleRowBounds(T t, Integer page, Integer size);
	
}
