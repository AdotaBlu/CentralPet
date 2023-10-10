package centralpet.modelo.dao.fotosPet;

import centralpet.modelo.entidade.fotosPet.FotosPet;
import centralpet.modelo.factory.conexao.ConexaoFactory;

public class FotosPetDAOImpl implements FotosPetDAO {

	private ConexaoFactory fabrica;
	
	public FotosPetDAOImpl () {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirFotosPet(FotosPet fotos) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.save(fotos);

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
	
	public void deletarFotosPet(FotosPet fotos) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.delete(fotos);

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
