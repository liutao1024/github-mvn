package cn.spring.mvn.basic.ibatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Example;
import cn.spring.mvn.basic.tools.BasicReflection;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class IBatisServiceImpl<T> implements IBatisService<T>{
	@Autowired
	private IBatisDao<T> iBatisDao;
	
	@Override
	public Integer insertEntity(T t) {
		String insertSQL = BasicReflection.getSQLStringByReflectForIBatis(t, BasicReflection.INSERT);
		return iBatisDao.insertBySQL(insertSQL);
	}
	@Override
	public Integer insertEntities(List<T> ts) {
		Integer rst = 0;
		for (T t : ts) {
			rst +=  this.insertEntity(t);
		}
		return rst;
	}
	@Override
	public Integer deleteEntity(T t) {
		String deletSQL = BasicReflection.getSQLStringByReflectForIBatis(t, BasicReflection.DELETE);
//		iBatisDao.delete(t);
		return iBatisDao.deleteBySQL(deletSQL);
	}
	@Override
	public Integer deleteEntities(List<T> ts) {
		Integer rst = 0;
		for (T t : ts) {
			rst +=  this.deleteEntity(t);
		}
		return rst;
	}
	@Override
	public T selectOneEntity(T t) {
		List<T> list = this.selectEntities(t);
		if(list.size() > 0){
			return list.get(0);
		}else {
			return null;
		}
	}
	@Override
	public List<T> selectEntities(T t) {
		Class<?> clazz = t.getClass();
		String selectSQL = BasicReflection.getSQLStringByReflectForIBatis(t, BasicReflection.SELECT);
		List<Map<String, Object>> daoResult = iBatisDao.selectBySQL(selectSQL);
		List<T> result = BasicReflection.getObjectListByReflectClassAndMapList(clazz, daoResult);
		return result;
	}
	
	@Override
	public Long selectEntitiesCount(T t) {
		String countSQL = BasicReflection.getSQLStringByReflectForIBatis(t, BasicReflection.SCOUNT);
		return iBatisDao.selectCountBySQL(countSQL);
	}
	@Override
	public IBatisTResult<T> selectEntitiesWithCount(T t) {//
		IBatisTParam<T> iBatisParam = new IBatisTParam<T>(t, null, null, null, null);
		return this.selectEntitiesWithCountByCondition(iBatisParam);
	}
	@Override
	public IBatisTResult<T> selectPageEntitiesWithCount(T t, Integer page, Integer size) {
		IBatisTParam<T> iBatisParam = new IBatisTParam<T>(t, page, size, null, null);
		return this.selectPageEntitiesWithCountByCondition(iBatisParam);
	}
	@Override
	public IBatisTResult<T> selectEntitiesWithCountByCondition(IBatisTParam<T> iBatisParam) {//不用考虑分页
		T t = iBatisParam.getEntity();
		List<Map<String, Object>> daoResult = iBatisDao.selectByCondition(iBatisParam);
		List<T> resultList = BasicReflection.getObjectListByReflectClassAndMapList(t.getClass(), daoResult);
		IBatisTResult<T> ibatisResult = new IBatisTResult<T>(resultList);
		return ibatisResult;
	}
	@Override
	public IBatisTResult<T> selectPageEntitiesWithCountByCondition(IBatisTParam<T> iBatisParam) {//需要修改因为他是Page的...
		T t = iBatisParam.getEntity();
		Integer page = iBatisParam.getPage();
		Integer size = iBatisParam.getSize();
		List<Map<String, Object>> daoResult = iBatisDao.selectByCondition(iBatisParam);
		List<T> resultList = BasicReflection.getObjectListByReflectClassAndMapList(t.getClass(), daoResult);
		IBatisTResult<T> ibatisResult = new IBatisTResult<T>(page, size, resultList);
		return ibatisResult;
	}
	@Override
	public IBatisTResult<T> selectEntitiesWithCountByTK(IBatisTParam<T> iBatisParam){//不用考虑分页
		T t = iBatisParam.getEntity();
		Example example = new Example(t.getClass());
		List<T> resultList = new ArrayList<T>();//这个还可以用如下三种方式获取
		resultList = iBatisDao.selectByExample(example);
		PageInfo<T> pageInfo = new PageInfo<T>(resultList);
		IBatisTResult<T> ibatisResult = new IBatisTResult<T>(pageInfo.getTotal(), pageInfo.getList());
		return ibatisResult;
	}
	@Override
	public IBatisTResult<T> selectPageEntitiesWithCountByTKAndPageHelper(IBatisTParam<T> iBatisParam) {//分页的
		T t = iBatisParam.getEntity();
		Integer page = iBatisParam.getPage();
		Integer size = iBatisParam.getSize();
		String orderColumn = iBatisParam.getOrderColumn();
		String orderTurn = iBatisParam.getOrderTurn();
		PageHelper.startPage(page, size);
		RowBounds rowBounds = new RowBounds(page, size);
		Example example = new Example(t.getClass());
		example.setOrderByClause(orderColumn + orderTurn);
		List<T> resultList = new ArrayList<T>();//这个还可以用如下三种方式获取
		resultList = iBatisDao.selectByExample(example);
		resultList = iBatisDao.selectByRowBounds(t, rowBounds);
		resultList = iBatisDao.selectByExampleAndRowBounds(example, rowBounds);
		PageInfo<T> pageInfo = new PageInfo<T>(resultList);
		IBatisTResult<T> ibatisResult = new IBatisTResult<T>(pageInfo.getTotal(), pageInfo.getList());
		return ibatisResult;
	}
	
}
