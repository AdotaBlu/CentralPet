package centralpet.modelo.dao.avaliacao;

import java.util.List;

import centralpet.modelo.entidade.avaliacao.Avaliacao;
import centralpet.modelo.entidade.ong.Ong;

public interface AvaliacaoDAO {

	void inserirAvaliacao(Avaliacao avaliacao);
	
	void deletarAvaliacao(Avaliacao avaliacao);
	
	List<Avaliacao> recuperarAvaliacoesOng(Ong ong);
}
