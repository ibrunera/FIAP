package br.com.co.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.co.dao.AlunoDAO;
import br.com.co.dao.impl.AlunoDAOImpl;
import br.com.co.entity.Aluno;
import br.com.co.exception.CommitException;
import br.com.co.singleton.EntityManagerFactorySingleton;

public class AlunoView {
	public static void main(String[] args) {
		//factory
		EntityManagerFactory f = EntityManagerFactorySingleton.getInstance();
		//em
		EntityManager em = f.createEntityManager();
		//dao
		AlunoDAO dao = new AlunoDAOImpl(em);
		//obj
		Aluno aluno1 = new Aluno("Bob Btytes", new GregorianCalendar(2000, Calendar.JULY, 15),"bobbytes@gmail.com","b0bbyt35");
		//cadastrar
		try {
			dao.create(aluno1);
			System.out.println("Create OK");
			dao.commit();
			System.out.println("Aluno Cadastrado com Sucesso!");
		} catch (CommitException e) {
			System.out.println("ERROR");
		}
		//close
		em.close();
		f.close();
		
	}
}
