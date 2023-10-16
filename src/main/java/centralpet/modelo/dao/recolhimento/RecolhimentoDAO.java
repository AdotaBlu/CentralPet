package centralpet.modelo.dao.recolhimento;

import java.util.List;

import centralpet.modelo.entidade.recolhimento.Recolhimento;

public interface RecolhimentoDAO {

	void inserirRecolhimento(Recolhimento recolhimento);

	void deletarRecolhimento(Recolhimento recolhimento);

	void atualizarRecolhimento(Recolhimento recolhimento);

	List<Recolhimento> recuperarTodosRecolhimentos();
}
