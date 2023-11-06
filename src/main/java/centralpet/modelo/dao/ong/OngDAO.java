package centralpet.modelo.dao.ong;

import java.util.List;

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

	List<Pet> recuperarOngPet(Ong pets);
	
	Ong recuperarOng(Long id);
	
	Ong recuperarOngUsuario(Usuario usuario);
}
