package centralpet.modelo.entidade.contato;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import centralpet.modelo.entidade.usuario.Usuario;


@Entity
@Table(name = "contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private Long id;
	
	@Column(name = "email_contato", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "telefone_contato", length = 11, nullable = false, unique = true)
	private String telefone;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public Contato () {}
	
	public Contato (String email, String telefone, Usuario usuario) {
		setEmail(email);
		setTelefone(telefone);
		setUsuario(usuario);
	}
	
	public Contato (Long id, String email, String telefone, Usuario usuario) {
		setId(id);
		setEmail(email);
		setTelefone(telefone);
		setUsuario(usuario);
	}
	
	public Long getId () {
		return id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}
	
	public String getEmail () {
		return email;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	public String getTelefone () {
		return telefone;
	}
	
	public void setTelefone (String telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
