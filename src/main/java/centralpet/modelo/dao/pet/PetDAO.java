package centralpet.modelo.dao.pet;

import java.util.List;
import java.util.Optional;

import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.enumeracao.pet.especie.EspeciePet;
import centralpet.modelo.enumeracao.pet.estado.EstadoPet;
import centralpet.modelo.enumeracao.pet.pelagem.PelagemPet;
import centralpet.modelo.enumeracao.pet.porte.PortePet;
import centralpet.modelo.enumeracao.pet.sexo.SexoPet;

public interface PetDAO {

	void inserirPet(Pet pet);
	
	void deletarPet(Pet pet);
	
	void atualizarPet(Pet pet);
	
	List<Pet> recuperarTodosPets();
	
	List<Pet> recuperarTodosPetsAtivos();
	
	List<Pet> recuperarPetsOng(Ong ong);
	
	List<Pet> recuperarPetsAtivosOng(Ong ong);
	
	List<Pet> filtrarBuscaPet(Optional<EspeciePet> especiePet, Optional<PortePet> portePet,
			Optional<SexoPet> sexoPet, Optional<PelagemPet> pelagemPet, Optional<EstadoPet> estadoPet);
	
	List<Pet> filtrarPetsEstado(Optional<EstadoPet> estadoPet, Ong ong);
	
	Pet recuperarPet(Long id);
	
	List<Pet> recuperarPetsFavoritosTutor(Long idTutor);
	
	int recuperarSomaPetsDaOng(Long idOng);
	
	int recuperarSomaPetsTodos();
}
