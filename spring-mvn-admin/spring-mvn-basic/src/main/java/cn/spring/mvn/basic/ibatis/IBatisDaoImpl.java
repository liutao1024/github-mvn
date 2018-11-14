package cn.spring.mvn.basic.ibatis;

//import java.util.List;
//import java.util.Map;
//
//import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
/**
 * @author LiuTao @date 2018年11月8日 下午1:37:15
 * @ClassName: IBatisDaoImpl 
 * @Description: TODO(主要是懒不想每个实体类都要写一些重复的sql以及在mapper中配置,目前想到的能抽象出来的就这些) 
 * @param <T>这个类弃用
 */
public class IBatisDaoImpl<T> extends SqlSessionDaoSupport/* implements IBatisDao<T>*/ {/*

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

	@Override
	public int insertBySQL(String SQL) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertByCondition(IBatisTParam<T> iBatisParam) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBySQL(String SQL) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByCondition(IBatisTParam<T> iBatisParam) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectBySQL(String SQL) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> selectByCondition(
			IBatisTParam<T> iBatisParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long selectCountBySQL(String SQL) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long selectCountByCondition(IBatisTParam<T> iBatisParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBySQL(String SQL) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByCondition(IBatisTParam<T> iBatisParam) {
		// TODO Auto-generated method stub
		return 0;
	}
	
*/}
