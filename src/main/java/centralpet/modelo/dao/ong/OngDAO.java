package centralpet.modelo.dao.ong;

import java.util.List;

import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.pet.Pet;

public interface OngDAO {

	void inserirOng(Ong ong);

	void deletarOng(Ong ong);

	void atualizarOng(Ong ong);

	List<Ong> recuperarTodasOngs();

	List<Ong> recuperarOngNome(String nomeOng);

	List<Ong> recuperarOngBairro(String localidade);

	List<Pet> recuperarOngPet(Ong pets);
}
