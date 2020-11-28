package br.com.felipe.jpa.testes;

import br.com.felipe.jpa.config.JpaUtil;
import br.com.felipe.jpa.daos.MovimentacaoDao;
import br.com.felipe.jpa.modelo.MediaDiaria;

public class TesteMovimentacaoDaoMediaDiaria {

	public static void main(String[] args) {
	    
	    MovimentacaoDao dao = new MovimentacaoDao(new JpaUtil().getEntityManager());
	    
	      for (MediaDiaria mediaDiaria : dao.getMediaDiariaDasMovimentacoes()) {
	    	  System.out.println("A media do dia " + mediaDiaria.getDia() + "/" + mediaDiaria.getMes() + ": " + mediaDiaria.getValor());
		}

	}

}
