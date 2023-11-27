package centralpet.modelo.dao.recolhimento;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import centralpet.modelo.entidade.recolhimento.Recolhimento;
import centralpet.modelo.factory.conexao.ConexaoFactory;

public class RecolhimentoDAOImpl implements RecolhimentoDAO {

	private ConexaoFactory fabrica;

	public RecolhimentoDAOImpl() {

		fabrica = new ConexaoFactory();

	}

	public void inserirRecolhimento(Recolhimento recolhimento) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.save(recolhimento);

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

	public void deletarRecolhimento(Recolhimento recolhimento) {
		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.delete(recolhimento);

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

	public void atualizarRecolhimento(Recolhimento recolhimento) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.update(recolhimento);

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

	public List<Recolhimento> recuperarTodosRecolhimentos() {

		Session sessao = null;
		List<Recolhimento> recolhimentos = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Recolhimento> criteria = construtor.createQuery(Recolhimento.class);
			Root<Recolhimento> raizRecolhimento = criteria.from(Recolhimento.class);

			criteria.select(raizRecolhimento);

			recolhimentos = sessao.createQuery(criteria).getResultList();

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

		return recolhimentos;

	}

}
