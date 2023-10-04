package centralpet.modelo.dao.endereco;

import java.util.List;

import centralpet.modelo.entidade.endereco.Endereco;
import centralpet.modelo.entidade.usuario.Usuario;

public interface EnderecoDAO {

	void inserirEndereco(Endereco endereco);

	void deletarEndereco(Endereco endereco);

	void atualizarEndereco(Endereco endereco);
	
	List<Endereco> recuperarTodosEnderecos ();
	
	Endereco recuperarEnderecoUsuario (Usuario usuario);
}
