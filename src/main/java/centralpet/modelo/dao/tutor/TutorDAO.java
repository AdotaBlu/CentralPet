package centralpet.modelo.dao.tutor;

import java.util.List;

import centralpet.modelo.entidade.tutor.Tutor;
import centralpet.modelo.entidade.usuario.Usuario;

public interface TutorDAO {

	void inserirTutor(Tutor tutor);

	void deletarTutor(Tutor tutor);

	void atualizarTutor(Tutor tutor);

	List<Tutor> recuperarTodosTutores();

	Tutor recuperarTutor(Long id);
	
	Tutor recuperarTutorUsuario(Usuario usuario);
}
