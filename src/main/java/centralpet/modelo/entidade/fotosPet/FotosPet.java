package centralpet.modelo.entidade.fotosPet;

import java.io.Serializable;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import centralpet.modelo.entidade.pet.Pet;

@Entity
@Table(name="fotos_pet")
public class FotosPet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name="foto_pet")
    private byte[] dadosImagem;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pet")
    private Pet pet;
    
    public FotosPet() {}
    
    public FotosPet(byte[] dadosImagem, Pet pet) {
    	setDadosImagem(dadosImagem);
    	setPet(pet);
    }
    
    public FotosPet(Long id, byte[] dadosImagem, Pet pet) {
    	setId(id);
    	setDadosImagem(dadosImagem);
    	setPet(pet);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getDadosImagem() {
		return dadosImagem;
	}

	public void setDadosImagem(byte[] dadosImagem) {
		this.dadosImagem = dadosImagem;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
    
	public String urlFoto() {
		String urlFoto = ("data:image/jpeg;base64," + Base64.getEncoder().encodeToString(this.dadosImagem));
		return urlFoto;
	}
	
}
