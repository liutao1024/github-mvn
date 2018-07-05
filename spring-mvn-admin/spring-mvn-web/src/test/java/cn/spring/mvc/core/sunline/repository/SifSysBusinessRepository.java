package cn.spring.mvc.core.sunline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.spring.mvc.core.sunline.domain.SifSysBusiness;
import cn.spring.mvc.core.sunline.domain.SifSysBusinessPk;

public interface SifSysBusinessRepository extends JpaRepository<SifSysBusiness, SifSysBusinessPk>,JpaSpecificationExecutor<SifSysBusiness> {
	
}
