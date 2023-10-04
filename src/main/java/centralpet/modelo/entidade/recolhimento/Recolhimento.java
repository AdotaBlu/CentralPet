package centralpet.modelo.entidade.recolhimento;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.tutor.Tutor;

@Entity
@Table(name = "recolhimento")
public class Recolhimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recolhimento")
	private long id;

	@Column(name = "data_recolhimento", nullable = false, unique = false)
	private LocalDateTime dataRecolhimento;

	@Column(name = "observacao_recolhimento", nullable = false, unique = false)
	private String observacaoRecolhimento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ong")
	private Ong ong;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tutor")
	private Tutor tutor;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pet")
	private Pet pet;

	public Recolhimento() {
	}

	public Recolhimento(Long id, LocalDateTime dataRecolhimento, String observacaoRecolhimento, Ong ong, Tutor tutor,
			Pet pet) {
		setId(id);
		setDataRecolhimento(dataRecolhimento);
		setObservacaoRecolhimento(observacaoRecolhimento);
		setOng(ong);
		setTutor(tutor);
		setPet(pet);

	}

	public Recolhimento(LocalDateTime dataRecolhimento, String observacaoRecolhimento, Ong ong, Tutor tutor, Pet pet) {
		setDataRecolhimento(dataRecolhimento);
		setObservacaoRecolhimento(observacaoRecolhimento);
		setOng(ong);
		setTutor(tutor);
		setPet(pet);

	}

	public long getId() {
		return id;

	}

	public void setId(long id) {
		this.id = id;

	}

	public LocalDateTime getDataRecolhimento() {
		return dataRecolhimento;

	}

	public void setDataRecolhimento(LocalDateTime dataRecolhimento) {
		this.dataRecolhimento = dataRecolhimento;

	}

	public String getObservacaoRecolhimento() {
		return observacaoRecolhimento;

	}

	public void setObservacaoRecolhimento(String observacaoRecolhimento) {
		this.observacaoRecolhimento = observacaoRecolhimento;

	}

	public Ong getOng() {
		return ong;

	}

	public void setOng(Ong ong) {
		this.ong = ong;

	}

	public Tutor getTutor() {
		return tutor;

	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;

	}

	public Pet getPet() {
		return pet;

	}

	public void setPet(Pet pet) {
		this.pet = pet;

	}

}
