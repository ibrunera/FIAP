package br.com.co.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	private static  EntityManagerFactory f;
	
	private EntityManagerFactorySingleton() {}

	public static EntityManagerFactory getInstance() {
		if (f==null)
			f= Persistence.createEntityManagerFactory("oracle");
		return f;
	}
}
