package cn.spring.mvn.core.amain.entity.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.spring.mvn.basic.ibatis.IBatisDao;
import cn.spring.mvn.core.amain.entity.CoreMain;

public interface CoreMainDao extends IBatisDao<CoreMain>{
	@Insert("insert into core_main(id, name) values(#{id}, #{name})")
    Integer insertOneEntity(CoreMain entity);
	@Select("select * from core_main where id = #{id}")
	List<CoreMain> selectEntityList(String id);
	@Select("select * from core_main where id = #{PK}")
	CoreMain selectOneEntityByPK(Serializable PK);
	
}
