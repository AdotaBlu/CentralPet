 package centralpet.modelo.dao.ong;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

import org.hibernate.Session;

import centralpet.modelo.entidade.endereco.Endereco;
import centralpet.modelo.entidade.endereco.Endereco_;
import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.ong.Ong_;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.usuario.Usuario;
import centralpet.modelo.enumeracao.endereco.bairro.Bairros;
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
			
			raizOng.fetch(Ong_.pets, JoinType.LEFT);

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

			raizOng.fetch(Ong_.pets, JoinType.LEFT);
			
			criteria.distinct(true);

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
	
	public Ong recuperarOng(Long id) {

		Session sessao = null;
		Ong essaOng = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Ong> criteria = construtor.createQuery(Ong.class);
			Root<Ong> raizOng = criteria.from(Ong.class);
			
			raizOng.fetch(Ong_.pets, JoinType.LEFT);
			
	        raizOng.fetch(Ong_.endereco, JoinType.LEFT); 
	        
	        criteria.distinct(true);

			criteria.where(construtor.equal(raizOng.get(Ong_.id), id));
			
			essaOng = sessao.createQuery(criteria).getSingleResult();
			
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

		return essaOng;
	}
	
	public Ong recuperarOngUsuario(Usuario usuario) {

		Session sessao = null;
		Ong essaOng = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Ong> criteria = construtor.createQuery(Ong.class);
			Root<Ong> raizOng = criteria.from(Ong.class);
			
			raizOng.fetch(Ong_.pets, JoinType.LEFT);
			
			criteria.distinct(true);
			
			criteria.where(construtor.equal(raizOng.get(Ong_.id), usuario.getId()));
			
			essaOng = sessao.createQuery(criteria).getSingleResult();
			
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

		return essaOng;
	}
	
	public List<Ong> recuperarOngsOpcionalBairroNome(Optional<Bairros> bairroOp, Optional<String> nomeOp) {
		
		Session sessao = null;
		List<Ong> ongsFiltradas = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Ong> criteria = construtor.createQuery(Ong.class);
			Root<Ong> raizOng = criteria.from(Ong.class);
			
			Join<Ong, Endereco> juncaoEndereco = raizOng.join(Ong_.endereco);
			
			criteria.select(raizOng);
			raizOng.fetch(Ong_.pets, JoinType.LEFT);
			
			criteria.distinct(true);
			
			List<Predicate> predicados = new ArrayList<>();
			
			bairroOp.ifPresent(bairro -> predicados.add(construtor.equal(juncaoEndereco.get(Endereco_.bairro), bairroOp.get())));
			nomeOp.ifPresent(ong -> predicados.add(construtor.like(raizOng.get(Ong_.nome), "%" + nomeOp.get() + "%" )));
			
			if (!predicados.isEmpty()) {
				criteria.where(construtor.and(predicados.toArray(new Predicate[0])));
			}
			
			ongsFiltradas = sessao.createQuery(criteria).getResultList();
			
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
		
		return ongsFiltradas;
	}
	
	public Ong recuperarOngComTermo(Long id) {
		
		Session sessao = null;
		Ong essaOng = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Ong> criteria = construtor.createQuery(Ong.class);
			Root<Ong> raizOng = criteria.from(Ong.class);
			
			raizOng.fetch(Ong_.termos, JoinType.LEFT);
	        
	        criteria.distinct(true);

			criteria.where(construtor.equal(raizOng.get(Ong_.id), id));
			
			essaOng = sessao.createQuery(criteria).getSingleResult();
			
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

		return essaOng;
	}

	public Ong recuperarOngComRespostasTermo(Long id) {
		
		Session sessao = null;
		Ong ong = null;
			
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Ong> criteria = construtor.createQuery(Ong.class);
			Root<Ong> raizOng = criteria.from(Ong.class);
			
			raizOng.fetch(Ong_.respostasTermo, JoinType.LEFT);
			
			criteria.distinct(true);
			
			criteria.where(construtor.equal(raizOng.get(Ong_.id), id));
			
			ong = sessao.createQuery(criteria).getSingleResult();
			
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			
			if(sessao.getTransaction()!= null) {
				sessao.getTransaction().rollback();
			}
		} finally {
			
			if (sessao != null) {
				sessao.close();
			}
		}
		
		return ong;
	}

}
