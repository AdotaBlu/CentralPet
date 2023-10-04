package centralpet.modelo.dao.termo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.ong.Ong_;
import centralpet.modelo.entidade.termo.Termo;
import centralpet.modelo.entidade.termo.Termo_;
import centralpet.modelo.factory.conexao.ConexaoFactory;

public class TermoDAOImpl implements TermoDAO {

	private ConexaoFactory fabrica;

	public TermoDAOImpl() {

		fabrica = new ConexaoFactory();
	}

	// Método de inserir termo

	public void inserirTermo(Termo termo) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.save(termo);

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

	// Método de deletar endereço

	public void deletarTermo(Termo termo) {
		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.delete(termo);

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

	// Método de atualizar endereço

	public void atualizarTermo(Termo termo) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.update(termo);

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

	// List<Termo> recuperarTermo(Termo id);
	
	// List<Termo> recuperarTermosOng(Termo ong);
	public List<Termo> recuperarTermosOng(Ong id) {

		Session sessao = null;

		List<Termo> termos = null;
		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Termo> criteria = construtor.createQuery(Termo.class);

			Root<Termo> raizTermo = criteria.from(Termo.class);

			Join<Termo, Ong> juncaoOng = raizTermo.join(Termo_.ONG);

			ParameterExpression<Long> idOng = construtor.parameter(Long.class);

			criteria.where(construtor.equal(juncaoOng.get(Ong_.ID), idOng));

			termos = sessao.createQuery(criteria).setParameter(idOng, id.getId()).getResultList();

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

		return termos;

	}

}
