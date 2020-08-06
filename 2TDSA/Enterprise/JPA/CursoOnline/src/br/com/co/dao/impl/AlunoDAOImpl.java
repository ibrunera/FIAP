package br.com.co.dao.impl;

import javax.persistence.EntityManager;

import br.com.co.dao.AlunoDAO;
import br.com.co.entity.Aluno;

public class AlunoDAOImpl extends GenericDAOImpl<Aluno, Integer> implements AlunoDAO{

	public AlunoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
