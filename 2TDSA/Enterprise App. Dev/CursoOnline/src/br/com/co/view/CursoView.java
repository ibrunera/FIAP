package br.com.co.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.co.dao.CursoDAO;
import br.com.co.dao.ProfessorDAO;
import br.com.co.dao.impl.CursoDAOImpl;
import br.com.co.dao.impl.ProfessorDAOImpl;
import br.com.co.entity.Curso;
import br.com.co.exception.CommitException;
import br.com.co.singleton.EntityManagerFactorySingleton;

public class CursoView {
	public static void main(String[] args) {
		//factory
		EntityManagerFactory f = EntityManagerFactorySingleton.getInstance();
		//em
		EntityManager em = f.createEntityManager();
		//dao
		CursoDAO dao = new CursoDAOImpl(em);
		//cadastrar um professor antes - ProfessorView, assim PK=1
		ProfessorDAO pfDao = new ProfessorDAOImpl(em);
		//obj
		Curso curso = new Curso("Ukulele em 5h", 5, 29.90f);
		curso.setProfessor(pfDao.read(1));
		//cadastrar
		try {
			dao.create(curso);
			dao.commit();
			System.out.println("Curso cadastrado com sucesso!");
		} catch (CommitException e) {
			System.out.println("ERRO");
		}
		//close
		em.close();
		f.close();
	}
}
