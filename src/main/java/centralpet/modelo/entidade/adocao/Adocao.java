package centralpet.modelo.entidade.adocao;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import centralpet.modelo.entidade.acompanhamento.Acompanhamento;
import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.termo.Termo;
import centralpet.modelo.entidade.tutor.Tutor;
import centralpet.modelo.enumeracao.adocao.StatusAdocao;

@Entity
@Table(name = "adocao")
public class Adocao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adocao")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pet")
	private Pet pet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ong")
	private Ong ong;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tutor")
	private Tutor tutor;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_termo")
	private Termo termo;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status_adocao", nullable = false, unique = false)
	private StatusAdocao statusAdocao;

	@Column(name = "data_adocao", nullable = false, unique = false)
	private LocalDate dataAdocao;

	//@OneToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "id_acompanhamento", nullable = true)
	//private Acompanhamento acompanhamento;

	public Adocao() {
	}

	public Adocao(Pet pet, Ong ong, Tutor tutor, Termo termo, StatusAdocao statusAdocao, LocalDate dataAdocao,
			Acompanhamento acompanhamento) {
		setPet(pet);
		setOng(ong);
		setTutor(tutor);
		setTermo(termo);
		setStatusAdocao(statusAdocao);
		setDataAdocao(dataAdocao);
//		setAcompanhamento(acompanhamento);
	}

	public Adocao(Long id, Pet pet, Ong ong, Tutor tutor, Termo termo, StatusAdocao statusAdocao, LocalDate dataAdocao,
			Acompanhamento acompanhamento) {
		setId(id);
		setPet(pet);
		setOng(ong);
		setTutor(tutor);
		setTermo(termo);
		setStatusAdocao(statusAdocao);
		setDataAdocao(dataAdocao);
//		setAcompanhamento(acompanhamento);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
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

	public Termo getTermo() {
		return termo;
	}

	public void setTermo(Termo termo) {
		this.termo = termo;
	}

	public StatusAdocao getStatusAdocao() {
		return statusAdocao;
	}

	public void setStatusAdocao(StatusAdocao statusAdocao) {
		this.statusAdocao = statusAdocao;
	}

	public LocalDate getDataAdocao() {
		return dataAdocao;
	}

	public void setDataAdocao(LocalDate dataAdocao) {
		dataAdocao = LocalDate.now();
		this.dataAdocao = dataAdocao;
	}

//	public Acompanhamento getAcompanhamento() {
//		return acompanhamento;
//	}
//
//	public void setAcompanhamento(Acompanhamento acompanhamento) {
//		this.acompanhamento = acompanhamento;
//	}
}
