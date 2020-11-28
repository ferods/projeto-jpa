package br.com.felipe.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipe.jpa.modelo.Conta;
import br.com.felipe.jpa.modelo.Movimentacao;

public class TesteUpdateMovimentacaoConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(2L);
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Movimentacao find = createEntityManager.find(Movimentacao.class, 5L);
		find.setConta(conta);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
	}

}
