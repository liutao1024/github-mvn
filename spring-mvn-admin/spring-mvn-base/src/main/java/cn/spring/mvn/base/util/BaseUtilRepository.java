package cn.spring.mvn.base.util;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseUtilRepository<T, PK extends Serializable> extends JpaRepository<T, PK>,JpaSpecificationExecutor<T>{

	boolean exists(Serializable arg0);

	T findOne(Serializable arg0);

	void delete(Serializable arg0);

	void delete(Iterable<? extends T> arg0);

	List<T> findAll(Iterable<PK> ids);
	
}
