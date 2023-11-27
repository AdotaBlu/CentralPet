package centralpet.modelo.dao.petsFavoritosTutor;



import centralpet.modelo.entidade.favorito.PetsFavoritosTutor;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.tutor.Tutor;


public interface PetsFavoritosTutorDAO {

	void inserirPetsFavoritados(PetsFavoritosTutor petFavoritado);

	void deletarPetsFavoritados(PetsFavoritosTutor petFavoritado);

	void atualizarPetsFavoritados(PetsFavoritosTutor petFavoritado);
	
	PetsFavoritosTutor recuperarFavorito(Pet pet, Tutor tutor);
}
