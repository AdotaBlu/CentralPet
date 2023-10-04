package centralpet.modelo.entidade.endereco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.OneToMany;

import javax.persistence.Table;

import centralpet.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long id;
	
	@Column(name = "logradouro_endereco", length = 20, nullable = false, unique = false)
	private String logradouro;
	
	@Column(name = "numero_endereco", nullable = false)
	private short numero;
	
	@Column(name = "bairro_endereco", length = 30, nullable = false, unique = false)
	private String bairro;
	
	@Column(name = "cep_endereco", length = 8, nullable = false, unique = false)
	private String cep;
	
	@Column(name = "ponto_referencia_endereco", length = 45, nullable = true, unique = false)
	private String pontoReferencia;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Endereco () {}
	
	public Endereco (String logradouro, short numero, String bairro, String cep, String pontoReferencia) {
		setLogradouro(logradouro);
		setNumero(numero);
		setBairro(bairro);
		setCep(cep);
		setPontoReferencia(pontoReferencia);
	}
	
	public Endereco (Long id, String logradouro, short numero, String bairro, String cep, String pontoReferencia) {
		setId(id);
		setLogradouro(logradouro);
		setNumero(numero);
		setBairro(bairro);
		setCep(cep);
		setPontoReferencia(pontoReferencia);
	}

	public Long getId () {
		return id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}
	
	public String getLogradouro () {
		return logradouro;
	}
	
	public void setLogradouro (String logradouro) {
		this.logradouro = logradouro;
	}
	
	public short getNumero () {
		return numero;
	}
	
	public void setNumero (short numero) {
		this.numero = numero;
	} 
	
	public String getBairro () {
		return bairro;
	}
	
	public void setBairro (String bairro) {
		this.bairro = bairro;
	}
	
	public String getCep () {
		return cep;
	}
	
	public void setCep (String cep) {
		this.cep = cep;
	}
	
	public String getPontoReferencia () {
		return pontoReferencia;
	}
	
	public void setPontoReferencia (String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void adicionarUsuario (Usuario usuario) {
		this.usuarios.add(usuario);
	}
}


