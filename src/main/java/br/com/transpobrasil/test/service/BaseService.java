package br.com.transpobrasil.test.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, K> extends Serializable {

	void save(T entity);
	void update(T entity);
	void delete(T t);
    T byCode(K code);
    List<T> byName(String name);
    List<T> all();
}
