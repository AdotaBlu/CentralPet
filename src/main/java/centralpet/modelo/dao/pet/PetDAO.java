package centralpet.modelo.dao.pet;

import java.util.List;
import java.util.Optional;

import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.enumeracao.pet.especie.EspeciePet;
import centralpet.modelo.enumeracao.pet.pelagem.PelagemPet;
import centralpet.modelo.enumeracao.pet.porte.PortePet;
import centralpet.modelo.enumeracao.pet.sexo.SexoPet;

public interface PetDAO {

	void inserirPet(Pet pet);
	
	void deletarPet(Pet pet);
	
	void atualizarPet(Pet pet);
	
	List<Pet> recuperarTodosPets();
	
	List<Pet> recuperarPetsOng(Ong ong);
	
	List<Pet> recuperarPetsPorte(Pet pet);
	
	List<Pet> recuperarPetsSexo(Pet pet);
	
	List<Pet> recuperarPetsEspecie(Pet pet);
	
	List<Pet> recuperarPetsStatus(Pet pet);
	
	List<Pet> recuperarPetsPelagem(Pet pet);
	
	List<Pet> recuperarPetsEstado(Pet pet);
	
	List<Pet> filtrarBuscaPet(Optional<EspeciePet> especiePet, Optional<PortePet> portePet,
			Optional<SexoPet> sexoPet, Optional<PelagemPet> pelagemPet);
	
	Pet recuperarPet(Long id);
}
