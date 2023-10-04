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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import centralpet.modelo.entidade.endereco.Endereco;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@Column(name = "data_cadastro_usuario", nullable = false, unique = false)
	private LocalDate dataCadastro;

	@Column(name = "data_alteracao_cadastro_usuario", nullable = true, unique = false)
	private LocalDate dataAlteracaoCadastro;

	public Usuario () {}
	
	public Usuario (String nome, Endereco endereco) {
		setNome(nome);
		setEndereco(endereco);
		setDataCadastro(dataCadastro);
		setDataAlteracaoCadastro(dataAlteracaoCadastro);
	}
	
	public Usuario (Long id, String nome, Endereco endereco) {
		setId(id);
		setNome(nome);
		setEndereco(endereco);
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
	
	
}
