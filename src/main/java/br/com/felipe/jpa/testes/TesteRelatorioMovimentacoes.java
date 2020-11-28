package br.com.felipe.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipe.jpa.modelo.Conta;

public class TesteRelatorioMovimentacoes {

	public static void main(String[] args) {
		
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		
		String jpql = "select c from Conta c join fetch c.movimentacoes m";
		List<Conta> resultList = createEntityManager.createQuery(jpql, Conta.class).getResultList();
		
		
		for (Conta conta : resultList) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Agencia: " + conta.getAgencia());
			System.out.println("Numero: " + conta.getNumero());
			System.out.println("movimentacoes: " + conta.getMovimentacoes());
			System.out.println();
		}

	}

}
