package br.com.co.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.co.dao.CurriculoDAO;
import br.com.co.dao.ProfessorDAO;
import br.com.co.dao.impl.CurriculoDAOImpl;
import br.com.co.dao.impl.ProfessorDAOImpl;
import br.com.co.entity.Curriculo;
import br.com.co.entity.Professor;
import br.com.co.entity.Tratamento;
import br.com.co.exception.CommitException;
import br.com.co.singleton.EntityManagerFactorySingleton;


public class ProfessorView {
	public static void main(String[] args) {
		//factory
		EntityManagerFactory f = EntityManagerFactorySingleton.getInstance();
		//em
		EntityManager em = f.createEntityManager();
		//dao
		ProfessorDAO dao = new ProfessorDAOImpl(em);
		//obj
		Curriculo obj = new Curriculo(null, Tratamento.ME, "Metre Jedi", "Jedi Academy");
		Professor prof1 = new Professor(obj, "Yoda", "yoda@jedi.com");
		//cadastrando com curriculo novo somente via prof
		try {
			dao.create(prof1);
			dao.commit();
			System.out.println("Professor "+prof1.getNome()+" cadastrado com sucesso!");
		} catch (CommitException e) {
			System.out.println("ERRO");
		}
		
		//cadastrando buscando curriculo no BD (cadastrar curriculo anteriormente - pk=1 se for o primeiro)
		CurriculoDAO curriculoDAO = new CurriculoDAOImpl(em);
		
		Professor prof2 = new Professor(curriculoDAO.read(1), "Jhonny do Ukulele", "jhony@ukulele.com");
		
		try {
			dao.create(prof2);
			dao.commit();
			System.out.println("Professor "+prof2.getNome()+" cadastrado com sucesso!");
		} catch (CommitException e) {
			System.out.println("ERRO");
		}
		
		//
		
		//close
		em.close();
		f.close();
	}
	
}
