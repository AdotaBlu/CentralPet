package centralpet.modelo.dao.visita;

import java.util.List;

import centralpet.modelo.entidade.visita.Visita;

public interface VisitaDAO {
	void inserirVisita(Visita visita);

	void deletarVisita(Visita visita);

	void atualizarVisita(Visita visita);

	List<Visita> recuperarTodasVisitas();
}
