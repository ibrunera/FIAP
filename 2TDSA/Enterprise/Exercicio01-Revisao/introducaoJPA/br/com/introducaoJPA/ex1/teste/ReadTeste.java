package br.com.introducaoJPA.ex1.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.introducaoJPA.ex1.entity.Motorista;
import br.com.introducaoJPA.ex1.entity.Veiculo;

public class ReadTeste {

	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("oracle");
		EntityManager m = f.createEntityManager();
		
		Veiculo v = m.find(Veiculo.class, 1);
		System.out.println("-- Placa: "+v.getPlaca()+", Ano:"+v.getAno()+", Cor:"+ v.getCor());

		Motorista motorista = m.find(Motorista.class, 1001001);
		System.out.println("-- Nome: "+motorista.getNome()+", Data Nascimento:"+motorista.getDataNascimento().getTimeInMillis()+", Foto:"+motorista.getFotoCarteira()+", Genero:"+motorista.getGenero());
		
		
		m.getTransaction().begin();
		m.getTransaction().commit();
		
		m.close();
		f.close();
	}

}
