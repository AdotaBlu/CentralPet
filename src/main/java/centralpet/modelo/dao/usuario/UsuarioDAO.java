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
	
	Long recuperarUsuarioEmail(String nomeUsuario);
	
	Usuario recuperarUsuario(Usuario usuario);
	
	Usuario recuperarUsuarioId(Long id);
	
	Boolean verificarUsuarioConfirmarSenha(String senhaUsuario, Long idUsuario);

	
}
