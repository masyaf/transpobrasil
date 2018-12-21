package br.com.transpobrasil.test.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import br.com.transpobrasil.test.repository.IGenericRepository;
import br.com.transpobrasil.test.util.hibernate.HibernateUtil;

/*
 * @author masyaf
 * Essa classe é responsável por realizar as operações básicas no banco de dados com
 * salvar, atualizar, excluir e listar.
 *
 */

public abstract class AbstractGenericRepository<T, K> implements IGenericRepository<T, K>, Serializable {

	private static final long serialVersionUID = 1017454431151066494L;

	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractGenericRepository(@SuppressWarnings("rawtypes") Class persistentClass) {
		super();
		this.persistentClass = persistentClass;
	}

	/**
	 * Método responsável por efetuar uma operação para salvar uma entidade T
	 * 
	 * @param T
	 */

	@Override
	public void save(T entity) {
		try {
			HibernateUtil.getSession().beginTransaction();
			HibernateUtil.getSession().saveOrUpdate(entity);
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			e.getCause();
			HibernateUtil.rollBackTransaction();
		} finally {
			HibernateUtil.closeSession();
		}

	}

	/**
	 * Método responsável por realizar excluir um Objeto
	 * 
	 * @param T
	 */
	@Override
	public void delete(T entity) {
		try {
			HibernateUtil.getSession().beginTransaction();
			HibernateUtil.getSession().delete(entity);
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
			HibernateUtil.rollBackTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	/**
	 * Método responsável por realizar uma busca no banco de dados através do
	 * paramatro passado. Como retorno, obtém a entidade que corrende ao id
	 * 
	 * @param Integer
	 * @return T
	 */
	@Override
	public T byCode(K code) {
		T toReturn = null;
		try {
			HibernateUtil.getSession().beginTransaction();
			Criteria criteria = HibernateUtil.getSession().createCriteria(persistentClass);
			@SuppressWarnings("unchecked")
			T t = (T) criteria.add(Restrictions.eq("code", code)).uniqueResult();
			toReturn = t;
		} catch (HibernateException e) {
			e.getCause();
			HibernateUtil.rollBackTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return toReturn;

	}

	/**
	 * Método responsável por realizar uma busca no banco de dados através do
	 * paramatro passado. Como retorno, obtém a entidade que corrende ao nome
	 * 
	 * @param String
	 * @return {@link List}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> byName(String name) {
		List<T> toReturn = null;
		try {
			HibernateUtil.getSession().beginTransaction();
			Criteria criteria = HibernateUtil.getSession().createCriteria(persistentClass);
			toReturn = criteria.add(Restrictions.eq("name", name)).list();

		} catch (HibernateException e) {
			e.getCause();
			HibernateUtil.rollBackTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return toReturn;

	}

	/**
	 * Método responsável por obter todos os registros e e retornar uma lista de T
	 * 
	 * @return {@link List}
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> all() {
		List<T> toReturn = null;
		try {
			HibernateUtil.getSession().beginTransaction();
			Criteria criteria = HibernateUtil.getSession().createCriteria(persistentClass);
			T t = (T) criteria.list();
			toReturn = (List<T>) t;
		} catch (HibernateException e) {
			e.getCause();
			HibernateUtil.rollBackTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return toReturn;
	}

	/**
	 * Método responsável por atualizar uma entidade
	 * 
	 * @param T
	 * 
	 */
	@Override
	public void update(T entity) {
		try {
			HibernateUtil.getSession().beginTransaction();
			HibernateUtil.getSession().update(entity);
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			e.getCause();
			HibernateUtil.rollBackTransaction();
		} finally {
			HibernateUtil.closeSession();

		}

	}

	/*
	 * Inicia uma transação através da classe HibernateUtil
	 * 
	 * 
	 */
	@Override
	public void beginTransaction() {
		HibernateUtil.beginTransaction();
	}

	/*
	 * Realiza o commit na transação
	 * 
	 * 
	 */

	@Override
	public void commitTransaction() {
		HibernateUtil.commitTransaction();
	}

	public void closeSession() {
		HibernateUtil.closeSession();
	}
}
