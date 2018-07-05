package cn.spring.mvc.core.sunline.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.spring.mvc.core.sunline.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
