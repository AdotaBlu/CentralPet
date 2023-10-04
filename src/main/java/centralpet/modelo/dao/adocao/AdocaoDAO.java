package centralpet.modelo.dao.adocao;

import java.util.List;

import centralpet.modelo.entidade.adocao.Adocao;
import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.tutor.Tutor;

public interface AdocaoDAO {

	void inserirAdocao(Adocao adocao);
	
	void deletarAdocao(Adocao adocao);
	
	void atualizarAdocao(Adocao adocao);
	
	List<Adocao> recuperarTodasAdocoes();
	
	List<Adocao> recuperarAdocoesTutor(Tutor tutor);
	
	List<Adocao> recuperarAdocoesOng(Ong ong);
}
