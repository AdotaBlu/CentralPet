 package centralpet;

import java.time.LocalDate;

import centralpet.modelo.dao.adocao.AdocaoDAO;
import centralpet.modelo.dao.adocao.AdocaoDAOImpl;
import centralpet.modelo.dao.contato.ContatoDAO;
import centralpet.modelo.dao.contato.ContatoDAOImpl;
import centralpet.modelo.dao.endereco.EnderecoDAO;
import centralpet.modelo.dao.endereco.EnderecoDAOImpl;
import centralpet.modelo.dao.ong.OngDAO;
import centralpet.modelo.dao.ong.OngDAOImpl;
import centralpet.modelo.dao.pet.PetDAO;
import centralpet.modelo.dao.pet.PetDAOImpl;
import centralpet.modelo.dao.petsFavoritosTutor.PetsFavoritosTutorDAO;
import centralpet.modelo.dao.petsFavoritosTutor.PetsFavoritosTutorDAOImpl;
import centralpet.modelo.dao.termo.TermoDAO;
import centralpet.modelo.dao.termo.TermoDAOImpl;
import centralpet.modelo.dao.tutor.TutorDAO;
import centralpet.modelo.dao.tutor.TutorDAOImpl;
import centralpet.modelo.entidade.adocao.Adocao;
import centralpet.modelo.entidade.contato.Contato;
import centralpet.modelo.entidade.endereco.Endereco;
import centralpet.modelo.entidade.favorito.PetsFavoritosTutor;
import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.termo.Termo;
import centralpet.modelo.entidade.tutor.Tutor;
import centralpet.modelo.enumeracao.adocao.StatusAdocao;
import centralpet.modelo.enumeracao.genero.GeneroTutor;
import centralpet.modelo.enumeracao.pet.especie.EspeciePet;
import centralpet.modelo.enumeracao.pet.estado.EstadoPet;
import centralpet.modelo.enumeracao.pet.pelagem.PelagemPet;
import centralpet.modelo.enumeracao.pet.porte.PortePet;
import centralpet.modelo.enumeracao.pet.sexo.SexoPet;
import centralpet.modelo.enumeracao.pet.status.StatusPet;

public class Principal {

	public static void main(String[] args) {

		EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
		TutorDAO tutorDAO = new TutorDAOImpl();
		ContatoDAO contatoDAO = new ContatoDAOImpl();
		OngDAO ongDAO = new OngDAOImpl();
		PetDAO petDAO = new PetDAOImpl();
		TermoDAO termoDAO = new TermoDAOImpl();
		AdocaoDAO adocaoDAO = new AdocaoDAOImpl();
		PetsFavoritosTutorDAO petsFavoritosTutorDAO = new PetsFavoritosTutorDAOImpl();

		String logradouro = "rua XV setembro";
		short numero = 356;
		String bairro = "Centro";
		String cep = "12345221";

		Endereco endereco = new Endereco();

		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setBairro(bairro);
		endereco.setCep(cep);

		enderecoDAO.inserirEndereco(endereco);

		Endereco endereco2 = new Endereco();

		String logradouro2 = "rua II setembro";
		short numero2 = 358;
		String bairro2 = "Centro";
		String cep2 = "12345222";

		endereco2.setLogradouro(logradouro2);
		endereco2.setNumero(numero2);
		endereco2.setBairro(bairro2);
		endereco2.setCep(cep2);

		enderecoDAO.inserirEndereco(endereco2);

		Tutor tutor = new Tutor();

		String nome = "Joao";

		String cpf = "12345678911";
		LocalDate datanascimento = LocalDate.of(2000, 2, 1);
		GeneroTutor generoTutor = GeneroTutor.MASCULINO;
		LocalDate dataCadastro = LocalDate.now();
		String senha = "12345";

		tutor.setNome(nome);
		tutor.setEndereco(endereco);
		tutor.setSenha(senha);
		tutor.setDataCadastro(dataCadastro);
		tutor.setCpf(cpf);
		tutor.setDataNascimento(datanascimento);
		tutor.setGeneroTutor(generoTutor);

		tutorDAO.inserirTutor(tutor);
		

		/*
		 * Tutor tutor2 = new Tutor();
		 * 
		 * String nome2 = "Hermes";
		 * 
		 * String cpf2 = "98765432134"; LocalDate datanascimento2 = LocalDate.of(1999,
		 * 3, 3); GeneroTutor generoTutor2 = GeneroTutor.MASCULINO; LocalDate
		 * dataCadastro2 = LocalDate.now();
		 * 
		 * tutor2.setNome(nome2); tutor2.setEndereco(endereco);
		 * tutor2.setDataCadastro(dataCadastro2); tutor2.setCpf(cpf2);
		 * tutor2.setDataNascimento(datanascimento2);
		 * tutor2.setGeneroTutor(generoTutor2);
		 * 
		 * tutorDAO.inserirTutor(tutor2);
		 */

		Contato contato = new Contato();

		String email = "aa@aa.com";
		String telefone = "47123456789";

		contato.setEmail(email);
		contato.setTelefone(telefone);
		contato.setUsuario(tutor);

		contatoDAO.inserirContato(contato);

		Ong ong = new Ong();

		String nomeOng = "Ong Shippuden";
		LocalDate dataCadastro3 = LocalDate.now();
		String cnpj = "12345678911234";

		ong.setNome(nomeOng);
		ong.setEndereco(endereco2);
		ong.setSenha("123");
		ong.setCnpj(cnpj);
		ong.setDataCadastro(dataCadastro3);
		ong.setId(1L);;
		ongDAO.inserirOng(ong);
		
		/*
		 * Ong ong2 = new Ong();
		 * 
		 * String nomeOng2 = "Ong Jungkook"; LocalDate dataCadastro4 = LocalDate.now();
		 * String cnpj4 = "12355678911234";
		 * 
		 * ong2.setNome(nomeOng2); ong2.setEndereco(endereco2); ong2.setCnpj(cnpj4);
		 * ong2.setDataCadastro(dataCadastro4); ongDAO.inserirOng(ong2);
		 */

		Pet pet = new Pet();

		String nomePet = "Java";
		String vacinas = "Raiva";
		String descricao = "Fofo, amigavel e companheiro";
		StatusPet statusPet = StatusPet.DISPONIVEL;
		PortePet portePet = PortePet.PEQUENO;
		EspeciePet especiePet = EspeciePet.CACHORRO;
		SexoPet sexoPet = SexoPet.FEMEA;
		EstadoPet estadoPet = EstadoPet.ATIVO;
		PelagemPet pelagempet = PelagemPet.CURTO;

		pet.setNome(nomePet);
		pet.setVacinas(vacinas);
		pet.setDescricao(descricao);
		pet.setIdade((byte) 0);
		pet.setOng(ong);
		pet.setStatusPet(statusPet);
		pet.setPortePet(portePet);
		pet.setEspeciePet(especiePet);
		pet.setSexoPet(sexoPet);
		pet.setEstadoPet(estadoPet);
		pet.setPelagemPet(pelagempet);

		
		petDAO.inserirPet(pet);
		
		/*
		 * Pet pet2 = new Pet(); String nomePet2 = "Qiero"; String vacinas2 =
		 * "Raiva, fungo"; String descricao2 = "Fofo e dorminhoco"; StatusPet statusPet2
		 * = StatusPet.DISPONIVEL; PortePet portePet2 = PortePet.MEDIO; EspeciePet
		 * especiePet2 = EspeciePet.CACHORRO; SexoPet sexoPet2 = SexoPet.MACHO;
		 * 
		 * pet2.setNome(nomePet2); pet2.setVacinas(vacinas2);
		 * pet2.setDescricao(descricao2); pet2.setIdade((byte) 0); pet2.setOng(ong2);
		 * pet2.setStatusPet(statusPet2); pet2.setPortePet(portePet2);
		 * pet2.setEspeciePet(especiePet2); pet2.setSexoPet(sexoPet2);
		 * 
		 * 
		 * petDAO.inserirPet(pet2);
		 */

		Termo termo = new Termo();

		String termoOng = "TERMO RESPONSAVEL";

		termo.setOngResponsavel(ong);
		termo.setTermo(termoOng);

		termoDAO.inserirTermo(termo);
		
		/*
		 * Termo termo2 = new Termo();
		 * 
		 * String termoOng2 = "TERMO RESPONSAVEL 2";
		 * 
		 * termo2.setOngResponsavel(ong); termo2.setTermo(termoOng2);
		 * 
		 * termoDAO.inserirTermo(termo2);
		 */

		Adocao adocao = new Adocao();

		StatusAdocao statusAdocao = StatusAdocao.PENDENTE;
		LocalDate dataAdocao = LocalDate.of(2023, 8, 20);

		adocao.setPet(pet);
		adocao.setOng(ong);
		adocao.setTutor(tutor);
		adocao.setTermo(termo);
		adocao.setStatusAdocao(statusAdocao);
		adocao.setDataAdocao(dataAdocao);
		
		adocaoDAO.inserirAdocao(adocao);
		
		/*
		 * Adocao adocao2 = new Adocao();
		 * 
		 * StatusAdocao statusAdocao2 = StatusAdocao.PENDENTE; LocalDate dataAdocao2 =
		 * LocalDate.of(2023, 8, 21);
		 * 
		 * adocao2.setPet(pet2); adocao2.setOng(ong2); adocao2.setTutor(tutor2);
		 * adocao2.setTermo(termo2); adocao2.setStatusAdocao(statusAdocao2);
		 * adocao2.setDataAdocao(dataAdocao2);
		 * 
		 * adocaoDAO.inserirAdocao(adocao2);
		 */
		
		PetsFavoritosTutor petsFav = new PetsFavoritosTutor();
		
		petsFav.setUsuario(tutor);
		petsFav.setPet(pet);
		
		petsFavoritosTutorDAO.inserirPetsFavoritados(petsFav);
		
		Tutor tutorteste = null;
		
		tutorteste = tutorDAO.recuperarTutor(1L);
		
		System.out.println(tutorteste.getNome());
			
			
		
		
		
	} 
}
