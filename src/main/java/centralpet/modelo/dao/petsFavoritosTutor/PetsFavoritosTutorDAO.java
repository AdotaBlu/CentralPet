package centralpet.modelo.dao.petsFavoritosTutor;

import java.util.List;

import centralpet.modelo.entidade.favorito.PetsFavoritosTutor;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.usuario.Usuario;

public interface PetsFavoritosTutorDAO {

	void inserirPetsFavoritados(PetsFavoritosTutor petFavoritado);

	void deletarPetsFavoritados(PetsFavoritosTutor petFavoritado);

	void atualizarPetsFavoritados(PetsFavoritosTutor petFavoritado);
	
	List<Pet> petsFavoritadosTutor(Usuario usuario);
}
