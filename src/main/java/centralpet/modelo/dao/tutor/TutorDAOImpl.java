package centralpet.modelo.dao.tutor;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import centralpet.modelo.entidade.tutor.Tutor;
import centralpet.modelo.factory.conexao.ConexaoFactory;


//Classe TutorDAOImpl implementa a classe TutorDAO
public class TutorDAOImpl implements TutorDAO {

	// Define a classe ConexaoFactory cujo é responsável pela conexão com o BD

	private ConexaoFactory fabrica;

	// Cria o construtor

	public TutorDAOImpl() {

		// Define o método fabrica

		fabrica = new ConexaoFactory();

	}

	// Método de inserir tutor

	public void inserirTutor(Tutor tutor) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.save(tutor);

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

	// Método de deletar tutor

	public void deletarTutor(Tutor tutor) {
		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.delete(tutor);

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

	// Método de atualizar tutor

	public void atualizarTutor(Tutor tutor) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.update(tutor);

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

	// Método de recuperar todos tutor a partir do ID

	public List<Tutor> recuperarTodosTutores() {

		Session sessao = null;
		List<Tutor> tutores = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Tutor> criteria = construtor.createQuery(Tutor.class);
			Root<Tutor> raizTutor = criteria.from(Tutor.class);
			
			criteria.select(raizTutor);
			
			tutores = sessao.createQuery(criteria).getResultList();
			
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

		return tutores;

	}
	

}