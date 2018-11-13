package cn.spring.mvn.core.loan.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.ibatis.IBatisServiceImpl;
import cn.spring.mvn.core.loan.entity.Student;
import cn.spring.mvn.core.loan.entity.dao.StudentDao;
import cn.spring.mvn.core.loan.entity.service.StudentService;


@Service("StudentService")
public class StudentServiceImpl extends IBatisServiceImpl<Student> implements StudentService{
	@Resource
	private StudentDao dao;
	@Override
	public List<Student> selectStudents() {
		return dao.selectAll();
	}

}
