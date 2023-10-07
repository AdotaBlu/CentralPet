package centralpet.controle.cadastroServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centralpet.modelo.dao.contato.ContatoDAO;
import centralpet.modelo.dao.contato.ContatoDAOImpl;
import centralpet.modelo.dao.endereco.EnderecoDAO;
import centralpet.modelo.dao.endereco.EnderecoDAOImpl;
import centralpet.modelo.dao.ong.OngDAO;
import centralpet.modelo.dao.ong.OngDAOImpl;
import centralpet.modelo.dao.tutor.TutorDAO;
import centralpet.modelo.dao.tutor.TutorDAOImpl;
import centralpet.modelo.entidade.contato.Contato;
import centralpet.modelo.entidade.endereco.Endereco;
import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.tutor.Tutor;
import centralpet.modelo.enumeracao.genero.GeneroTutor;

@WebServlet("/")
public class Cadastro extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private EnderecoDAO daoEndereco;

	private TutorDAO daoTutor;

	private ContatoDAO daoContato;
	
	private OngDAO daoOng;

	public void init() {
		daoEndereco = new EnderecoDAOImpl();
		daoTutor = new TutorDAOImpl();
		daoContato = new ContatoDAOImpl();
		daoOng = new OngDAOImpl();
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
	
	

	private void inserirTutor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Endereco endereco = null;

		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String pontoReferencia = request.getParameter("pontoReferencia");
		endereco = new Endereco(logradouro, numero, bairro, cep, pontoReferencia);
		daoEndereco.inserirEndereco(endereco);

		Tutor tutor = null;

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		GeneroTutor generoTutor = GeneroTutor.valueOf(request.getParameter("generoTutor"));
		String senha = request.getParameter("senha");
		tutor = new Tutor(nome, endereco, cpf, dataNascimento, generoTutor, senha);
		daoTutor.inserirTutor(tutor);
		
		Contato contato = null;
		
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		contato = new Contato(email, telefone, tutor);
		daoContato.inserirContato(contato);
		response.sendRedirect("home.jsp");
	}
	
	private void inserirOng(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		Endereco endereco = null;

		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String pontoReferencia = request.getParameter("pontoReferencia");
		endereco = new Endereco(logradouro, numero, bairro, cep, pontoReferencia);
		daoEndereco.inserirEndereco(endereco);
		
		Ong ong = null;
		
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cnpj = request.getParameter("cnpj");
		ong = new Ong(nome, endereco, cnpj, senha);
		daoOng.inserirOng(ong);
		
		Contato contato = null;
		
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		contato = new Contato(email, telefone, ong);
		daoContato.inserirContato(contato);
		response.sendRedirect("home.jsp");
	}

}
