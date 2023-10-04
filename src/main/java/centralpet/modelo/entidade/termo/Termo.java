package centralpet.modelo.entidade.termo;

import java.io.Serializable;

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

@Entity
@Table(name = "termo")
public class Termo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_termo")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ong")
	private Ong ong;
	
	@Column(name = "termo", length = 5000, nullable = false, unique = false)
	private String termo;
	
	public Termo () {}
	
	public Termo (Ong ongResponsavel, String termo) {
		setOngResponsavel(ongResponsavel);
		setTermo(termo);
	}
	
	public Termo (Long id, Ong ongResponsavel, String termo) {
		setOngResponsavel(ongResponsavel);
		setTermo(termo);
		setId(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ong getOng() {
		return ong;
	}

	public void setOngResponsavel(Ong ong) {
		this.ong = ong;
	}

	public String getTermo() {
		return termo;
	}

	public void setTermo(String termo) {
		this.termo = termo;
	}
	
	
}
