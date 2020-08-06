package br.com.co.dao.impl;

import javax.persistence.EntityManager;

import br.com.co.dao.CurriculoDAO;
import br.com.co.entity.Curriculo;

public class CurriculoDAOImpl extends GenericDAOImpl<Curriculo, Integer> implements CurriculoDAO{

	public CurriculoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
