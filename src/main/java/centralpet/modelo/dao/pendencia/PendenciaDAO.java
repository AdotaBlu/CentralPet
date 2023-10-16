package centralpet.modelo.dao.pendencia;

import java.util.List;

import centralpet.modelo.entidade.pendencia.Pendencia;

public interface PendenciaDAO {
	void inserirPendencia(Pendencia pendencia);

	void deletarPendencia(Pendencia pendencia);

	void atualizarPendencia(Pendencia pendencia);

	List<Pendencia> recuperarTodasPendencias();

}
