package centralpet.modelo.entidade.visita;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import centralpet.modelo.entidade.endereco.Endereco;
import centralpet.modelo.enumeracao.visita.StatusVisita;

@Entity
@Table(name = "visita")
public class Visita implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_visita")
	private Long id;
	
	@Column(name = "horario_visita", nullable = false, unique = false)
	private LocalDateTime horarioVisita;
	
	@Column(name = "observacao_visita", length = 2000, nullable = true, unique = false)
	private String observacaoVisita;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status_visita", nullable = false, unique = false)
	private StatusVisita statusVisita;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	public Visita(){}
	
	public Visita(LocalDateTime horarioVisita, String observacaoVisita, Endereco endereco, StatusVisita statusVisita){
		setHorarioVisita(horarioVisita);
		setObservacaoVisita(observacaoVisita);
		setEndereco(endereco);
		setStatusVisita(statusVisita);
	}
	
	public Visita(Long id, LocalDateTime horarioVisita, String observacaoVisita, Endereco endereco, StatusVisita statusVisita){
		setId(id);
		setHorarioVisita(horarioVisita);
		setObservacaoVisita(observacaoVisita);
		setEndereco(endereco);
		setStatusVisita(statusVisita);
	}
	
	public LocalDateTime getHorarioVisita() {
		return horarioVisita;
	}

	public void setHorarioVisita(LocalDateTime horarioVisita) {
		this.horarioVisita = horarioVisita;
	}

	public String getObservacaoVisita() {
		return observacaoVisita;
	}

	public void setObservacaoVisita(String observacaoVisita) {
		this.observacaoVisita = observacaoVisita;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusVisita getStatusVisita() {
		return statusVisita;
	}

	public void setStatusVisita(StatusVisita statusVisita) {
		this.statusVisita = statusVisita;
	}
	
	
}
