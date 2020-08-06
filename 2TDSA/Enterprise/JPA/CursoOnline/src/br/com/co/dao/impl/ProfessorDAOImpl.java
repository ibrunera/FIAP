package br.com.co.dao.impl;

import javax.persistence.EntityManager;

import br.com.co.dao.ProfessorDAO;
import br.com.co.entity.Professor;

public class ProfessorDAOImpl extends GenericDAOImpl<Professor, Integer> implements ProfessorDAO{

	public ProfessorDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
