package br.com.felipe.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipe.jpa.modelo.Conta;
import br.com.felipe.jpa.modelo.Movimentacao;
import br.com.felipe.jpa.modelo.TipoMovimentacao;

public class TesteRelacionamentoMuitosParaUm {

	public static void main(String[] args) {
		
		 Conta conta = new Conta();
		    conta.setId(1L);

		        Movimentacao movimentacao = new Movimentacao();
		        movimentacao.setData(LocalDateTime.now());
		        movimentacao.setDescricao("Churrascaria");
		        movimentacao.setValor(new BigDecimal(200.0));
		        movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		        movimentacao.setConta(conta);
		        
		        Movimentacao movimentacao2 = new Movimentacao();
		        movimentacao2.setData(LocalDateTime.now());
		        movimentacao2.setDescricao("Sorveteria");
		        movimentacao2.setValor(new BigDecimal(30.0));
		        movimentacao2.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		        movimentacao2.setConta(conta);


		        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		        EntityManager em = emf.createEntityManager();

		        em.getTransaction().begin();
		        em.persist(movimentacao);
		        em.persist(movimentacao2);
		        em.getTransaction().commit();

		        em.close();
		        
		        

	}

}
