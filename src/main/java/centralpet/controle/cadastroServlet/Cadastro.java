package centralpet.controle.cadastroServlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.apache.tika.Tika;

import centralpet.modelo.dao.adocao.AdocaoDAO;
import centralpet.modelo.dao.adocao.AdocaoDAOImpl;
import centralpet.modelo.dao.contato.ContatoDAO;
import centralpet.modelo.dao.contato.ContatoDAOImpl;
import centralpet.modelo.dao.endereco.EnderecoDAO;
import centralpet.modelo.dao.endereco.EnderecoDAOImpl;
import centralpet.modelo.dao.fotosPet.FotosPetDAO;
import centralpet.modelo.dao.fotosPet.FotosPetDAOImpl;
import centralpet.modelo.dao.ong.OngDAO;
import centralpet.modelo.dao.ong.OngDAOImpl;
import centralpet.modelo.dao.pet.PetDAO;
import centralpet.modelo.dao.pet.PetDAOImpl;
import centralpet.modelo.dao.termo.TermoDAO;
import centralpet.modelo.dao.termo.TermoDAOImpl;
import centralpet.modelo.dao.tutor.TutorDAO;
import centralpet.modelo.dao.tutor.TutorDAOImpl;
import centralpet.modelo.entidade.adocao.Adocao;
import centralpet.modelo.entidade.contato.Contato;
import centralpet.modelo.entidade.endereco.Endereco;
import centralpet.modelo.entidade.fotosPet.FotosPet;
import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.termo.Termo;
import centralpet.modelo.entidade.tutor.Tutor;
import centralpet.modelo.enumeracao.genero.GeneroTutor;
import centralpet.modelo.enumeracao.pet.especie.EspeciePet;
import centralpet.modelo.enumeracao.pet.estado.EstadoPet;
import centralpet.modelo.enumeracao.pet.pelagem.PelagemPet;
import centralpet.modelo.enumeracao.pet.porte.PortePet;
import centralpet.modelo.enumeracao.pet.sexo.SexoPet;
import centralpet.modelo.enumeracao.pet.status.StatusPet;

@WebServlet("/")
@MultipartConfig
public class Cadastro extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private EnderecoDAO daoEndereco;

	private TutorDAO daoTutor;

	private ContatoDAO daoContato;
	
	private OngDAO daoOng;
	
	private PetDAO daoPet;
	
	private AdocaoDAO daoAdocao;
	
	private TermoDAO daoTermo;
	
	private FotosPetDAO daoFotosPet;
	
	private Collection<Part> parteImagem = null;
	
	private byte[] fotos = null;
	
	private Tika tika = new Tika();

	public void init() {
		daoEndereco = new EnderecoDAOImpl();
		daoTutor = new TutorDAOImpl();
		daoContato = new ContatoDAOImpl();
		daoOng = new OngDAOImpl();
		daoPet = new PetDAOImpl();
		daoAdocao = new AdocaoDAOImpl();
		daoTermo = new TermoDAOImpl();
		daoFotosPet = new FotosPetDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		try {

			switch (action) {

			case "/novo-tutor":
				mostrarFormularioNovoTutor(request, response);
				break;
				
			case "/cadastro-tutor":
				inserirTutor(request, response);
				break;
				
			case "/nova-ong":
				mostrarFormularioNovaOng(request, response);
				break;
				
			case "/cadastro-ong":
				inserirOng(request, response);
				break;
				
			case "/novo-pet":
				mostrarFormularioNovoPet(request, response);
				break;
				
			case "/cadastro-pet":
				inserirPet(request, response);
				break;
				
			case "/novo-termo":
				mostrarFormularioNovoTermo(request, response);
				break;
				
			case "/cadastro-termo":
				inserirTermo(request, response);
				break;
				
			case "/nova-adocao":
				mostrarFormularioNovaAdocao(request, response);
				break;
				
			case "/cadastro-adocao":
				inserirAdocao(request, response);
				break;
				
			case "/novas-fotos-pet":
				mostrarFormularioNovasFotosPet(request, response);
				break;
				
			case "/cadastrar-fotos-pet":
				inserirFotosPet(request, response);
				break;
				
			case "/mostrar-perfil-pet":
				mostrarPerfilPet(request, response);
				break;
				
			case "/mostrar-perfil-ong":
				mostrarPerfilOng(request, response);
				break;
				
			case "/mostrar-perfil-tutor":
				mostrarPerfilTutor(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void mostrarFormularioNovoTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("novo-tutor.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarFormularioNovaOng(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("nova-ong.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarFormularioNovoPet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		   System.out.println("Método mostrarFormularioNovoPet foi chamado");

		    Ong ong = daoOng.recuperarOng(2L);

		    if (ong != null) {
	
		        System.out.println("Nome da Ong: " + ong.getNome());
		        
		        request.setAttribute("ong", ong);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("novo-pet.jsp");
		        dispatcher.forward(request, response);
		    } else {
		        
		        System.out.println("Ong não encontrada");
		    }
	}
	
	private void mostrarFormularioNovoTermo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  System.out.println("Método mostrarFormularioNovoTermo foi chamado");

		    Ong ong = daoOng.recuperarOng(2L);

		    if (ong != null) {
	
		        System.out.println("Nome da Ong: " + ong.getNome());
		        
		        request.setAttribute("ong", ong);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("novo-termo.jsp");
		        dispatcher.forward(request, response);
		    } else {
		        
		        System.out.println("Ong não encontrada");
		    }
	
	}
	
	private void mostrarFormularioNovaAdocao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 System.out.println("Método mostrarFormularioNovoTermo foi chamado");

		    Ong ong = daoOng.recuperarOng(2L);
		    Tutor tutor = daoTutor.recuperarTutor(1L);
			Pet pet = daoPet.recuperarPet(1L);
		    Termo termo = daoTermo.recuperarTermo(1L);
			

		    if (ong != null && tutor != null && pet != null && termo != null) {
	
		        System.out.println("Nome da Ong: " + ong.getNome());
		        System.out.println("Nome do Tutor: " + tutor.getNome());
		        System.out.println("Nome do Pet: " + pet.getNome());
		        System.out.println("Nome do Tutor: " + termo.getTermo());
		        
		        request.setAttribute("ong", ong);
		        request.setAttribute("tutor", tutor);
		        request.setAttribute("pet", pet);
		        request.setAttribute("termo", termo);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("nova-adocao.jsp");
		        dispatcher.forward(request, response);
		    } else {
		        
		        System.out.println("Ong e Tutor não encontrados");
		    }
	}
	
	private void mostrarFormularioNovasFotosPet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Pet pet = daoPet.recuperarPet(1L);
		
		if(pet != null) {
			
			request.setAttribute("pet", pet);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("novas-fotos-pet.jsp");
			dispatcher.forward(request, response);
		} else {
			
			System.out.println("Pet nao encontrado");
		}
	}
	
	private void mostrarPerfilPet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Pet pet = daoPet.recuperarPet(1L);
		//List<FotosPet> fotos = daoFotosPet.recuperarFotosPet(1L);
		Ong ong = daoOng.recuperarOng(2L);
		
		if(pet != null && ong != null) {		
			request.setAttribute("pet", pet);
			request.setAttribute("ong", ong);
			} 
		else 
			System.out.println("Pet ou ONG não encontrado");
		
		/*if (fotos != null) {
		    System.out.println("Foto não é nula");
		    List<HttpServletResponse> fotosProcessadas = new ArrayList<>();
		    
		    for (FotosPet foto : fotos) {
		        if (foto.getDadosImagem() != null) {
		            String tipoImagem = tika.detect(foto.getDadosImagem());

		            HttpServletResponse respostaTemporaria = criarRespostaTemporaria(response, tipoImagem, foto.getDadosImagem());
		           
		            fotosProcessadas.add(respostaTemporaria);
		        } else 
		            response.setContentType("imagem invalida");
		        
		    }
		    
		    request.setAttribute("fotosProcessadas", fotosProcessadas);
		    
		} else 
		    System.out.println("Sem fotos");
		*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar-perfil-pet.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarPerfilOng(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Ong ong = daoOng.recuperarOng(2L);
		Endereco endereco = daoEndereco.recuperarEnderecoUsuario(ong);
		Contato contato = daoContato.recuperarContatoUsuario(ong);
		List<Adocao> adocao = daoAdocao.recuperarAdocoesOng(ong);
		Termo termo = daoTermo.recuperarTermo(2L);
		
		if(ong != null && endereco != null && contato != null && termo != null) {
			request.setAttribute("ong", ong);
			request.setAttribute("endereco", endereco);
			request.setAttribute("contato", contato);
			request.setAttribute("adocao", adocao);
			request.setAttribute("termo", termo);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar-perfil-ong.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarPerfilTutor(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Tutor tutor = daoTutor.recuperarTutor(1L);
		Endereco endereco = daoEndereco.recuperarEnderecoUsuario(tutor);
		Contato contato = daoContato.recuperarContatoUsuario(tutor);
		List<Adocao> adocao = daoAdocao.recuperarAdocoesTutor(tutor);
		
		if(tutor != null && endereco != null && contato != null) {
			request.setAttribute("tutor", tutor);
			request.setAttribute("endereco", endereco);
			request.setAttribute("contato", contato);
			request.setAttribute("adocao", adocao);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar-perfil-tutor.jsp");
		dispatcher.forward(request, response);
	}

	private void inserirTutor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Endereco endereco = null;

		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String pontoReferencia = request.getParameter("pontoReferencia");
		
		endereco = new Endereco(logradouro, numero, bairro, cep, pontoReferencia);
		daoEndereco.inserirEndereco(endereco);

		Tutor tutor = null;
		Part fotoPerfil = null;

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		GeneroTutor generoTutor = GeneroTutor.valueOf(request.getParameter("generoTutor"));
		String senha = request.getParameter("senha");
		fotoPerfil = request.getPart("fotoPerfil");
		fotos = obterBytesImagem(fotoPerfil);
		
		tutor = new Tutor(nome, endereco, cpf, dataNascimento, generoTutor, senha, fotos);
		daoTutor.inserirTutor(tutor);
		
		Contato contato = null;
		
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		contato = new Contato(email, telefone, tutor);
		daoContato.inserirContato(contato);
		response.sendRedirect("home.jsp");
	}
	
	private void inserirOng(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		Endereco endereco = null;

		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String pontoReferencia = request.getParameter("pontoReferencia");
		
		endereco = new Endereco(logradouro, numero, bairro, cep, pontoReferencia);
		daoEndereco.inserirEndereco(endereco);
		
		Ong ong = null;
		Part fotoPerfil = null;
		
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cnpj = request.getParameter("cnpj");
		fotoPerfil = request.getPart("fotoPerfil");
		fotos = obterBytesImagem(fotoPerfil);
		
		ong = new Ong(nome, endereco, cnpj, senha, fotos);
		daoOng.inserirOng(ong);
		
		Contato contato = null;
		
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		contato = new Contato(email, telefone, ong);
		daoContato.inserirContato(contato);
		response.sendRedirect("novo-pet");
		
	}
	
	private void inserirPet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		Ong ongPet = daoOng.recuperarOng(2L);
		Pet pet = null;
		
		String nome = request.getParameter("nome");
		String vacinas = request.getParameter("vacinas");
		String descricao = request.getParameter("descricao");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimentoPet"));
		Byte idade = Byte.parseByte(request.getParameter("idade"));
		StatusPet statusPet = StatusPet.valueOf(request.getParameter("statusPet"));
		PortePet portePet = PortePet.valueOf(request.getParameter("portePet"));
		EspeciePet especiePet = EspeciePet.valueOf(request.getParameter("especiePet"));
		SexoPet sexoPet = SexoPet.valueOf(request.getParameter("sexoPet"));
		EstadoPet estadoPet = EstadoPet.valueOf(request.getParameter("estadoPet"));
		PelagemPet pelagemPet = PelagemPet.valueOf(request.getParameter("pelagemPet"));
		
		pet = new Pet(nome, vacinas, descricao, dataNascimento, idade, ongPet, statusPet, portePet, especiePet, sexoPet, estadoPet,
				pelagemPet);
		daoPet.inserirPet(pet);
		
	
		response.sendRedirect("novas-fotos-pet");
	}
	
	private void inserirFotosPet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		Pet pet = daoPet.recuperarPet(1L);
		List<FotosPet> listaFotosPet = null;
		
		parteImagem = request.getParts();
		adicionarImagems(listaFotosPet, pet, parteImagem);
		
		response.sendRedirect("mostrar-perfil-pet");
	}
	
	private void inserirTermo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		Ong ong = daoOng.recuperarOng(2L);
		
		String Otermo = request.getParameter("termo");
		
		Termo termo = new Termo(ong, Otermo);
		daoTermo.inserirTermo(termo);
		response.sendRedirect("nova-adocao");
	}
	
	private void inserirAdocao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		Pet pet = daoPet.recuperarPet(1L);
		Ong ong = daoOng.recuperarOng(2L);
	    Tutor tutor = daoTutor.recuperarTutor(1L);
		Termo termo = daoTermo.recuperarTermo(1L);
		
		Adocao adocao = new Adocao(pet, ong, tutor, termo);
		daoAdocao.inserirAdocao(adocao);
		
		System.out.println("Adoção inserida no banco");
		System.out.println("Pet: " + pet.getNome());
		System.out.println("ONG: " + ong.getNome());
		System.out.println("Tutor: " + tutor.getNome());
		response.sendRedirect("home.jsp");
	}

	private byte[] obterBytesImagem(Part parteImagem) throws IOException {
		InputStream imagemInputstream = parteImagem.getInputStream();
		
		return IOUtils.toByteArray(imagemInputstream);
	}
	
	private void adicionarImagems(List<FotosPet> fotosPet, Pet pet, Collection<Part> parteImagem) throws IOException {
		
		FotosPetDAO daoFotosPet;
		
		for(Part partes : parteImagem) {
			
			daoFotosPet = new FotosPetDAOImpl();
			
			fotos = obterBytesImagem(partes);
			
			FotosPet foto = new FotosPet();
		
			foto = new FotosPet(fotos, pet);
			
			pet.adicionarFoto(foto);
			daoFotosPet.inserirFotosPet(foto);
			
		}
		pet.setFotos(fotosPet);
	}
	
	private HttpServletResponse criarRespostaTemporaria(HttpServletResponse respostaOriginal, String tipoFoto, byte[] conteudoFoto) {
	    try {
	        HttpServletResponseWrapper respostaProcessada = new HttpServletResponseWrapper(respostaOriginal);
	        respostaProcessada.setContentType(tipoFoto);
	        
	        try (ServletOutputStream outputStream = respostaProcessada.getOutputStream()) {
	            outputStream.write(conteudoFoto);
	        }
	        
	        return respostaProcessada;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
}


