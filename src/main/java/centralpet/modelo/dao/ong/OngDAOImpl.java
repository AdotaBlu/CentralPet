package centralpet.modelo.dao.ong;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import centralpet.modelo.entidade.endereco.Endereco;
import centralpet.modelo.entidade.endereco.Endereco_;
import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.ong.Ong_;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.factory.conexao.ConexaoFactory;

public class OngDAOImpl implements OngDAO {

	private ConexaoFactory fabrica;

	public OngDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirOng(Ong ong) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.save(ong);
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

	public void deletarOng(Ong ong) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.delete(ong);
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

	public void atualizarOng(Ong ong) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.update(ong);
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

	// Checar os parâmetros de comparação (equals)
	public List<Ong> recuperarOngNome(String nomeOng) {

		Session sessao = null;

		List<Ong> ongs= null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Ong> criteria = construtor.createQuery(Ong.class);

			Root<Ong> raizOng = criteria.from(Ong.class);
			
			criteria.select(raizOng);

			criteria.where(construtor.like(raizOng.get(Ong_.nome), "%" + nomeOng + "%"));

			ongs = sessao.createQuery(criteria).getResultList();

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

		return ongs;

	}

	public List<Ong> recuperarOngBairro(String localidade) {

		Session sessao = null;

		List<Ong> ongs = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Ong> criteria = construtor.createQuery(Ong.class);

			Root<Ong> raizOng = criteria.from(Ong.class);

			Join<Ong, Endereco> juncaoEndereco = raizOng.join(Ong_.endereco);

			criteria.select(raizOng);

			criteria.where(construtor.like(juncaoEndereco.get(Endereco_.bairro), "%" + localidade + "%"));

			ongs = sessao.createQuery(criteria).getResultList();

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

		return ongs;

	}

//		Session sessao = null;
//
//		List<Ong> bairros = null;
//
//		try {
//
//			sessao = fabrica.getConexao().openSession();
//
//			sessao.beginTransaction();
//
//			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
//
//			CriteriaQuery<Ong> criteria = construtor.createQuery(Ong.class);
//
//			Root<Ong> raizEndereco= criteria.from(Ong.class);
//
//		//	Join<Ong, Endereco> juncaoBairros = raizOng.join(Endereco_.BAIRRO);
//			Join<Endereco, Ong> juncaoBairros = raizEndereco.join(Endereco_.ID);
//
//			//ParameterExpression<Long> idOng = construtor.parameter(Long.class);
//			ParameterExpression<String> inputPesquisa = construtor.parameter(String.class);
//			criteria.where(construtor.equal(juncaoBairros.get(Endereco_.ID), inputPesquisa));
//
//			//bairros = sessao.createQuery(criteria).setParameter(idOng, bairro.getId()).getResultList();
//			bairros = sessao.createQuery(criteria).setParameter(inputPesquisa, bairro.getBairro()).getResultList();
//			sessao.getTransaction().commit();
//
//		} catch (Exception sqlException) {
//
//			sqlException.printStackTrace();
//
//			if (sessao.getTransaction() != null) {
//
//				sessao.getTransaction().rollback();
//
//			}
//
//		} finally {
//
//			if (sessao != null) {
//
//				sessao.close();
//
//			}
//
//		}
//
//		return bairros;
//
//	}

	public List<Pet> recuperarOngPet(Ong pet) {

		org.hibernate.Session sessao = null;

		List<Pet> pets = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);

			Root<Ong> raizOng = criteria.from(Ong.class);

			Join<Ong, Pet> juncaoBairros = raizOng.join(Ong_.PETS);

			ParameterExpression<Long> idOng = construtor.parameter(Long.class);

			criteria.where(construtor.equal(juncaoBairros.get(Ong_.ID), idOng));

			pets = sessao.createQuery(criteria).setParameter(idOng, pet.getId()).getResultList();

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

		return pets;

	}

	// Método de recuperar todas as Ongs

	public List<Ong> recuperarTodasOngs() {

		org.hibernate.Session sessao = null;

		List<Ong> ongs = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Ong> criteria = construtor.createQuery(Ong.class);

			Root<Ong> raizOng = criteria.from(Ong.class);

			criteria.select(raizOng);

			ongs = sessao.createQuery(criteria).getResultList();

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

		return ongs;

	}

}
