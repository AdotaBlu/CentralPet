package centralpet.modelo.dao.endereco;

import centralpet.modelo.entidade.endereco.Endereco;
import centralpet.modelo.entidade.usuario.Usuario;

public interface EnderecoDAO {

	void inserirEndereco(Endereco endereco);

	void deletarEndereco(Endereco endereco);

	void atualizarEndereco(Endereco endereco);
		
	Endereco recuperarEnderecoUsuario (Usuario usuario);
	
	Endereco recuperarEndereco(Long id);
}
