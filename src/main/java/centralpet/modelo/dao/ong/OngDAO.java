package centralpet.modelo.dao.ong;

import java.util.List;
import java.util.Optional;

import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.usuario.Usuario;
import centralpet.modelo.enumeracao.endereco.bairro.Bairros;

public interface OngDAO {

	void inserirOng(Ong ong);

	void deletarOng(Ong ong);

	void atualizarOng(Ong ong);

	List<Ong> recuperarTodasOngs();

	List<Ong> recuperarOngNome(String nomeOng);

	List<Ong> recuperarOngBairro(Bairros bairro);
	
	List<Ong> recuperarOngsOpcionalBairroNome(Optional<Bairros> bairro, Optional<String> nome);

	List<Pet> recuperarOngPet(Ong pets);
	
	Ong recuperarOng(Long id);
	
	Ong recuperarOngUsuario(Usuario usuario);
}
