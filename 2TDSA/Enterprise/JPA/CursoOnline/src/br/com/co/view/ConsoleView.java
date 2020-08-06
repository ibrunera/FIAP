package br.com.co.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.co.dao.AlunoDAO;
import br.com.co.dao.ProfessorDAO;
import br.com.co.dao.impl.AlunoDAOImpl;
import br.com.co.dao.impl.ProfessorDAOImpl;
import br.com.co.entity.Aluno;
import br.com.co.entity.Curriculo;
import br.com.co.entity.Curso;
import br.com.co.entity.Professor;
import br.com.co.entity.Tratamento;
import br.com.co.exception.CommitException;
import br.com.co.singleton.EntityManagerFactorySingleton;


public class ConsoleView {

	public static void main(String[] args) {
		//factory
		EntityManagerFactory f = EntityManagerFactorySingleton.getInstance();
		//em
		EntityManager em = f.createEntityManager();
		
		//objS - curriculo->prof-->list-->curso--<<cursando>>--List>>aluno
		Curriculo curriculo = new Curriculo(null, Tratamento.PHD, "PHD in Energy", "MIT");
		Professor prof = new Professor(curriculo, "Thomas Edson", "tom@nottesla.com");
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Electricity - 101", 20, 1f));
		cursos.add(new Curso("Electricity - Advanced", 40, 10f));
		cursos.add(new Curso("Electricity - Why Telsa is Wrong", 80, 1000f));
		cursos.add(new Curso("Electricity - Telsa is Stupid", 120, 99999f));
		cursos.add(new Curso("Electricity is not Tesla",220, 5000000f));
		cursos.add(new Curso("Electricity is not Piramid's Scheme?", 2000, 1999999f));
		
		Aluno aluno1 = new Aluno("Bob Dylan", new GregorianCalendar(1941, Calendar.MAY, 24), "bob@zimmerman.com", "b0bdy14n");
		aluno1.setCursos(cursos);
		Aluno aluno2 = new Aluno("Julie Mulie", new GregorianCalendar(1999, Calendar.DECEMBER, 2), "juliemulie@gmail.com", "mUl13jUl13");
		aluno2.setCursos(cursos);
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(aluno1);
		alunos.add(aluno2);
		
		for (Curso curso : cursos) {
			curso.setAlunos(alunos);
			prof.addCurso(curso);
		}
		
		
		//dao 
		ProfessorDAO pfDao = new ProfessorDAOImpl(em);
		
		//cadastrar
		try {
			pfDao.create(prof);
			pfDao.commit();
			System.out.println("** Cadastro concluído com sucesso! **");
		} catch (CommitException e) {
			System.out.println("Erro!!!");
		}
		
		System.out.println(" ");
		
		//conferindo relacionamento curso-aluno
		AlunoDAO alDao = new AlunoDAOImpl(em);
		
		Aluno testeAluno = alDao.read(1);
		for (Curso c : testeAluno.getCursos()) {
			System.out.println("Aluno: "+testeAluno.getNome()+" Curso: "+c.getNome()+".");
		}
		
		//close
		em.close();
		f.close();
	}

}
