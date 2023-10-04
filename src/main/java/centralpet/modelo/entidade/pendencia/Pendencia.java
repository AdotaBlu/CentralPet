package centralpet.modelo.entidade.pendencia;

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
import javax.persistence.Table;

import centralpet.modelo.entidade.acompanhamento.Acompanhamento;
import centralpet.modelo.enumeracao.pendencia.StatusPendencia;

@Entity
@Table(name = "pendencia")
public class Pendencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pendencia")
	private long id;

	@Column(name = "data_pendencia", nullable = false, unique = false, updatable = false, insertable = false)
	private LocalDate dataPendencia;

	@Column(name = "motivo_pendencia", length = 50, nullable = false, unique = false)
	private String motivo;

	@Column(name = "observacao_pendencia", length = 50, nullable = false, unique = false)
	private String observacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_acompanhamento")
	private Acompanhamento acompanhamento;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status_pendencia", nullable = true, unique = false)
	private StatusPendencia statusPendencia;

	public Pendencia() {
	}

	public Pendencia(LocalDate dataPendencia, String motivo, String observacao, Acompanhamento acompanhamento,
			StatusPendencia statusPendencia) {
		setDataPendencia(dataPendencia);
		setMotivo(motivo);
		setObservacao(observacao);
		setAcompanhamento(acompanhamento);
		setStatusPendencia(statusPendencia);

	}

	public Pendencia(long id, LocalDate dataPendencia, String motivo, String observacao, Acompanhamento acompanhamento,
			StatusPendencia statusPendencia) {
		setId(id);
		setDataPendencia(dataPendencia);
		setMotivo(motivo);
		setObservacao(observacao);
		setAcompanhamento(acompanhamento);
		setStatusPendencia(statusPendencia);

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDataPendencia() {
		return dataPendencia;
	}

	public void setDataPendencia(LocalDate dataPendencia) {
		this.dataPendencia = dataPendencia;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Acompanhamento getAcompanhamento() {
		return acompanhamento;
	}

	public void setAcompanhamento(Acompanhamento acompanhamento) {
		this.acompanhamento = acompanhamento;
	}

	public StatusPendencia getStatusPendencia() {
		return statusPendencia;
	}

	public void setStatusPendencia(StatusPendencia statusPendencia) {
		this.statusPendencia = statusPendencia;
	}

}
