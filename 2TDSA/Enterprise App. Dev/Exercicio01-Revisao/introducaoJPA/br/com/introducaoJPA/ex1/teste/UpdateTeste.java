package br.com.introducaoJPA.ex1.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.introducaoJPA.ex1.entity.Genero;
import br.com.introducaoJPA.ex1.entity.Motorista;
import br.com.introducaoJPA.ex1.entity.Veiculo;

public class UpdateTeste {

	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = f.createEntityManager();
		
		//MERGE - ATUALIZA O BANCO COM O OBJ
		Motorista motorista = new Motorista(1001001, "Brianna O'Connel", Calendar.getInstance(), null, Genero.OUTROS );
		em.merge(motorista);
		
		Veiculo v = new Veiculo("XPX6009", "PEROLA", 1997);
		v.setCodigo(1);
		
		em.merge(v);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//prova real
		Veiculo testev = em.find(Veiculo.class, 1);
		System.out.println(testev.getPlaca()+" "+testev.getAno());
		
		Motorista testm = em.find(Motorista.class, 1001001);
		System.out.println(testm.getNome()+" "+testm.getGenero());
		
		//REFRESH - ATUALIZA O OBJ COM O BANCO
		//
		
		em.close();
		f.close();
		
	}

}
