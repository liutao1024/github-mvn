package cn.spring.mvn.basic.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.basic.util.BasicUtil;

public class IBatisServiceImpl<T> implements IBatisService<T>{
	@Autowired
	private IBatisDao<T> iBatisDao;
	
	@Override
	public Integer insertEntity(T t) {
		String insertSQL = BasicUtil.getIBatisSQl(t, BasicUtil.INSERT);
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
		String deletSQL = BasicUtil.getIBatisSQl(t, BasicUtil.DELETE);
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
		String selectSQL = BasicUtil.getIBatisSQl(t, BasicUtil.SELECT);
		List<Map<String, Object>> daoResult = iBatisDao.selectBySQL(selectSQL);
		List<T> result = BasicUtil.preseMapListToObjectList(clazz, daoResult);
		return result;
	}
	
	@Override
	public Long selectEntitiesCount(T t) {
		String countSQL = BasicUtil.getIBatisSQl(t, BasicUtil.SCOUNT);
		return iBatisDao.selectCountBySQL(countSQL);
	}
	@Override
	public IBatisTResult<T> selectEntitiesWithCount(T t) {
		Integer totalCount = iBatisDao.selectCount(t);
		List<T> resultList = iBatisDao.select(t);
		IBatisTResult<T> iBatisResult = new IBatisTResult<T>(totalCount, resultList);
		return iBatisResult;
	}
	@Override
	public IBatisTResult<T> selectPageEntitiesWithCount(T t) {
		IBatisTParam<T> iBatisParam = new IBatisTParam<T>(t, 0, 10, null, null);
		return this.selectPageEntitiesWithCountByCondition(iBatisParam);
	}
	@Override
	public IBatisTResult<T> selectEntitiesWithCountByCondition(IBatisTParam<T> iBatisParam) {
		return iBatisDao.selectByCondition(iBatisParam);
	}
	@Override
	public IBatisTResult<T> selectPageEntitiesWithCountByCondition(IBatisTParam<T> iBatisParam) {
		return iBatisDao.selectByCondition(iBatisParam);
	}
	
}
