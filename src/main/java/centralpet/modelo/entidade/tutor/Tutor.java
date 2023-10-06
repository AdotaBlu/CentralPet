package centralpet.modelo.entidade.tutor;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import centralpet.modelo.entidade.acompanhamento.Acompanhamento;
import centralpet.modelo.entidade.adocao.Adocao;
import centralpet.modelo.entidade.endereco.Endereco;
import centralpet.modelo.entidade.usuario.Usuario;
import centralpet.modelo.enumeracao.genero.GeneroTutor;

@Entity
@Table(name = "tutor")
public class Tutor extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "cpf_tutor", length = 11, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "senha_tutor", length = 30, nullable = false, unique = true)
	private String senha;

	@Column(name = "data_nascimento_tutor", nullable = false, unique = false)
	private LocalDate dataNascimento;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "genero_tutor", nullable = false, unique = false)
	private GeneroTutor generoTutor;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Adocao> adocoes = new ArrayList<>();

	//@OneToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "id_acompanhamento", nullable = true)
	//private Acompanhamento acompanhamento;

	public Tutor() {
	}

	public Tutor(String nome, Endereco endereco, String cpf, LocalDate datanascimento, GeneroTutor generoTutor,
			Acompanhamento acompanhamento) {
		super(nome, endereco);
		setCpf(cpf);
		setDataNascimento(datanascimento);
		setGeneroTutor(generoTutor);
		//setAcompanhamento(acompanhamento);
	}

	public Tutor(String nome, Endereco endereco, Long id, String cpf, LocalDate datanascimento, GeneroTutor generoTutor,
			Acompanhamento acompanhamento) {
		super(nome, endereco);
		setId(id);
		setCpf(cpf);
		setDataNascimento(datanascimento);
		setGeneroTutor(generoTutor);
		//setAcompanhamento(acompanhamento);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public GeneroTutor getGeneroTutor() {
		return generoTutor;
	}

	public void setGeneroTutor(GeneroTutor generoTutor) {
		this.generoTutor = generoTutor;
	}

	public List<Adocao> getAdocoes() {
		return adocoes;
	}

	public void adocaoFeita(Adocao adocao) {
		this.adocoes.add(adocao);
	}

	public void adocaoDesfeita(Adocao adocao) {
		this.adocoes.remove(adocao);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

//	public Acompanhamento getAcompanhamento() {
//		return acompanhamento;
//	}
//
//	public void setAcompanhamento(Acompanhamento acompanhamento) {
//		this.acompanhamento = acompanhamento;
//	}
}
