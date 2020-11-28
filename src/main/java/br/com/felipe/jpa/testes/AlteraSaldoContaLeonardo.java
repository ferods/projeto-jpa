package br.com.felipe.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipe.jpa.modelo.Conta;

public class AlteraSaldoContaLeonardo {

	public static void main(String[] args) {
		
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		
		Conta conta = createEntityManager.find(Conta.class, 1L);
		
		createEntityManager.getTransaction().begin();
		conta.setSaldo(20.0);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();

	}

}
