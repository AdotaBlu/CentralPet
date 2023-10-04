package centralpet.modelo.entidade.acompanhamento;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import centralpet.modelo.entidade.adocao.Adocao;
import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.pendencia.Pendencia;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.tutor.Tutor;
import centralpet.modelo.enumeracao.acompanhamento.StatusAcompanhamento;

@Entity
@Table(name = "acompanhamento")
public class Acompanhamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_acompanhamento")
	private Long id;

	@Column(name = "video_pet", nullable = false, unique = false, updatable = false, insertable = false)
	private byte[] video;

	@Column(name = "video_pet", nullable = false, unique = false, updatable = false, insertable = false)
	private byte[] foto;

	@Column(name = "situacao_pet", length = 50, nullable = false, unique = false)
	private String situacaoPet;

	@Column(name = "data_envio_video", nullable = false, unique = false, updatable = false, insertable = false)
	private LocalDate dataEnvioVideo;

	@Column(name = "data_envio_foto", nullable = false, unique = false, updatable = false, insertable = false)
	private LocalDate dataEnvioFoto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ong")
	private Ong ong;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tutor", nullable = true)
	private Tutor tutor;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pet", nullable = true)
	private Pet pet;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_adocao", nullable = true)
	private Adocao adocao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "acompanhamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pendencia> historicoAcompanhamento = new ArrayList<>();

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status_acompanhamento", nullable = true, unique = false)
	private StatusAcompanhamento statusAcompanhamento;

	public Acompanhamento() {
	}

	// Utilizado quando manda as informações para o banco
	public Acompanhamento(byte video[], byte foto[], String observacao, LocalDate dataEnvioVideo,
			LocalDate dataEnvioFoto, StatusAcompanhamento statusAcompanhamento) {
		setVideo(video);
		setFoto(foto);
		setSituacaoPet(situacaoPet);
		setDataEnvioVideo(dataEnvioVideo);
		setDataEnvioFoto(dataEnvioFoto);
		setOng(ong);
		setTutor(tutor);
		setPet(pet);
		setAdocao(adocao);
		setStatusAcompanhamento(statusAcompanhamento);
	}

	// Utilizado quando recebe as informações para o banco
	public Acompanhamento(Long id, byte video[], byte foto[], String observacao, LocalDate dataEnvioVideo,
			LocalDate dataEnvioFoto, Adocao adocao, StatusAcompanhamento statusAcompanhamento) {
		setId(id);
		setVideo(video);
		setFoto(foto);
		setSituacaoPet(situacaoPet);
		setDataEnvioVideo(dataEnvioVideo);
		setDataEnvioFoto(dataEnvioFoto);
		setOng(ong);
		setTutor(tutor);
		setPet(pet);
		setAdocao(adocao);
		setStatusAcompanhamento(statusAcompanhamento);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte video[]) {
		this.video = video;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte foto[]) {
		this.foto = foto;
	}

	public String getSituacaoPet() {
		return situacaoPet;
	}

	public void setSituacaoPet(String observacao) {
		this.situacaoPet = observacao;
	}

	public LocalDate getDataEnvioVideo() {
		return dataEnvioVideo;
	}

	public void setDataEnvioVideo(LocalDate dataEnvioVideo) {
		this.dataEnvioVideo = dataEnvioVideo;
	}

	public LocalDate getDataEnvioFoto() {
		return dataEnvioFoto;
	}

	public void setDataEnvioFoto(LocalDate dataEnvioFoto) {
		this.dataEnvioFoto = dataEnvioFoto;
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

	public Adocao getAdocao() {
		return adocao;
	}

	public void setAdocao(Adocao adocao) {
		this.adocao = adocao;
	}

	public List<Pendencia> getPendencia() {
		return historicoAcompanhamento;
	}

	public StatusAcompanhamento getStatusAcompanhamento() {
		return statusAcompanhamento;
	}

	public void setStatusAcompanhamento(StatusAcompanhamento statusAcompanhamento) {
		this.statusAcompanhamento = statusAcompanhamento;
	}

	public void adicionarPendencia(Pendencia pendencia) {
		this.historicoAcompanhamento.add(pendencia);
	}

	public void RemkoverPendencia(Pendencia pendencia) {
		this.historicoAcompanhamento.remove(pendencia);
	}
}
