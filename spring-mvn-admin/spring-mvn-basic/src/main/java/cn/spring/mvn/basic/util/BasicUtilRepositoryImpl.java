package cn.spring.mvn.basic.util;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public class BasicUtilRepositoryImpl<T, PK extends Serializable> implements
		BasicUtilRepository<T, PK> {

	@Autowired
	private BasicUtilRepository<T, Serializable> basicUtilRepositoryImpl;

	// 从Repository中继承来的
	@Override
	public void deleteAllInBatch() {
		basicUtilRepositoryImpl.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<T> arg0) {
		basicUtilRepositoryImpl.deleteInBatch(arg0);
	}

	@Override
	public List<T> findAll() {
		return basicUtilRepositoryImpl.findAll();
	}

	@Override
	public List<T> findAll(Sort arg0) {
		return basicUtilRepositoryImpl.findAll(arg0);
	}

	@Override
	public T getOne(Serializable arg0) {
		return basicUtilRepositoryImpl.getOne(arg0);
	}

	@Override
	public <S extends T> S saveAndFlush(S arg0) {
		return basicUtilRepositoryImpl.saveAndFlush(arg0);
	}

	@Override
	public Page<T> findAll(Pageable arg0) {
		return basicUtilRepositoryImpl.findAll(arg0);
	}

	@Override
	public void deleteAll() {
		basicUtilRepositoryImpl.deleteAll();
	}

	@Override
	public long count(Specification<T> arg0) {
		return basicUtilRepositoryImpl.count(arg0);
	}

	@Override
	public List<T> findAll(Specification<T> arg0) {
		return basicUtilRepositoryImpl.findAll(arg0);
	}

	@Override
	public Page<T> findAll(Specification<T> arg0, Pageable arg1) {
		return basicUtilRepositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public List<T> findAll(Specification<T> arg0, Sort arg1) {
		return basicUtilRepositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public <S extends T> S save(S arg0) {
		return basicUtilRepositoryImpl.save(arg0);
	}

	@Override
	public void flush() {
		basicUtilRepositoryImpl.flush();

	}

	@Override
	public long count() {
		return basicUtilRepositoryImpl.count();
	}

	@Override
	public void delete(T entity) {
		basicUtilRepositoryImpl.delete(entity);
	}

	@Override
	public List<T> findAllById(Iterable<PK> ids) {
		return null;
	}

	@Override
	public <S extends T> List<S> saveAll(Iterable<S> entities) {
		return basicUtilRepositoryImpl.saveAll(entities);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example) {
		return basicUtilRepositoryImpl.findAll(example);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		return basicUtilRepositoryImpl.findAll(example, sort);
	}

	@Override
	public void deleteAll(Iterable<? extends T> arg0) {
		basicUtilRepositoryImpl.deleteAll(arg0);
	}

	@Override
	public void deleteById(PK arg0) {
		basicUtilRepositoryImpl.deleteById(arg0);
	}

	@Override
	public boolean existsById(PK arg0) {
		return basicUtilRepositoryImpl.existsById(arg0);
	}

	@Override
	public Optional<T> findById(PK arg0) {
		return basicUtilRepositoryImpl.findById(arg0);
	}

	@Override
	public <S extends T> long count(Example<S> arg0) {
		return basicUtilRepositoryImpl.count(arg0);
	}

	@Override
	public <S extends T> boolean exists(Example<S> arg0) {
		return basicUtilRepositoryImpl.exists(arg0);
	}

	@Override
	public <S extends T> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		return basicUtilRepositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public <S extends T> Optional<S> findOne(Example<S> arg0) {
		return basicUtilRepositoryImpl.findOne(arg0);
	}

	@Override
	public Optional<T> findOne(Specification<T> spec) {
		return basicUtilRepositoryImpl.findOne(spec);
	}
}
