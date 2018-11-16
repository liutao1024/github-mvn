package cn.spring.mvn.basic.ibatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Example;
import cn.spring.mvn.basic.tools.BasicReflection;
import cn.spring.mvn.basic.util.BasicUtil;

public class IBatisServiceImpl<T> implements IBatisService<T>{
	@Autowired
	private IBatisDao<T> iBatisDao;
	
	/********************************增********************************/
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: SQL语句插入实体类T记录
	 * @Title: insertEntity 
	 * @param t 实体类
	 * @return 
	 */
	@Override
	public Integer insertEntity(T t) {
		String insertSQL = BasicReflection.getSQLStringByReflectForIBatis(t, BasicReflection.INSERT);
		return iBatisDao.insertBySQL(insertSQL);
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: SQL语句插入实体类T的List记录
	 * @Title: insertEntities
	 * @param ts 实体类的List
	 * @return 
	 */
	@Override
	public Integer insertEntities(List<T> ts) {
		Integer rst = 0;
		for (T t : ts) {
			rst +=  this.insertEntity(t);
		}
		return rst;
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: IBatis根据IBatisTParam类按配置插入实体类T记录
	 * @Title: insertEntityByCondition
	 * @param iBatisParam IBatisTParam
	 * @return 
	 */
	@Override
	public Integer insertEntityByCondition(IBatisTParam<T> iBatisParam) {
		return iBatisDao.insertByCondition(iBatisParam);
	}
	/********************************删********************************/
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: SQL语句删除实体类T记录
	 * @Title: deleteEntity
	 * @param t 实体类
	 * @return 
	 */
	@Override
	public Integer deleteEntity(T t) {
		String deletSQL = BasicReflection.getSQLStringByReflectForIBatis(t, BasicReflection.DELETE);
		return iBatisDao.deleteBySQL(deletSQL);
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: SQL语句删除实体类T的List记录
	 * @Title: deleteEntities
	 * @param ts 实体类List
	 * @return 
	 */
	@Override
	public Integer deleteEntities(List<T> ts) {
		Integer rst = 0;
		for (T t : ts) {
			rst +=  this.deleteEntity(t);
		}
		return rst;
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: IBatis根据IBatisTParam类按配置删除实体类T记录
	 * @Title: deleteEntityByCondition
	 * @param iBatisParam IBatisTParam
	 * @return 
	 */
	@Override
	public Integer deleteEntityByCondition(IBatisTParam<T> iBatisParam) {
		return iBatisDao.deleteByCondition(iBatisParam);
	}
	/********************************改********************************/
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: SQL语句更新实体T
	 * @Title: updateEntity
	 * @param t 实体类
	 * @return 
	 */
	@Override
	public Integer updateEntity(T t) {
		String updateSQL = BasicReflection.getSQLStringByReflectForIBatis(t, BasicReflection.UPDATE);
		return iBatisDao.updateBySQL(updateSQL);
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: SQL语句更新实体类T的List
	 * @Title: updateEntities 
	 * @param ts 实体类的List
	 * @return 
	 */
	@Override
	public Integer updateEntities(List<T> ts) {
		Integer rst = 0;
		for (T t : ts) {
			rst +=  this.updateEntity(t);
		}
		return rst;
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: IBatis根据IBatisTParam类按配置更新实体类T
	 * @Title: updateEntityByCondition
	 * @param iBatisParam IBatisTParam
	 * @return 
	 */
	@Override
	public Integer updateEntityByCondition(IBatisTParam<T> iBatisParam) {
		//保障iBatisParam中PKMap中有值
		Map<String, Object> PKMap = iBatisParam.getPKMap();
		if(BasicUtil.isNull(PKMap)){
			iBatisParam = new IBatisTParam<T>(iBatisParam.getEntity(), iBatisParam.getPage(), iBatisParam.getSize(), iBatisParam.getOrderColumn(), iBatisParam.getOrderTurn());
		}
		
		return iBatisDao.updateByCondition(iBatisParam);
	}
	/********************************查********************************/
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: SQL语句查询一条实体类T记录
	 * @Title: selectOneEntity
	 * @param t 实体类
	 * @return 
	 */
	@Override
	public T selectOneEntity(T t) {
		List<T> list = this.selectEntities(t);
		if(list.size() > 0){
			return list.get(0);
		}else {
			return null;
		}
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: SQL语句查询实体类T的List
	 * @Title: selectEntities
	 * @param t 实体类
	 * @return 
	 */
	@Override
	public List<T> selectEntities(T t) {
		Class<?> clazz = t.getClass();
		String selectSQL = BasicReflection.getSQLStringByReflectForIBatis(t, BasicReflection.SELECT);
		List<Map<String, Object>> daoResult = iBatisDao.selectBySQL(selectSQL);
		List<T> result = BasicReflection.getObjectListByReflectClassAndMapList(clazz, daoResult);
		return result;
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: SQL语句查询实体类T的记录数
	 * @Title: selectEntitiesCount
	 * @param t 实体类
	 * @return 
	 */
	@Override
	public Long selectEntitiesCount(T t) {
		String countSQL = BasicReflection.getSQLStringByReflectForIBatis(t, BasicReflection.SCOUNT);
		return iBatisDao.selectCountBySQL(countSQL);
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: SQL语句查询实体类T记录数
	 * @Title: selectEntitiesWithCount
	 * @param t 实体类
	 * @return IBatisTResult
	 */
	@Override
	public IBatisTResult<T> selectEntitiesWithCount(T t) {
		List<T> resultList = this.selectEntities(t);
		IBatisTResult<T> ibatisResult = new IBatisTResult<T>(resultList);
		return ibatisResult;
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: SQL语句查询实体类T记录并根据page和size分页返回
	 * @Title: selectPageEntitiesWithCount
	 * @param t 实体类
	 * @param page 当前页数
	 * @param size 每页记录数
	 * @return 
	 */
	@Override
	public IBatisTResult<T> selectPageEntitiesWithCount(T t, Integer page, Integer size) {
		List<T> resultList = this.selectEntities(t);
		IBatisTResult<T> ibatisResult = new IBatisTResult<T>(page, size, resultList);
		return ibatisResult;
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: IBatis根据IBatisTParam类按配置查询实体类T
	 * @Title: selectEntitiesWithCountByCondition
	 * @param iBatisParam IBatisTParam
	 * @return 
	 */
	@Override
	public IBatisTResult<T> selectEntitiesWithCountByCondition(IBatisTParam<T> iBatisParam) {
		T t = iBatisParam.getEntity();
		List<Map<String, Object>> daoResult = iBatisDao.selectByCondition(iBatisParam);
		List<T> resultList = BasicReflection.getObjectListByReflectClassAndMapList(t.getClass(), daoResult);
		IBatisTResult<T> ibatisResult = new IBatisTResult<T>(resultList);
		return ibatisResult;
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: IBatis根据IBatisTParam类按配置查询实体类T
	 * @Title: selectPageEntitiesWithCountByCondition
	 * @param iBatisParam IBatisTParam
	 * @return 
	 */
	@Override
	public IBatisTResult<T> selectPageEntitiesWithCountByCondition(IBatisTParam<T> iBatisParam) {//需要修改因为他是Page的...
		T t = iBatisParam.getEntity();
		List<Map<String, Object>> daoResult = iBatisDao.selectByCondition(iBatisParam);
		List<T> resultList = BasicReflection.getObjectListByReflectClassAndMapList(t.getClass(), daoResult);
		IBatisTResult<T> ibatisResult = new IBatisTResult<T>(resultList);
		return ibatisResult;
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: IBatis根据IBatisTParam类按TK查询实体类T
	 * 				当t有Date类型的属性时会出现问题
	 * @Title: selectEntitiesWithCountByTK
	 * @param iBatisParam IBatisTParam
	 * @return 
	 */
	@Override
	public IBatisTResult<T> selectEntitiesWithCountByTK(IBatisTParam<T> iBatisParam){//不用考虑分页
		T t = iBatisParam.getEntity();
		Example example = new Example(t.getClass());
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo(t);//当t有Date类型的属性时会出现问题Criteria中将时间按最长的类型进行转的
		List<T> resultList = new ArrayList<T>();//这个还可以用如下三种方式获取
		resultList = iBatisDao.selectByExample(example);
		IBatisTResult<T> ibatisResult = new IBatisTResult<T>(resultList);
		return ibatisResult;
	}
	/**
	 * @Author LiuTao @Date 2018年11月14日 下午3:53:28
	 * @Description: IBatis根据IBatisTParam类按TK+PageHelper查询实体类T
	 * @Title: selectPageEntitiesWithCountByTK
	 * @param iBatisParam IBatisTParam
	 * @return 
	 */
	@Override
	public IBatisTResult<T> selectPageEntitiesWithCountByTK(IBatisTParam<T> iBatisParam) {//分页的
		T t = iBatisParam.getEntity();
		Integer page = iBatisParam.getPage();
		Integer size = iBatisParam.getSize();
		String orderColumn = iBatisParam.getOrderColumn();
		String orderTurn = iBatisParam.getOrderTurn();
		RowBounds rowBounds = new RowBounds(page * size, size);
		Example example = new Example(t.getClass());
		if(BasicUtil.isNotNull(orderColumn)){
			example.setOrderByClause(orderColumn + " " +orderTurn);
		}
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo(t);
		List<T> resultList = new ArrayList<T>();//这个还可以用如下三种方式获取
		resultList = iBatisDao.selectByExampleAndRowBounds(example, rowBounds);
		IBatisTResult<T> ibatisResult = new IBatisTResult<T>(resultList);
		ibatisResult.setCount((long) iBatisDao.selectByExample(example).size());
		return ibatisResult;
	}
	
	@Override
	public List<T> selectEntitiesByTK(T t){
		return iBatisDao.select(t);
	}
	@Override
	public List<T> selectEntitiesByTKExample(T t) {
		Example example = new Example(t.getClass());
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo(t);
		return iBatisDao.selectByExample(example);
	}
	@Override
	public List<T> selectEntitiesByTKExampleCriteria(Example example){
		return iBatisDao.selectByExample(example);
	}
	@Override
	public List<T> selectEntitiesByTKRowBounds(T t, Integer page, Integer size) {
		RowBounds rowBounds = new RowBounds(page * size, size);
		return iBatisDao.selectByRowBounds(t, rowBounds);
	}
	@Override
	public List<T> selectEntitiesByTKExampleRowBounds(T t, Integer page, Integer size) {
		Example example = new Example(t.getClass());
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo(t);
		RowBounds rowBounds = new RowBounds(page * size, size);
		return iBatisDao.selectByExampleAndRowBounds(example, rowBounds);
	}
}
