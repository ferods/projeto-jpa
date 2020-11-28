package br.com.felipe.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipe.jpa.modelo.Categoria;
import br.com.felipe.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {
		
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria order by m.valor desc";
		Categoria categoria = new Categoria();
		categoria.setId(1L);
		List<Movimentacao> movimentacoes = createEntityManager.createQuery(jpql, Movimentacao.class).setParameter("pCategoria", categoria).getResultList();

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
            System.out.println("Tipo: " + movimentacao.getValor());
            System.out.println("");
		}

	}

}
