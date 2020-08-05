package br.com.co.dao.impl;

import javax.persistence.EntityManager;

import br.com.co.dao.CursoDAO;
import br.com.co.entity.Curso;

public class CursoDAOImpl extends GenericDAOImpl<Curso, Integer> implements CursoDAO{

	public CursoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
