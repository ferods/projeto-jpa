package br.com.felipe.jpa.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteSomaMovimentacoes {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	    EntityManager em = emf.createEntityManager();
	    
	      BigDecimal singleResult = em.createQuery("select sum(m.valor) from Movimentacao m ", BigDecimal.class).getSingleResult();

	      System.out.println("A soma: " + singleResult);
	}

}
