package centralpet.modelo.dao.usuario;

import java.util.List;
import centralpet.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {

	void inserirUsuario(Usuario usuario);
	
	void deletarUsuario(Usuario usuario);
	
	void atualizarUsuario(Usuario usuario);
	
	String recuperarEmailUsuario(Usuario usuario);
	
	List<Usuario> recuperarTodosUsuarios();
	
	Boolean verificarUsuario(String emailUsuario, String senhaUsuario);
	
	Usuario recuperarUsuarioEmail(String nomeUsuario);
	
	Usuario recuperarUsuario(Usuario usuario);
	
}
