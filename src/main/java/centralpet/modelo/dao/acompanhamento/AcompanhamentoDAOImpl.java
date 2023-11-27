package centralpet.modelo.dao.acompanhamento;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import centralpet.modelo.entidade.acompanhamento.Acompanhamento;
import centralpet.modelo.factory.conexao.ConexaoFactory;

public class AcompanhamentoDAOImpl implements AcompanhamentoDAO {

	private ConexaoFactory fabrica;

	public AcompanhamentoDAOImpl() {

		fabrica = new ConexaoFactory();

	}

	public void inserirAcompanhamento(Acompanhamento acompanhamento) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.save(acompanhamento);

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

	public void deletarAcompanhamento(Acompanhamento acompanhamento) {
		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.delete(acompanhamento);

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

	public void atualizarAcompanhamento(Acompanhamento acompanhamento) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.update(acompanhamento);

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

	public List<Acompanhamento> recuperarTodosAcompanhamentos() {

		Session sessao = null;
		List<Acompanhamento> acompanhamentos = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Acompanhamento> criteria = construtor.createQuery(Acompanhamento.class);
			Root<Acompanhamento> raizAcompanhamento = criteria.from(Acompanhamento.class);

			criteria.select(raizAcompanhamento);

			acompanhamentos = sessao.createQuery(criteria).getResultList();

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

		return acompanhamentos;

	}

}
