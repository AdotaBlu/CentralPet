package centralpet.controle.cadastroServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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
import centralpet.modelo.dao.usuario.UsuarioDAO;
import centralpet.modelo.dao.usuario.UsuarioDAOImpl;
import centralpet.modelo.entidade.adocao.Adocao;
import centralpet.modelo.entidade.contato.Contato;
import centralpet.modelo.entidade.endereco.Endereco;
import centralpet.modelo.entidade.fotosPet.FotoDTO;
import centralpet.modelo.entidade.fotosPet.FotosPet;
import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.termo.Termo;
import centralpet.modelo.entidade.tutor.Tutor;
import centralpet.modelo.entidade.usuario.Usuario;
import centralpet.modelo.enumeracao.genero.GeneroTutor;
import centralpet.modelo.enumeracao.pet.especie.EspeciePet;
import centralpet.modelo.enumeracao.pet.estado.EstadoPet;
import centralpet.modelo.enumeracao.pet.pelagem.PelagemPet;
import centralpet.modelo.enumeracao.pet.porte.PortePet;
import centralpet.modelo.enumeracao.pet.sexo.SexoPet;
import centralpet.modelo.enumeracao.pet.status.StatusPet;
import centralpet.util.conversorImagem.ConversorImagemImpl;
import centralpet.util.conversorImagem.ConverterImagem;

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

	private UsuarioDAO daoUsuario;

	private Collection<Part> parteImagem = null;

	private ConverterImagem converterImagem;

	private byte[] fotos = null;

	public void init() {
		daoEndereco = new EnderecoDAOImpl();
		daoTutor = new TutorDAOImpl();
		daoContato = new ContatoDAOImpl();
		daoOng = new OngDAOImpl();
		daoPet = new PetDAOImpl();
		daoAdocao = new AdocaoDAOImpl();
		daoTermo = new TermoDAOImpl();
		daoFotosPet = new FotosPetDAOImpl();
		converterImagem = new ConversorImagemImpl();
		daoUsuario = new UsuarioDAOImpl();
		HttpSession sessao = null;
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

			case "/home":
				mostrarTelaInicial(request, response);
				break;

			case "/novo-tutor":
				mostrarFormularioNovoTutor(request, response);
				break;

			case "/cadastro-tutor":
				inserirTutor(request, response);
				break;

			case "/editar-tutor":
				mostrarFormEditarTutor(request, response);
				break;

			case "/atualizar-tutor":
				atualizarTutor(request, response);
				break;

			case "/excluir-tutor":
				excluirTutor(request, response);
				break;

			case "/nova-ong":
				mostrarFormularioNovaOng(request, response);
				break;

			case "/cadastro-ong":
				inserirOng(request, response);
				break;

			case "/editar-ong":
				mostrarFormEditarOng(request, response);
				break;
				
			case "/excluir-ong":
				excluirOng(request, response);
				break;

			case "/atualizar-ong":
				atualizarOng(request, response);
				break;

			case "/novo-pet":
				mostrarFormularioNovoPet(request, response);
				break;

			case "/cadastro-pet":
				inserirPet(request, response);
				break;

			case "/editar-pet":
				mostrarFormularioEditarPet(request, response);
				break;

			case "/atualizar-pet":
				atualizarPet(request, response);
				break;

			case "/excluir-pet":
				excluirPet(request, response);
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

			case "/mostrar-perfil-pet":
				mostrarPerfilPet(request, response);
				break;

			case "/mostrar-perfil-ong":
				mostrarPerfilOng(request, response);
				break;

			case "/mostrar-perfil-tutor":
				mostrarPerfilTutor(request, response);
				break;

			case "/mostrar-selecao-cadastro":
				mostrarSelecaoCadastro(request, response);
				break;

			case "/novo-login":
				mostrarFormularioLogin(request, response);
				break;

			case "/confirmar-login":
				confirmarLogin(request, response);
				break;

			case "/sair":
				finalizarLogin(request, response);
				break;

			case "/mostrar-cards-pets":
				mostrarPetsDisponiveis(request, response);
				break;

			case "/filtrar-pets":
				filtrarPets(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void mostrarTelaInicial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		FotoDTO fotoDTO = new FotoDTO();
		String urlFoto;

		if (sessao.getAttribute("usuario") instanceof Tutor) {
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Tutor tutor = daoTutor.recuperarTutorUsuario(usuario);

			urlFoto = Base64.getEncoder().encodeToString(tutor.getfotoPerfil());
			fotoDTO.setId(tutor.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("tutor", tutor);
		}

		if (sessao.getAttribute("usuario") instanceof Ong) {
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Ong ong = daoOng.recuperarOngUsuario(usuario);

			urlFoto = Base64.getEncoder().encodeToString(ong.getfotoPerfil());
			fotoDTO.setId(ong.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("ong", ong);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarFormularioLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		FotoDTO fotoDTO = new FotoDTO();
		String urlFoto;

		if (sessao.getAttribute("usuario") instanceof Tutor) {
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Tutor tutor = daoTutor.recuperarTutorUsuario(usuario);

			urlFoto = Base64.getEncoder().encodeToString(tutor.getfotoPerfil());
			fotoDTO.setId(tutor.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("tutor", tutor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}

		if (sessao.getAttribute("usuario") instanceof Ong) {
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Ong ong = daoOng.recuperarOngUsuario(usuario);

			urlFoto = Base64.getEncoder().encodeToString(ong.getfotoPerfil());
			fotoDTO.setId(ong.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("ong", ong);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("novo-login.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarPetsDisponiveis(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Pet> todosPets = daoPet.recuperarTodosPets();

		request.setAttribute("pets", todosPets);

		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar-cards-pets.jsp");
		dispatcher.forward(request, response);
	}

	private void filtrarPets(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String especie = request.getParameter("especie");
		Optional<EspeciePet> especieOp = (especie == "") ? Optional.empty() : Optional.of(EspeciePet.valueOf(especie));

		String porte = request.getParameter("porte");
		Optional<PortePet> porteOp = (porte == "") ? Optional.empty() : Optional.of(PortePet.valueOf(porte));

		String sexo = request.getParameter("sexo");
		Optional<SexoPet> sexoOp = (sexo == "") ? Optional.empty() : Optional.of(SexoPet.valueOf(sexo));

		String pelagem = request.getParameter("pelagem");
		Optional<PelagemPet> pelagemOp = (pelagem == "") ? Optional.empty() : Optional.of(PelagemPet.valueOf(pelagem));

		List<Pet> petsFiltrados = daoPet.filtrarBuscaPet(especieOp, porteOp, sexoOp, pelagemOp);

		request.setAttribute("pets", petsFiltrados);

		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar-cards-pets.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarFormularioNovoTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		String urlFoto;
		FotoDTO fotoDTO = new FotoDTO();

		if (sessao.getAttribute("usuario") instanceof Tutor) {
			Tutor tutor = (Tutor) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(tutor.getfotoPerfil());
			fotoDTO.setId(tutor.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("tutor", tutor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (sessao.getAttribute("usuario") instanceof Ong) {
			Ong ong = (Ong) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(ong.getfotoPerfil());
			fotoDTO.setId(ong.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("ong", ong);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("novo-tutor.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarFormEditarTutor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		HttpSession sessao = request.getSession();
		String urlFoto;
		FotoDTO fotoDTO = new FotoDTO();

		if (sessao.getAttribute("usuario") instanceof Tutor) {
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Tutor tutor = daoTutor.recuperarTutorUsuario(usuario);
			Endereco endereco = daoEndereco.recuperarEnderecoUsuario(tutor);
			Contato contato = daoContato.recuperarContatoUsuario(tutor);

			urlFoto = Base64.getEncoder().encodeToString(tutor.getfotoPerfil());
			fotoDTO.setId(tutor.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("endereco", endereco);
			request.setAttribute("tutor", tutor);
			request.setAttribute("contato", contato);

			RequestDispatcher dispatcher = request.getRequestDispatcher("editar-tutor.jsp");
			dispatcher.forward(request, response);
		} else if (sessao.getAttribute("usuario") instanceof Ong) {
			Ong ong = (Ong) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(ong.getfotoPerfil());
			fotoDTO.setId(ong.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("ong", ong);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}

		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void excluirTutor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		String urlFoto;
		FotoDTO fotoDTO = new FotoDTO();

		if (sessao.getAttribute("usuario") instanceof Tutor) {
			Tutor tutor = (Tutor) sessao.getAttribute("usuario");
			Contato contato = daoContato.recuperarContatoUsuario(tutor);
			Endereco endereco = daoEndereco.recuperarEnderecoUsuario(tutor);

			daoEndereco.deletarEndereco(endereco);
			daoContato.deletarContato(contato);
			daoTutor.deletarTutor(tutor);
			sessao.invalidate();
			response.sendRedirect("home");

		} else if (sessao.getAttribute("usuario") instanceof Ong) {
			Ong ong = (Ong) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(ong.getfotoPerfil());
			fotoDTO.setId(ong.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("ong", ong);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}

		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void mostrarFormularioNovaOng(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		String urlFoto;
		FotoDTO fotoDTO = new FotoDTO();

		if (sessao.getAttribute("usuario") instanceof Tutor) {
			Tutor tutor = (Tutor) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(tutor.getfotoPerfil());
			fotoDTO.setId(tutor.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("tutor", tutor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (sessao.getAttribute("usuario") instanceof Ong) {
			Ong ong = (Ong) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(ong.getfotoPerfil());
			fotoDTO.setId(ong.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("ong", ong);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}

		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("nova-ong.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarFormEditarOng(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		HttpSession sessao = request.getSession();
		String urlFoto;
		FotoDTO fotoDTO = new FotoDTO();

		if (sessao.getAttribute("usuario") instanceof Tutor) {
			Tutor tutor = (Tutor) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(tutor.getfotoPerfil());
			fotoDTO.setId(tutor.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("tutor", tutor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (sessao.getAttribute("usuario") instanceof Ong) {
			Ong ong = (Ong) sessao.getAttribute("usuario");

			Endereco endereco = daoEndereco.recuperarEnderecoUsuario(ong);
			Contato contato = daoContato.recuperarContatoUsuario(ong);
			urlFoto = Base64.getEncoder().encodeToString(ong.getfotoPerfil());
			fotoDTO.setId(ong.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("endereco", endereco);
			request.setAttribute("contato", contato);
			request.setAttribute("ong", ong);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editar-ong.jsp");
			dispatcher.forward(request, response);
		}

		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void excluirOng(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
	
		HttpSession sessao = request.getSession();
		String urlFoto;
		FotoDTO fotoDTO = new FotoDTO();
		
		if(sessao.getAttribute("usuario") instanceof Ong) {
		Ong ong = (Ong) sessao.getAttribute("usuario");
		Contato contato = daoContato.recuperarContatoUsuario(ong);
		Endereco endereco = daoEndereco.recuperarEnderecoUsuario(ong);
		
		daoEndereco.deletarEndereco(endereco);
		daoContato.deletarContato(contato);
		daoOng.deletarOng(ong);
		sessao.invalidate();
		response.sendRedirect("home");
		}
		else if(sessao.getAttribute("usuario") instanceof Tutor){
			Tutor tutor = (Tutor) sessao.getAttribute("usuario");
			
			urlFoto = Base64.getEncoder().encodeToString(tutor.getfotoPerfil());
			fotoDTO.setId(tutor.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);
			
			request.setAttribute("foto", fotoDTO);
			request.setAttribute("tutor", tutor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
	
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarFormularioNovoPet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		HttpSession sessao = request.getSession();
		String urlFoto;
		FotoDTO fotoDTO = new FotoDTO();

		if (sessao.getAttribute("usuario") instanceof Tutor) {
			Tutor tutor = (Tutor) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(tutor.getfotoPerfil());
			fotoDTO.setId(tutor.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("tutor", tutor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (sessao.getAttribute("usuario") instanceof Ong) {
			Ong ong = (Ong) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(ong.getfotoPerfil());
			fotoDTO.setId(ong.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("ong", ong);
			RequestDispatcher dispatcher = request.getRequestDispatcher("novo-pet.jsp");
			dispatcher.forward(request, response);
		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("home");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarFormularioEditarPet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		HttpSession sessao = request.getSession();
		String urlFoto;
		FotoDTO fotoDTO = new FotoDTO();

		if (sessao.getAttribute("usuario") instanceof Tutor) {
			Tutor tutor = (Tutor) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(tutor.getfotoPerfil());
			fotoDTO.setId(tutor.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("tutor", tutor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (sessao.getAttribute("usuario") instanceof Ong) {
			Ong ong = (Ong) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(ong.getfotoPerfil());
			fotoDTO.setId(ong.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("ong", ong);

			Long idPet = Long.parseLong(request.getParameter("id-pet"));
			Pet pet = daoPet.recuperarPet(idPet);
			List<FotosPet> fotosPet = daoFotosPet.recuperarFotosPet(idPet);
			List<FotoDTO> fotoDTOs = new ArrayList<>();
			String urlFotoPet;

			for (FotosPet fotoPet : fotosPet) {

				FotoDTO fotoDTOPet = new FotoDTO();
				urlFotoPet = Base64.getEncoder().encodeToString(fotoPet.getDadosImagem());
				fotoDTOPet.setId(fotoPet.getId());
				fotoDTOPet.setUrlImagem("data:image/jpeg;base64," + urlFotoPet);
				fotoDTOs.add(fotoDTOPet);
			}

			request.setAttribute("pet", pet);
			request.setAttribute("fotos", fotoDTOs);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editar-pet.jsp");
			dispatcher.forward(request, response);
		}

		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarFormularioNovoTermo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();

		String urlFoto;
		FotoDTO fotoDTO = new FotoDTO();

		if (sessao.getAttribute("usuario") instanceof Tutor) {
			Tutor tutor = (Tutor) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(tutor.getfotoPerfil());
			fotoDTO.setId(tutor.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("tutor", tutor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (sessao.getAttribute("usuario") instanceof Ong) {
			Ong ong = (Ong) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(ong.getfotoPerfil());
			fotoDTO.setId(ong.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("ong", ong);
			RequestDispatcher dispatcher = request.getRequestDispatcher("novo-termo.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarFormularioNovaAdocao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Ong ong = daoOng.recuperarOng(2L);
		Tutor tutor = daoTutor.recuperarTutor(1L);
		Pet pet = daoPet.recuperarPet(1L);
		Termo termo = daoTermo.recuperarTermo(2L);

		if (ong != null && tutor != null && pet != null && termo != null) {

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

	private void mostrarPerfilPet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		Long idPet = Long.parseLong(request.getParameter("id-pet"));
		Long idOng = Long.parseLong(request.getParameter("id-ong"));

		Pet pet = daoPet.recuperarPet(idPet);
		List<FotosPet> fotosPet = daoFotosPet.recuperarFotosPet(idPet);
		Ong ong = daoOng.recuperarOng(idOng);
		List<FotoDTO> fotoDTOs = new ArrayList<>();
		String urlFoto;

		if (sessao.getAttribute("usuario").equals(ong)) {
			Ong ongSessao = (Ong) sessao.getAttribute("usuario");
			request.setAttribute("ongSessao", ongSessao);
		}

		if (pet != null && ong != null) {
			request.setAttribute("pet", pet);
			request.setAttribute("ong", ong);

			for (FotosPet foto : fotosPet) {

				FotoDTO fotoDTO = new FotoDTO();
				urlFoto = Base64.getEncoder().encodeToString(foto.getDadosImagem());
				fotoDTO.setId(foto.getId());
				fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);
				fotoDTOs.add(fotoDTO);
			}

			request.setAttribute("fotos", fotoDTOs);

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar-perfil-pet.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarPerfilOng(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		String urlFoto;
		FotoDTO fotoDTO = new FotoDTO();

		if (sessao.getAttribute("usuario") instanceof Ong) {
			Ong ong = (Ong) sessao.getAttribute("usuario");

			Endereco endereco = daoEndereco.recuperarEnderecoUsuario(ong);
			Contato contato = daoContato.recuperarContatoUsuario(ong);
			List<Pet> petsOng = daoPet.recuperarPetsOng(ong);

			request.setAttribute("pets", petsOng);
			request.setAttribute("ong", ong);
			request.setAttribute("endereco", endereco);
			request.setAttribute("contato", contato);

			urlFoto = Base64.getEncoder().encodeToString(ong.getfotoPerfil());
			fotoDTO.setId(ong.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);
			
			request.setAttribute("pets", petsOng);
			request.setAttribute("foto", fotoDTO);
			request.setAttribute("ong", ong);
			RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar-perfil-ong.jsp");
			dispatcher.forward(request, response);
			
		} else if (sessao.getAttribute("usuario") instanceof Tutor) {
			Tutor tutor = (Tutor) sessao.getAttribute("usuario");
			Long idOng = Long.parseLong(request.getParameter("id-ong"));
			Ong ong = daoOng.recuperarOng(idOng);
			List<Pet> petsOng = daoPet.recuperarPetsOng(ong);

			urlFoto = Base64.getEncoder().encodeToString(tutor.getfotoPerfil());
			fotoDTO.setId(tutor.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);
			
			request.setAttribute("ong", ong);
			request.setAttribute("pets", petsOng);
			request.setAttribute("foto", fotoDTO);
			request.setAttribute("tutor", tutor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else {
			Long idOng = Long.parseLong(request.getParameter("id-ong"));
			Ong ong = daoOng.recuperarOng(idOng);
			List<Pet> petsOng = daoPet.recuperarPetsOng(ong);
			
			request.setAttribute("ong", ong);
			request.setAttribute("pets", petsOng);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarPerfilTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		String urlFoto;
		FotoDTO fotoDTO = new FotoDTO();
		// Tutor tutor = daoTutor.recuperarTutor();

		if (sessao.getAttribute("usuario") instanceof Tutor) {
			Tutor tutor = (Tutor) sessao.getAttribute("usuario");

			Endereco endereco = daoEndereco.recuperarEnderecoUsuario(tutor);
			Contato contato = daoContato.recuperarContatoUsuario(tutor);
			// List<Adocao> adocao = daoAdocao.recuperarAdocoesTutor(tutor);

			request.setAttribute("tutor", tutor);
			request.setAttribute("endereco", endereco);
			request.setAttribute("contato", contato);

			urlFoto = Base64.getEncoder().encodeToString(tutor.getfotoPerfil());
			fotoDTO.setId(tutor.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("tutor", tutor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar-perfil-tutor.jsp");
			dispatcher.forward(request, response);
		} else if (sessao.getAttribute("usuario") instanceof Ong) {
			Ong ong = (Ong) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(ong.getfotoPerfil());
			fotoDTO.setId(ong.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("ong", ong);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarSelecaoCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		String urlFoto;
		FotoDTO fotoDTO = new FotoDTO();

		if (sessao.getAttribute("usuario") instanceof Tutor) {
			Tutor tutor = (Tutor) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(tutor.getfotoPerfil());
			fotoDTO.setId(tutor.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("tutor", tutor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (sessao.getAttribute("usuario") instanceof Ong) {
			Ong ong = (Ong) sessao.getAttribute("usuario");

			urlFoto = Base64.getEncoder().encodeToString(ong.getfotoPerfil());
			fotoDTO.setId(ong.getId());
			fotoDTO.setUrlImagem("data:image/jpeg;base64," + urlFoto);

			request.setAttribute("foto", fotoDTO);
			request.setAttribute("ong", ong);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar-selecao-cadastro.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void inserirTutor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Endereco endereco = null;

		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String pontoReferencia = request.getParameter("ponto-referencia");

		endereco = new Endereco(logradouro, numero, bairro, cep, pontoReferencia);
		daoEndereco.inserirEndereco(endereco);

		Tutor tutor = null;
		Part fotoPerfil = null;

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("data-nascimento"));
		GeneroTutor generoTutor = GeneroTutor.valueOf(request.getParameter("genero-tutor"));
		String senha = request.getParameter("senha");
		fotoPerfil = request.getPart("foto-perfil");
		fotos = converterImagem.obterBytesImagem(fotoPerfil);

		tutor = new Tutor(nome, endereco, cpf, dataNascimento, generoTutor, senha, fotos);
		daoTutor.inserirTutor(tutor);

		Contato contato = null;

		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");

		contato = new Contato(email, telefone, tutor);
		daoContato.inserirContato(contato);
		response.sendRedirect("home");
	}

	private void atualizarTutor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Long idEndereco = Long.parseLong(request.getParameter("id-endereco"));
		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String pontoReferencia = request.getParameter("ponto-referencia");

		daoEndereco.atualizarEndereco(new Endereco(idEndereco, logradouro, numero, bairro, cep, pontoReferencia));
		Endereco endereco = daoEndereco.recuperarEndereco(idEndereco);

		Part fotoPerfil = null;
		Long idTutor = Long.parseLong(request.getParameter("id-tutor"));
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("data-nascimento"));
		GeneroTutor generoTutor = GeneroTutor.valueOf(request.getParameter("genero-tutor"));
		String senha = request.getParameter("senha");
		fotoPerfil = request.getPart("foto-perfil");
		fotos = converterImagem.obterBytesImagem(fotoPerfil);
		daoTutor.atualizarTutor(new Tutor(nome, endereco, idTutor, cpf, dataNascimento, generoTutor, senha, fotos));
		Tutor tutor = daoTutor.recuperarTutor(idTutor);

		Long idContato = Long.parseLong(request.getParameter("id-contato"));
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		daoContato.atualizarContato(new Contato(idContato, email, telefone, tutor));

		HttpSession sessao = request.getSession();
		Usuario usuario = daoUsuario.recuperarUsuarioEmail(email);
		sessao.setAttribute("usuario", usuario);
		response.sendRedirect("home");
	}

	private void inserirOng(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Endereco endereco = null;

		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String pontoReferencia = request.getParameter("ponto-referencia");

		endereco = new Endereco(logradouro, numero, bairro, cep, pontoReferencia);
		daoEndereco.inserirEndereco(endereco);

		Ong ong = null;
		Part fotoPerfil = null;

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cnpj = request.getParameter("cnpj");
		fotoPerfil = request.getPart("foto-perfil");
		fotos = converterImagem.obterBytesImagem(fotoPerfil);

		ong = new Ong(nome, endereco, cnpj, senha, fotos);
		daoOng.inserirOng(ong);

		Contato contato = null;

		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");

		contato = new Contato(email, telefone, ong);
		daoContato.inserirContato(contato);

		response.sendRedirect("home");

	}

	private void atualizarOng(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Long idEndereco = Long.parseLong(request.getParameter("id-endereco"));
		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String pontoReferencia = request.getParameter("ponto-referencia");
		Endereco endereco = new Endereco(idEndereco, logradouro, numero, bairro, cep, pontoReferencia);
		daoEndereco.atualizarEndereco(endereco);

		Part fotoPerfil = null;

		Long idOng = Long.parseLong(request.getParameter("id-ong"));
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String senha = request.getParameter("senha");
		fotoPerfil = request.getPart("foto-perfil");
		fotos = converterImagem.obterBytesImagem(fotoPerfil);
		Ong ong = new Ong(nome, endereco, idOng, cnpj, senha, fotos);
		daoOng.atualizarOng(ong);

		Long idContato = Long.parseLong(request.getParameter("id-contato"));
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		daoContato.atualizarContato(new Contato(idContato, email, telefone, ong));

		HttpSession sessao = request.getSession();
		Usuario usuario = daoUsuario.recuperarUsuarioEmail(email);
		sessao.setAttribute("usuario", usuario);
		response.sendRedirect("home");
	}

	private void inserirPet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		Ong ongPet = (Ong) sessao.getAttribute("usuario");
		Pet pet = null;

		String nome = request.getParameter("nome");
		String vacinas = request.getParameter("vacinas");
		String descricao = request.getParameter("descricao");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("data-nascimento-pet"));
		Byte idade = Byte.parseByte(request.getParameter("idade"));
		Double peso = Double.parseDouble(request.getParameter("peso"));
		StatusPet statusPet = StatusPet.valueOf(request.getParameter("status-pet"));
		PortePet portePet = PortePet.valueOf(request.getParameter("porte-pet"));
		EspeciePet especiePet = EspeciePet.valueOf(request.getParameter("especie-pet"));
		SexoPet sexoPet = SexoPet.valueOf(request.getParameter("sexo-pet"));
		EstadoPet estadoPet = EstadoPet.valueOf(request.getParameter("estado-pet"));
		PelagemPet pelagemPet = PelagemPet.valueOf(request.getParameter("pelagem-pet"));

		pet = new Pet(nome, vacinas, descricao, dataNascimento, idade, peso, ongPet, statusPet, portePet, especiePet,
				sexoPet, estadoPet, pelagemPet);
		daoPet.inserirPet(pet);

		parteImagem = request.getParts();
		converterImagem.adicionarImagensArrayFotosPet(pet, parteImagem);
		
		ongPet.adicionarPet(pet);

		response.sendRedirect("home	");
	}

	private void atualizarPet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		Ong ongPet = (Ong) sessao.getAttribute("usuario");

		Pet pet = null;
		Long id = Long.parseLong(request.getParameter("id-pet"));
		String nome = request.getParameter("nome");
		String vacinas = request.getParameter("vacinas");
		String descricao = request.getParameter("descricao");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("data-nascimento-pet"));
		Byte idade = Byte.parseByte(request.getParameter("idade"));
		Double peso = Double.parseDouble(request.getParameter("peso"));
		StatusPet statusPet = StatusPet.valueOf(request.getParameter("status-pet"));
		PortePet portePet = PortePet.valueOf(request.getParameter("porte-pet"));
		EspeciePet especiePet = EspeciePet.valueOf(request.getParameter("especie-pet"));
		SexoPet sexoPet = SexoPet.valueOf(request.getParameter("sexo-pet"));
		EstadoPet estadoPet = EstadoPet.valueOf(request.getParameter("estado-pet"));
		PelagemPet pelagemPet = PelagemPet.valueOf(request.getParameter("pelagem-pet"));
		pet = new Pet(id, nome, vacinas, descricao, dataNascimento, idade, peso, ongPet, statusPet, portePet,
				especiePet, sexoPet, estadoPet, pelagemPet);
		daoPet.atualizarPet(pet);

		Usuario usuario = daoUsuario.recuperarUsuario(ongPet);
		sessao.setAttribute("usuario", usuario);

		response.sendRedirect("mostrar-cards-pets.jsp");
	}

	private void excluirPet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		Ong ongPet = (Ong) sessao.getAttribute("usuario");

		if (ongPet != null) {
			Long id = Long.parseLong(request.getParameter("id-pet"));
			Pet pet = daoPet.recuperarPet(id);
			daoPet.deletarPet(pet);

			Usuario usuario = daoUsuario.recuperarUsuario(ongPet);
			sessao.setAttribute("usuario", usuario);
		}

		response.sendRedirect("mostrar-cards-pets");
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
		Termo termo = daoTermo.recuperarTermo(2L);

		Adocao adocao = new Adocao(pet, ong, tutor, termo);
		daoAdocao.inserirAdocao(adocao);

		response.sendRedirect("mostrar-perfil-ong");
	}

	private void confirmarLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String usuarioInvalido = null;
		String emailUsuario = request.getParameter("email-usuario");
		String senhaUsuario = request.getParameter("senha-usuario");
		boolean existe = daoUsuario.verificarUsuario(emailUsuario, senhaUsuario);

		if (existe) {
			HttpSession sessao = request.getSession();
			Usuario usuario = daoUsuario.recuperarUsuarioEmail(emailUsuario);
			sessao.setAttribute("usuario", usuario);
			response.sendRedirect("home");
		} else {
			usuarioInvalido = "invalido";
			request.setAttribute("usuario-invalido", usuarioInvalido);
			response.sendRedirect("novo-login");
		}

	}

	private void finalizarLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.getSession().invalidate();

		response.sendRedirect("home.jsp");

	}

}
