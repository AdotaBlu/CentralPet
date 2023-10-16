package centralpet.modelo.dao.acompanhamento;

import java.util.List;

import centralpet.modelo.entidade.acompanhamento.Acompanhamento;

public interface AcompanhamentoDAO {

	void inserirAcompanhamento(Acompanhamento acompanhamento);

	void deletarAcompanhamento(Acompanhamento acompanhamento);

	void atualizarAcompanhamento(Acompanhamento acompanhamento);

	List<Acompanhamento> recuperarTodosAcompanhamentos();

}
