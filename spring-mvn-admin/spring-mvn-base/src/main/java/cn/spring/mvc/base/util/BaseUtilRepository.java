package cn.spring.mvc.base.util;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseUtilRepository<T, PK extends Serializable> extends JpaRepository<T, PK>,JpaSpecificationExecutor<T>{

}
