package br.com.co.dao;

import br.com.co.exception.CommitException;
import br.com.co.exception.DataNotFoundException;

public interface GenericDAO<T,K> {
	//CRUD
	void create(T entity);
	T read(K key);
	void upload(T entity);
	void delete(K key) throws DataNotFoundException;
	
	void commit() throws CommitException;
	
}
