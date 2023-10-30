package centralpet.modelo.entidade.avaliacao;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.tutor.Tutor;

@Entity 
@Table(name ="avaliacao")
public class Avaliacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_avaliacao")
	private Long id;
	
	@Column(name ="depoimento_avaliacao", nullable = true, unique = false, length = 2000)
	private String depoimento;
	
	@Column(name ="nota_avaliacao", nullable = false, unique = false)
	private Byte nota;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	private Ong ong;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	private Tutor tutor;
	
	@Column(name="data_avaliacao", nullable = true, unique = false)
	private LocalDate dataAvaliacao;
	
	public Avaliacao() {}
	
	public Avaliacao(String depoimento, Byte nota, Ong ong, Tutor tutor) {
		setDepoimento(depoimento);
		setNota(nota);
		setOng(ong);
		setTutor(tutor);
		setDataAvaliacao(dataAvaliacao);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepoimento() {
		return depoimento;
	}

	public void setDepoimento(String depoimento) {
		this.depoimento = depoimento;
	}

	public Byte getNota() {
		return nota;
	}

	public void setNota(Byte nota) {
		this.nota = nota;
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

	public LocalDate getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(LocalDate dataAvaliacao) {
		dataAvaliacao = LocalDate.now();
		this.dataAvaliacao = dataAvaliacao;
	}
	
}
