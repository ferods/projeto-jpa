package br.com.felipe.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipe.jpa.modelo.Conta;
import br.com.felipe.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {

		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";
		Conta conta = new Conta();
		conta.setId(1L);
		List<Movimentacao> movimentacoes = createEntityManager.createQuery(jpql, Movimentacao.class).setParameter("pConta", conta ).getResultList();

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
            System.out.println("Tipo: " + movimentacao.getValor());
            System.out.println("");
		}
		
	}

}
