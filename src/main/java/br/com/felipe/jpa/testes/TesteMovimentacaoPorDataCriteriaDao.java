package br.com.felipe.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.felipe.jpa.config.JpaUtil;
import br.com.felipe.jpa.daos.MovimentacaoDao;
import br.com.felipe.jpa.modelo.Movimentacao;

public class TesteMovimentacaoPorDataCriteriaDao {

	public static void main(String[] args) {
		
		EntityManager em = new JpaUtil().getEntityManager();
		
		MovimentacaoDao dao = new MovimentacaoDao(em);

		
		List<Movimentacao> movimentacoesPorData = dao.getMovimentacoesPorData(25, 11, 2020);
		
		for (Movimentacao movimentacao : movimentacoesPorData) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
            System.out.println("Tipo: " + movimentacao.getValor());
            System.out.println("--------------------------------------------");
		}
	}

}
