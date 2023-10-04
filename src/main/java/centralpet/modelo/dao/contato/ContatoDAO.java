package centralpet.modelo.dao.contato;

import java.util.List;

import centralpet.modelo.entidade.contato.Contato;
import centralpet.modelo.entidade.usuario.Usuario;

public interface ContatoDAO {

	void inserirContato(Contato contato);
	
	void deletarContato(Contato contato);
	
	void atualizarContato(Contato contato);
	
	List<Contato> recuperarTodosContatos ();
	
	Contato recuperarContatoUsuario(Usuario usuario);
	
}
