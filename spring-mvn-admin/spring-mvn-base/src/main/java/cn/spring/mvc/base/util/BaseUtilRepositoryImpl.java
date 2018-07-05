package cn.spring.mvc.base.util;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public class BaseUtilRepositoryImpl<T, PK extends Serializable> implements BaseUtilRepository<T, PK> {

	@Autowired
	private BaseUtilRepository<T, Serializable> commUtilRepositoryImpl;
	
	// 从Repository中继承来的
	@Override
	public void deleteAllInBatch() {
		commUtilRepositoryImpl.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<T> arg0) {
		commUtilRepositoryImpl.deleteInBatch(arg0);
	}

	@Override
	public List<T> findAll() {
		return commUtilRepositoryImpl.findAll();
	}

	@Override
	public List<T> findAll(Sort arg0) {
		return commUtilRepositoryImpl.findAll(arg0);
	}


	@Override
	public T getOne(Serializable arg0) {
		return commUtilRepositoryImpl.getOne(arg0);
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> arg0) {
		return commUtilRepositoryImpl.save(arg0);
	}

	@Override
	public <S extends T> S saveAndFlush(S arg0) {
		return commUtilRepositoryImpl.saveAndFlush(arg0);
	}

	@Override
	public Page<T> findAll(Pageable arg0) {
		return commUtilRepositoryImpl.findAll(arg0);
	}

	@Override
	public void delete(Serializable arg0) {
		commUtilRepositoryImpl.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends T> arg0) {
		commUtilRepositoryImpl.delete(arg0);
	}

	@Override
	public void deleteAll() {
		commUtilRepositoryImpl.deleteAll();
	}

	@Override
	public boolean exists(Serializable arg0) {
		return commUtilRepositoryImpl.exists(arg0);
	}

	@Override
	public T findOne(Serializable arg0) {
		return commUtilRepositoryImpl.findOne(arg0);
	}

	@Override
	public long count(Specification<T> arg0) {
		return commUtilRepositoryImpl.count(arg0);
	}

	@Override
	public List<T> findAll(Specification<T> arg0) {
		return commUtilRepositoryImpl.findAll(arg0);
	}

	@Override
	public Page<T> findAll(Specification<T> arg0, Pageable arg1) {
		return commUtilRepositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public List<T> findAll(Specification<T> arg0, Sort arg1) {
		return commUtilRepositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public T findOne(Specification<T> arg0) {
		return commUtilRepositoryImpl.findOne(arg0);
	}

	@Override
	public <S extends T> S save(S arg0) {
		return commUtilRepositoryImpl.save(arg0);
	}


	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> findAll(Iterable<PK> ids) {
		// TODO Auto-generated method stub
		return null;
	}
}
