package centralpet.modelo.entidade.favorito;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.usuario.Usuario;

@Entity
@Table(name="pets_favoritos_tutor")
public class PetsFavoritosTutor implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PetsFavoritosTutorId id = new PetsFavoritosTutorId();
	
	@ManyToOne
	@MapsId("tutorId")
	private Usuario usuario;
	
	@ManyToOne
	@MapsId("petId")
	private Pet pet;
	
	public PetsFavoritosTutor() {}

	public PetsFavoritosTutor(Usuario usuario, Pet pet) {
		setUsuario(usuario);
		setPet(pet);
	}
	
	public PetsFavoritosTutor(PetsFavoritosTutorId id,Usuario usuario, Pet pet) {
		setId(id);
		setUsuario(usuario);
		setPet(pet);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public PetsFavoritosTutorId getId() {
		return id;
	}

	public void setId(PetsFavoritosTutorId id) {
		this.id = id;
	}
	
	
	
}
