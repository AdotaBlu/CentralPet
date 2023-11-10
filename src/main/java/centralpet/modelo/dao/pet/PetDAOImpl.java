package centralpet.modelo.dao.pet;

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

import org.hibernate.Hibernate;
import org.hibernate.Session;

import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.ong.Ong_;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.pet.Pet_;
import centralpet.modelo.enumeracao.pet.especie.EspeciePet;
import centralpet.modelo.enumeracao.pet.estado.EstadoPet;
import centralpet.modelo.enumeracao.pet.pelagem.PelagemPet;
import centralpet.modelo.enumeracao.pet.porte.PortePet;
import centralpet.modelo.enumeracao.pet.sexo.SexoPet;
import centralpet.modelo.factory.conexao.ConexaoFactory;

public class PetDAOImpl implements PetDAO {

	private ConexaoFactory fabrica;

	public PetDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirPet(Pet pet) {

		Session sessao = null;
		
		
		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.save(pet);
			
			Ong ong = sessao.get(Ong.class, pet.getOng().getId());
			Hibernate.initialize(ong.getPets());
			ong.adicionarPet(pet);

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

	public void deletarPet(Pet pet) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(pet);

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

	public void atualizarPet(Pet pet) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(pet);

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

	public List<Pet> recuperarTodosPets() {

		Session sessao = null;
		List<Pet> pets = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);
			Root<Pet> raizPet = criteria.from(Pet.class);

			raizPet.fetch(Pet_.fotos, JoinType.LEFT);
			raizPet.fetch(Pet_.ong, JoinType.LEFT);

			pets = sessao.createQuery(criteria).getResultList();

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
	
	public List<Pet> recuperarTodosPetsAtivos() {

		Session sessao = null;
		List<Pet> petsAtivos = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);
			Root<Pet> raizPet = criteria.from(Pet.class);
			
			raizPet.fetch(Pet_.fotos, JoinType.LEFT);
			raizPet.fetch(Pet_.ong, JoinType.LEFT);
			
			criteria.where(construtor.equal(raizPet.get(Pet_.estadoPet), EstadoPet.ATIVO));

			petsAtivos = sessao.createQuery(criteria).getResultList();
			
			

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

		return petsAtivos;

	}

	public List<Pet> recuperarPetsOng(Ong ong) {
 
		Session sessao = null;
		List<Pet> petsOng = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);
			Root<Pet> raizPet = criteria.from(Pet.class);

			Join<Pet, Ong> juncaoOng = raizPet.join(Pet_.ONG);

			ParameterExpression<Long> idOng = construtor.parameter(Long.class);
			
			raizPet.fetch(Pet_.fotos, JoinType.LEFT);
			raizPet.fetch(Pet_.ong, JoinType.LEFT);

			criteria.where(construtor.equal(juncaoOng.get(Ong_.ID), idOng));

			petsOng = sessao.createQuery(criteria).setParameter(idOng, ong.getId()).getResultList();

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
		return petsOng;
	}
	
	public List<Pet> recuperarPetsAtivosOng(Ong ong) {

		Session sessao = null;
		List<Pet> petsOng = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);
			Root<Pet> raizPet = criteria.from(Pet.class);

			Join<Pet, Ong> juncaoOng = raizPet.join(Pet_.ONG);

			ParameterExpression<Long> idOng = construtor.parameter(Long.class);

			//criteria.where(construtor.equal(juncaoOng.get(Ong_.ID), idOng));
			
			raizPet.fetch(Pet_.fotos, JoinType.LEFT);
			raizPet.fetch(Pet_.ong, JoinType.LEFT);
			
			criteria.where(construtor.and(
					construtor.equal(juncaoOng.get(Ong_.id), idOng),
					construtor.equal(raizPet.get(Pet_.estadoPet), EstadoPet.ATIVO)));

			petsOng = sessao.createQuery(criteria).setParameter(idOng, ong.getId()).getResultList();

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
		return petsOng;
	}

	public Pet recuperarPet(Long id) {

		Session sessao = null;
		Pet essePet = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);
			Root<Pet> raizPet = criteria.from(Pet.class);
			
			raizPet.fetch(Pet_.fotos, JoinType.LEFT);
			raizPet.fetch(Pet_.ong, JoinType.LEFT);

			criteria.where(construtor.equal(raizPet.get(Pet_.id), id));

			essePet = sessao.createQuery(criteria).getSingleResult();

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

		return essePet;
	}

	public List<Pet> filtrarBuscaPet(Optional<EspeciePet> especiePet, Optional<PortePet> portePet,
			Optional<SexoPet> sexoPet, Optional<PelagemPet> pelagemPet, Optional<EstadoPet> estadoPet) {

		Session sessao = null;
		List<Pet> petsFiltrados = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);
			Root<Pet> raizPet = criteria.from(Pet.class);

			raizPet.fetch(Pet_.fotos, JoinType.LEFT);
			raizPet.fetch(Pet_.ong, JoinType.LEFT);

			List<Predicate> predicatos = new ArrayList<>();
			
			estadoPet.ifPresent(estado -> predicatos.add(construtor.equal(raizPet.get(Pet_.estadoPet), estadoPet.get())));
			especiePet.ifPresent(especie -> predicatos.add(construtor.equal(raizPet.get(Pet_.especiePet), especiePet.get())));
			portePet.ifPresent(porte -> predicatos.add(construtor.equal(raizPet.get(Pet_.portePet), portePet.get())));
			sexoPet.ifPresent(sexo -> predicatos.add(construtor.equal(raizPet.get(Pet_.sexoPet), sexoPet.get())));
			pelagemPet.ifPresent(pelagem -> predicatos.add(construtor.equal(raizPet.get(Pet_.pelagemPet), pelagemPet.get())));

			if (!predicatos.isEmpty()) {
				criteria.where(construtor.and(predicatos.toArray(new Predicate[0])));
			}

			petsFiltrados = sessao.createQuery(criteria).getResultList();

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
		return petsFiltrados;
	}
	
	public List<Pet> filtrarPetsEstado(Optional<EstadoPet> estadoPet, Ong ong) {

		Session sessao = null;
		List<Pet> petsFiltrados = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);
			Root<Pet> raizPet = criteria.from(Pet.class);
			
			Join<Pet, Ong> juncaoOng = raizPet.join(Pet_.ONG);
			
			raizPet.fetch(Pet_.fotos, JoinType.LEFT);
			raizPet.fetch(Pet_.ong, JoinType.LEFT);

			List<Predicate> predicados = new ArrayList<>();
			
			predicados.add(construtor.equal(juncaoOng.get(Ong_.id), ong.getId()));
			estadoPet.ifPresent(estado -> predicados.add(construtor.equal(raizPet.get(Pet_.estadoPet), estadoPet.get())));

			if (!predicados.isEmpty()) {
				criteria.where(construtor.and(predicados.toArray(new Predicate[0])));
			}

			petsFiltrados = sessao.createQuery(criteria).getResultList();

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
		return petsFiltrados;
	}
	
	
}
	