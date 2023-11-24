package centralpet.modelo.entidade.pet;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;

import java.time.Period;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Base64;
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
import javax.persistence.Table;

import centralpet.modelo.entidade.fotosPet.FotosPet;
import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.enumeracao.pet.castrado.Castrado;
import centralpet.modelo.enumeracao.pet.especie.EspeciePet;
import centralpet.modelo.enumeracao.pet.estado.EstadoPet;
import centralpet.modelo.enumeracao.pet.pelagem.PelagemPet;
import centralpet.modelo.enumeracao.pet.porte.PortePet;
import centralpet.modelo.enumeracao.pet.sexo.SexoPet;

@Entity
@Table(name = "pet")
public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pet")
	private Long id;

	@Column(name = "nome_pet", length = 45, nullable = false, unique = false)
	private String nome;

	@Column(name = "vacinas_pet", length = 45, nullable = false, unique = false)
	private String vacinas;

	@Column(name = "descricao_pet", length = 60, nullable = false, unique = false)
	private String descricao;

	@Column(name = "data_nascimento_pet", nullable = false, unique = false)
	private LocalDate dataNascimento;

	@Column(name = "idade_pet", nullable = false, unique = false)
	private float idade;

	@Column(name = "peso_pet", nullable = false, unique = false)
	private Double peso;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ong", nullable = false)
	private Ong ong;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "porte_pet", nullable = false, unique = false)
	private PortePet portePet;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "especie_pet", nullable = false, unique = false)
	private EspeciePet especiePet;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "sexo_pet", nullable = false, unique = false)
	private SexoPet sexoPet;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "estado_pet", nullable = false, unique = false)
	private EstadoPet estadoPet;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "pelagem_pet", nullable = false, unique = false)
	private PelagemPet pelagemPet;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "castrado", nullable = false, unique = false)
	private Castrado castrado;
	

	@OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FotosPet> fotos = new ArrayList<>();

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_acompanhamento", nullable = true)
//	private Acompanhamento acompanhamento;

	public Pet() {
	}

	public Pet(String nome, String vacinas, String descricao, LocalDate dataNascimento, Double peso,
			Ong ong, PortePet portePet, EspeciePet especiePet, SexoPet sexoPet,
			EstadoPet estadoPet, PelagemPet pelagemPet, Castrado castrado) {
		setNome(nome);
		setVacinas(vacinas);
		setDescricao(descricao);
		setPeso(peso);
		setOng(ong);
		setPortePet(portePet);
		setEspeciePet(especiePet);
		setSexoPet(sexoPet);
		setEstadoPet(estadoPet);
		setPelagemPet(pelagemPet);
		setCastrado(castrado);
		setDataNascimento(dataNascimento);
		setIdade(dataNascimento);
//		setAcompanhamento(acompanhamento);
	}


	public Pet(Long id, String nome, String vacinas, String descricao, LocalDate dataNascimento,
			Double peso, Ong ong, PortePet portePet, EspeciePet especiePet, SexoPet sexoPet,
			EstadoPet estadoPet, PelagemPet pelagemPet, Castrado castrado) {
		setId(id);
		setNome(nome);
		setVacinas(vacinas);
		setDescricao(descricao);
		setPeso(peso);
		setOng(ong);
		setPortePet(portePet);
		setEspeciePet(especiePet);
		setSexoPet(sexoPet);
		setEstadoPet(estadoPet);
		setPelagemPet(pelagemPet);
		setCastrado(castrado);
		setDataNascimento(dataNascimento);
		setIdade(dataNascimento);
		setFotos(fotos);
//		setAcompanhamento(acompanhamento);
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVacinas() {
		return vacinas;
	}

	public void setVacinas(String vacinas) {
		this.vacinas = vacinas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getIdade() {
		return idade;
	}

	public void setIdade(LocalDate dataNascimento) {
		this.idade = idadeFormatada();
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

	public PortePet getPortePet() {
		return portePet;
	}

	public void setPortePet(PortePet portePet) {
		this.portePet = portePet;
	}

	public EspeciePet getEspeciePet() {
		return especiePet;
	}

	public void setEspeciePet(EspeciePet especiePet) {
		this.especiePet = especiePet;
	}

	public SexoPet getSexoPet() {
		return sexoPet;
	}

	public void setSexoPet(SexoPet sexoPet) {
		this.sexoPet = sexoPet;
	}

	public EstadoPet getEstadoPet() {
		return estadoPet;
	}

	public void setEstadoPet(EstadoPet estadoPet) {
		this.estadoPet = estadoPet;
	}

	public PelagemPet getPelagemPet() {
		return pelagemPet;
	}

	public void setPelagemPet(PelagemPet pelagemPet) {
		this.pelagemPet = pelagemPet;
	}
	
	public Castrado getCastrado() {
		return castrado;
	}

	public void setCastrado(Castrado castrado) {
		this.castrado = castrado;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<FotosPet> getFotos() {
		return fotos;
	}

	public void setFotos(List<FotosPet> fotosPet) {
		this.fotos = fotosPet;
	}

	public void adicionarFoto(FotosPet foto) {
		this.fotos.add(foto); 
	}

	public void removerFoto(FotosPet foto) {
		this.fotos.remove(foto);
	}

	public String fotoPrincipalPet() {
		String urlFotoPrincipal = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(this.fotos.get(0).getDadosImagem());
		return urlFotoPrincipal;
	}
	
	public float idadeFormatada() {
		
		LocalDate dataAtual = LocalDate.now();
	    long meses = ChronoUnit.MONTHS.between(dataNascimento, dataAtual);
	    double anos = meses / 12.0;
	    DecimalFormat df = new DecimalFormat("#0.0");
	    String resultadoString = df.format(anos);
	    resultadoString = resultadoString.replace(',', '.');
	    float idadeFormatada = Float.parseFloat(resultadoString);
	    System.out.println(idadeFormatada); 
		return idadeFormatada;
	}

//	public Acompanhamento getAcompanhamento() {
//		return acompanhamento;
//	}
//
//	public void setAcompanhamento(Acompanhamento acompanhamento) {
//		this.acompanhamento = acompanhamento;
//	}

}
