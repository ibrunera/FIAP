package br.com.co.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.co.dao.CurriculoDAO;
import br.com.co.dao.impl.CurriculoDAOImpl;
import br.com.co.entity.Curriculo;
import br.com.co.entity.Tratamento;
import br.com.co.exception.CommitException;
import br.com.co.singleton.EntityManagerFactorySingleton;

public class CurriculoView {
	public static void main(String[] args) {
		//factory
		EntityManagerFactory f = EntityManagerFactorySingleton.getInstance();
		//em
		EntityManager em = f.createEntityManager();
		//dao
		CurriculoDAO dao = new CurriculoDAOImpl(em);
		//obj
		Curriculo obj = new Curriculo(null, Tratamento.DR, "Doutorado em Ukelele", "Ukulele University");
		//cadastrar
		
		try {
			dao.create(obj);
			dao.commit();
			System.out.println("Currículo Cadastrado com Sucesso!");
		} catch (CommitException e) {
			System.out.println("ERRO");
		}
		//close
		em.close();
		f.close();
	}
}
