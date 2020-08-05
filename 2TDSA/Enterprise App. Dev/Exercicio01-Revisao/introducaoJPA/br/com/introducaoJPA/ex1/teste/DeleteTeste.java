package br.com.introducaoJPA.ex1.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.introducaoJPA.ex1.entity.Motorista;
import br.com.introducaoJPA.ex1.entity.Veiculo;

public class DeleteTeste {

	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = f.createEntityManager();
		
		Veiculo v = em.find(Veiculo.class, 1);
		em.remove(v);
		
		Motorista m = em.find(Motorista.class, 1001001);
		em.remove(m);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		f.close();
	}

}
