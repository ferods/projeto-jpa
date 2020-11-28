package br.com.felipe.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipe.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
    
		//transient um potencial managed, não possui sincronização automatica e nem id
        Conta conta = new Conta();
        conta.setTitular("Leonardo");
        conta.setNumero(1234);
        conta.setAgencia(4321);

        EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		createEntityManager.getTransaction().begin();
		createEntityManager.persist(conta);
		createEntityManager.getTransaction().commit();		
		createEntityManager.close();
		createEntityManagerFactory.close();
	}

}
