package cn.spring.mvn.basic.ibatis;

import java.util.List;
/**
 * @author LiuTao @date 2018年11月8日 下午1:37:15
 * @ClassName: IBatisDaoImpl 
 * @Description: TODO(主要是懒不想每个实体类都要写一些重复的sql以及在mapper中配置,目前想到的能抽象出来的就这些) 
 * @param <T>
 */
public class IBatisDaoImpl<T> implements IBatisDao<T> {

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
		// TODO Auto-generated method stub
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
