package cn.spring.mvn.basic.ibatis;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.spring.mvn.basic.util.BasicUtil;
/**
 * @author LiuTao @date 2018年11月8日 下午1:37:15
 * @ClassName: IBatisDaoImpl 
 * @Description: TODO(主要是懒不想每个实体类都要写一些重复的sql以及在mapper中配置,目前想到的能抽象出来的就这些) 
 * @param <T>
 */
public class IBatisDaoImpl<T> extends SqlSessionDaoSupport implements IBatisDao<T> {

	@Override
	public int insertEntity(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertEntities(List<T> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEntity(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEntities(List<T> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T selectEntity(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> selectEntities(T t) {
		//将泛型T解出来成为实体类entity
		Class<?> clazz = t.getClass();
		//获取表名
		String tableName = clazz.getSimpleName().toLowerCase();
		//根据传入的实体类t获得参数map
		Map<String, Object> paramMap = BasicUtil.getObjectMapByReflectObject(t);//
		String mySQL = "select * from " + tableName + " where 1 = 1 ";
		String appendSQL = "";
		for (Map.Entry<String, Object> entry: paramMap.entrySet()) {
			appendSQL += "and " + entry.getKey() + " = '" + entry.getValue() + "' "; 
		}
		//将参数和表明组成一条SQL语句
		mySQL = mySQL + appendSQL;
		//
		return null;
	}

	@Override
	public int selectEntitiesCount(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IBatisPageResult<T> selectEntitiesWithCount(IBatisPageEntity<T> BPEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBatisPageResult<T> selectPageEntitiesWithCount(IBatisPageEntity<T> BPEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
