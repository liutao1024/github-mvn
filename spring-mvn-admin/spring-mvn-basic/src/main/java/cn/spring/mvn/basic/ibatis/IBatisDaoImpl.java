package cn.spring.mvn.basic.ibatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
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

	@Override
	public T selectOne(T arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> select(T arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCount(T arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T selectByPrimaryKey(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsWithPrimaryKey(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insert(T arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(T arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(T arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(T arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(T arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> selectByExample(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T selectOneByExample(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCountByExample(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(T arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExampleSelective(T arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> selectByExampleAndRowBounds(Object arg0, RowBounds arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> selectByRowBounds(T arg0, RowBounds arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
