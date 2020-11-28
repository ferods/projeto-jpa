package br.com.felipe.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteTabelaJpa {

	public static void main(String[] args) {
		
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		
				
		createEntityManager.close();
		createEntityManagerFactory.close();

	}

}
