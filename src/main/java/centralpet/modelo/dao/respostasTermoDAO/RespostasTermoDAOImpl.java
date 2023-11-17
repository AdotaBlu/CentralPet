package centralpet.modelo.dao.respostasTermoDAO;

import org.hibernate.Session;

import centralpet.modelo.entidade.termo.RespostasTermo;
import centralpet.modelo.factory.conexao.ConexaoFactory;

public class RespostasTermoDAOImpl implements RespostasTermoDAO{

	private ConexaoFactory fabrica;
	
	public RespostasTermoDAOImpl() {
		
		fabrica = new ConexaoFactory();
	}
	
	public void inserirRespostaTermo(RespostasTermo resposta) {
		
		Session sessao = null;
		
		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.save(resposta);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {

				sessao.getTransaction().rollback();

			}

		} finally {

			if (sessao != null) {

				sessao.close();

			}

		}
		
	}

	public void excluirRespostaTermo(RespostasTermo resposta) {
		
		Session sessao = null;
		
		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.delete(resposta);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {

				sessao.getTransaction().rollback();

			}

		} finally {

			if (sessao != null) {

				sessao.close();

			}

		}
		
	}

}
