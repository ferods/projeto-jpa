package br.com.felipe.jpa.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.felipe.jpa.config.JpaUtil;
import br.com.felipe.jpa.modelo.Categoria;
import br.com.felipe.jpa.modelo.MediaDiaria;
import br.com.felipe.jpa.modelo.Movimentacao;

public class MovimentacaoDao {
	
	private EntityManager em;
	private Root<Movimentacao> from;
	
	public MovimentacaoDao(EntityManager em) {
		this.em = em;		
	}
	
	
	public List<Movimentacao> getMovimentacoesDeUmaCategoria(Long id){	
		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria order by m.valor desc";
		Categoria categoria = new Categoria();
		categoria.setId(id);
		return em.createQuery(jpql, Movimentacao.class).setParameter("pCategoria", categoria).getResultList();
		
	}
	
	public List<MediaDiaria> getMediaDiariaDasMovimentacoes(){	    
	      return em.createQuery("select new br.com.felipe.jpa.modelo.MediaDiaria(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)", MediaDiaria.class).getResultList();
	}
	
	public List<Movimentacao> getMovimentacoesPorData(Integer dia, Integer mes, Integer ano){
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(dia != null) {
			Predicate predicate = builder.equal(builder.function("day", Integer.class, root.get("data")), dia) ;	
			predicates.add(predicate);
		}
		
		if(mes != null) {
			Predicate predicate = builder.equal(builder.function("month", Integer.class, root.get("data")), mes) ;	
			predicates.add(predicate);
		}
		
		if(ano != null) {
			Predicate predicate = builder.equal(builder.function("year", Integer.class, root.get("data")), ano) ;	
			predicates.add(predicate);
		}
		
		query.where((Predicate[]) predicates.toArray(new Predicate[0]));
		
		return em.createQuery(query).getResultList();
		
		
	}

}
