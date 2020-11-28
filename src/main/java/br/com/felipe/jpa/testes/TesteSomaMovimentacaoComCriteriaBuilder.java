package br.com.felipe.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.felipe.jpa.config.JpaUtil;
import br.com.felipe.jpa.modelo.Movimentacao;

public class TesteSomaMovimentacaoComCriteriaBuilder {

	public static void main(String[] args) {
		
		EntityManager em = new JpaUtil().getEntityManager();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		//identificar o retorno da query
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
		//indentificar a classe que representa a tabela selecionada
		Root<Movimentacao> root = query.from(Movimentacao.class);
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
		query.select(sum);
		
		TypedQuery<BigDecimal> createQuery = em.createQuery(query);
		
		System.out.println("Soma das movimentações: " + createQuery.getSingleResult());
		
		

	}

}
