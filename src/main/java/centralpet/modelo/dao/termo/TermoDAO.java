package centralpet.modelo.dao.termo;

import java.util.List;

import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.termo.Termo;

public interface TermoDAO {

	void inserirTermo(Termo termo);

	void deletarTermo(Termo termo);

	void atualizarTermo(Termo termo);

	List<Termo> recuperarTermosOng(Ong id);

}
