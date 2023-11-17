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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.tutor.Tutor;
import centralpet.modelo.enumeracao.respostasTermo.respostaQuatro.RespostaQuatro;

@Entity
@Table(name="Respostas_termo")
public class RespostasTermo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_resposta_termo")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_termo")
	private Termo termo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_termo")
	private Ong ong;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Tutor tutor;
	
	//Você já teve experiência prévia com pets? Se sim, por favor, descreva brevemente. *
	private String respostaUm;
	
	//Como é a sua rotina diária? Horários de trabalho, atividades, etc. *
	private String respostaDois;
	
	//Você possui crianças em casa? Se sim, qual a idade delas?
	private String respostaTres;
	
	//Você mora em casa ou apartamento? *
	private RespostaQuatro respostaQuatro;
	
	//Existe um espaço ao ar livre onde o pet poderá brincar? *
	private String respostaCinco;
	
	//Como você planeja cuidar do pet enquanto estiver ausente (trabalho, viagens, etc.)? *
	private String respostaSeis;
	
	//Você compreende que a adoção de um pet é um compromisso de longo prazo, que pode durar muitos anos? *
	private boolean respostaSete;
	
	//Por que você decidiu adotar um pet e o que você espera da relação com ele? *
	private String respostaOito;
	
	public RespostasTermo() {}
	
	public RespostasTermo(Termo termo, Ong ong, Tutor tutor, String respostaUm, String respostaDois, String respostaTres, RespostaQuatro respostaQuatro,
							String respostaCinco, String repostaSeis, boolean respostaSete, String respostaOito) {
		
		setTermo(termo);
		setOng(ong);
		setTutor(tutor);
		setRespostaUm(respostaUm);
		setRespostaDois(respostaDois);
		setRespostaTres(respostaTres);
		setRespostaQuatro(respostaQuatro);
		setRespostaCinco(respostaCinco);
		setRespostaSeis(repostaSeis);
		setRespostaSete(respostaSete);
		setRespostaOito(respostaOito);
	}
	
	public RespostasTermo(Long id, Termo termo, Ong ong, Tutor tutor, String respostaUm, String respostaDois, String respostaTres, RespostaQuatro respostaQuatro,
							String respostaCinco, String repostaSeis, boolean respostaSete, String respostaOito) {

		setId(id);
		setTermo(termo);
		setOng(ong);
		setTutor(tutor);
		setRespostaUm(respostaUm);
		setRespostaDois(respostaDois);
		setRespostaTres(respostaTres);
		setRespostaQuatro(respostaQuatro);
		setRespostaCinco(respostaCinco);
		setRespostaSeis(repostaSeis);
		setRespostaSete(respostaSete);
		setRespostaOito(respostaOito);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Termo getTermo() {
		return termo;
	}

	public void setTermo(Termo termo) {
		this.termo = termo;
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

	public String getRespostaUm() {
		return respostaUm;
	}

	public void setRespostaUm(String respostaUm) {
		this.respostaUm = respostaUm;
	}

	public String getRespostaDois() {
		return respostaDois;
	}

	public void setRespostaDois(String respostaDois) {
		this.respostaDois = respostaDois;
	}

	public String getRespostaTres() {
		return respostaTres;
	}

	public void setRespostaTres(String respostaTres) {
		this.respostaTres = respostaTres;
	}

	public RespostaQuatro getRespostaQuatro() {
		return respostaQuatro;
	}

	public void setRespostaQuatro(RespostaQuatro respostaQuatro) {
		this.respostaQuatro = respostaQuatro;
	}

	public String getRespostaCinco() {
		return respostaCinco;
	}

	public void setRespostaCinco(String respostaCinco) {
		this.respostaCinco = respostaCinco;
	}

	public String getRespostaSeis() {
		return respostaSeis;
	}

	public void setRespostaSeis(String respostaSeis) {
		this.respostaSeis = respostaSeis;
	}

	public boolean getRespostaSete() {
		return respostaSete;
	}

	public void setRespostaSete(boolean respostaSete) {
		this.respostaSete = respostaSete;
	}

	public String getRespostaOito() {
		return respostaOito;
	}

	public void setRespostaOito(String respostaOito) {
		this.respostaOito = respostaOito;
	}
	
	

}
