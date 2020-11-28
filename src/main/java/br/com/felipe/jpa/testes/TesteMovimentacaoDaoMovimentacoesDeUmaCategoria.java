package br.com.felipe.jpa.testes;

import br.com.felipe.jpa.config.JpaUtil;
import br.com.felipe.jpa.daos.MovimentacaoDao;
import br.com.felipe.jpa.modelo.Movimentacao;

public class TesteMovimentacaoDaoMovimentacoesDeUmaCategoria {

	public static void main(String[] args) {		
		
		MovimentacaoDao dao = new MovimentacaoDao(new JpaUtil().getEntityManager());
		
		for (Movimentacao movimentacao : dao.getMovimentacoesDeUmaCategoria(1L)) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
            System.out.println("Tipo: " + movimentacao.getValor());
            System.out.println("");
		}
		

	}

}
