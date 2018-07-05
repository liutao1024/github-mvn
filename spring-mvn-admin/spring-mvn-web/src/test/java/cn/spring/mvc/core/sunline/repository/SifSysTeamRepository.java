package cn.spring.mvc.core.sunline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.spring.mvc.core.sunline.domain.SifSysTeam;
import cn.spring.mvc.core.sunline.domain.SifSysTeamPk;

public interface SifSysTeamRepository extends JpaRepository<SifSysTeam, SifSysTeamPk>,JpaSpecificationExecutor<SifSysTeam> {
	
}
