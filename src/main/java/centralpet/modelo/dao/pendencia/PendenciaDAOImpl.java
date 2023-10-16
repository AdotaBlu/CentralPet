package centralpet.modelo.dao.pendencia;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import centralpet.modelo.entidade.pendencia.Pendencia;
import centralpet.modelo.factory.conexao.ConexaoFactory;

public class PendenciaDAOImpl implements PendenciaDAO {

	private ConexaoFactory fabrica;

	public PendenciaDAOImpl() {

		fabrica = new ConexaoFactory();

	}

	public void inserirPendencia(Pendencia pendencia) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.save(pendencia);

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

	public void deletarPendencia(Pendencia pendencia) {
		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.delete(pendencia);

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

	public void atualizarPendencia(Pendencia pendencia) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.update(pendencia);

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

	public List<Pendencia> recuperarTodasPendencias() {

		Session sessao = null;
		List<Pendencia> pendencias = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pendencia> criteria = construtor.createQuery(Pendencia.class);
			Root<Pendencia> raizPendencia = criteria.from(Pendencia.class);

			criteria.select(raizPendencia);

			pendencias = sessao.createQuery(criteria).getResultList();

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

		return pendencias;

	}

}
