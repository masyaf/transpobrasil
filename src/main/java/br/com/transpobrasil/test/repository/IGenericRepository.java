package br.com.transpobrasil.test.repository;

import java.io.Serializable;
import java.util.List;

public interface IGenericRepository<T, K>  extends Serializable{

	void save(T entity);
	void update(T entity);
	void delete(T t);
    T byCode(K k);
    List<T> byName(String name);
    List<T> all();
    void beginTransaction();
    void commitTransaction();

}
