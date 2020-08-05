package br.com.introducaoJPA.ex1.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.introducaoJPA.ex1.entity.Genero;
import br.com.introducaoJPA.ex1.entity.Motorista;
import br.com.introducaoJPA.ex1.entity.Veiculo;

public class CreateTeste {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager manager = factory.createEntityManager();
		
		
		Veiculo veiculo = new Veiculo("ABC0101", "BRANCO", 1990);
		manager.persist(veiculo);
		
		
		Motorista motorista = new Motorista(1001001, "Brian Toreto", Calendar.getInstance(), null, Genero.MASCULINO );
		manager.persist(motorista);
		
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}

}
