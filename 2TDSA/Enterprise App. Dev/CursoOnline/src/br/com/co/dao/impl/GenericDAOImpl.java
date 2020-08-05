package br.com.co.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.co.dao.GenericDAO;
import br.com.co.exception.CommitException;
import br.com.co.exception.DataNotFoundException;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T,K>{
	
	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void create(T entity) {
		em.persist(entity);
	}

	@Override
	public T read(K key) {
		return em.find(clazz, key);
		
	}

	@Override
	public void upload(T entity) {
		em.merge(entity);
	}

	@Override
	public void delete(K key) throws DataNotFoundException {
		T entity= read(key);
		if(entity==null)
			throw new DataNotFoundException();
		em.remove(entity);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
	}

}
