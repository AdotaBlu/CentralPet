package centralpet.modelo.entidade.usuario;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import centralpet.modelo.entidade.endereco.Endereco;
import centralpet.modelo.entidade.ong.Ong;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")

public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "nome_usuario", length = 45, nullable = false, unique = false)
	private String nome;
	
	@Column(name = "senha_usuario", length = 30, nullable = false, unique = false)
	private String senha;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	@Lob
	@Column(name="foto_perfil_usuario", nullable = true, unique = false)
	private byte[] fotoPerfil;

	@Column(name = "data_cadastro_usuario", nullable = true, unique = false, updatable = false)
	private LocalDate dataCadastro;

	@Column(name = "data_alteracao_cadastro_usuario", nullable = true, unique = false)
	private LocalDate dataAlteracaoCadastro;

	public Usuario () {}
	
	public Usuario (Long id) {
		setId(id);
	}
	
	public Usuario (String nome, Endereco endereco, String senha, byte[] fotoPerfil) {
		setNome(nome);
		setEndereco(endereco);
		setDataCadastro(dataCadastro);
		setDataAlteracaoCadastro(dataAlteracaoCadastro);
		setSenha(senha);
		setFotoPerfil(fotoPerfil);
	}
	
	public Usuario (Long id, String nome, Endereco endereco, byte[] fotoPerfil, String senha) {
		setId(id);
		setNome(nome);
		setEndereco(endereco);
		setDataAlteracaoCadastro(dataAlteracaoCadastro);
		setFotoPerfil(fotoPerfil);
		setSenha(senha);
	}
	
	public Usuario (Long id, String senha) {
		setId(id);
		setSenha(senha);
		setDataAlteracaoCadastro(dataAlteracaoCadastro);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public LocalDate getDataCadastro () {
		return dataCadastro;
	}
	
	public void setDataCadastro (LocalDate dataCadastro) {
		dataCadastro = LocalDate.now();
		this.dataCadastro = dataCadastro;
	}
	
	public LocalDate getDataAlteracaoCadastro () {
		return dataAlteracaoCadastro;
	}
	
	public void setDataAlteracaoCadastro (LocalDate dataAlteracaoCadastro) {
		dataAlteracaoCadastro = LocalDate.now();
		this.dataAlteracaoCadastro = dataAlteracaoCadastro;
	} 
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public byte[] getfotoPerfil() {
		return fotoPerfil;
	}
	
	public void setFotoPerfil(byte[] fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	
	  @Override
	    public boolean equals(Object obj) {
	        if(!(obj instanceof Ong)) 
	        	return false; 

	        if(obj == this) 
	        	return true;
	        
	        Usuario usuario = (Usuario) obj; 

	        return this.id == usuario.getId() &&
	                this.nome.equals(usuario.getNome());
	    }   
	
	
}
