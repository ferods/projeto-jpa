package br.com.felipe.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipe.jpa.modelo.MediaDiaria;

public class TestaMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	    EntityManager em = emf.createEntityManager();
	    
	      List<MediaDiaria> mediasDiaria = em.createQuery("select new br.com.felipe.jpa.modelo.MediaDiaria(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)", MediaDiaria.class).getResultList();

	      for (MediaDiaria mediaDiaria : mediasDiaria) {
	    	  System.out.println("A media do dia " + mediaDiaria.getDia() + "/" + mediaDiaria.getMes() + ": " + mediaDiaria.getValor());
		}
	      

	}

}
