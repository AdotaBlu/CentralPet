package centralpet.modelo.dao.pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

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
import centralpet.modelo.enumeracao.pet.status.StatusPet;
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

			criteria.select(raizPet);

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

	public List<Pet> recuperarPetsPorte(Pet pet) {

		Session sessao = null;
		List<Pet> petsDessePorte = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);

			ParameterExpression<PortePet> portePet = construtor.parameter(PortePet.class);

			criteria.where(construtor.equal(portePet, pet.getPortePet()));

			petsDessePorte = sessao.createQuery(criteria).setParameter(portePet, pet.getPortePet()).getResultList();

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
		return petsDessePorte;
	}

	public List<Pet> recuperarPetsSexo(Pet pet) {
		Session sessao = null;
		List<Pet> petsDesseSexo = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);

			ParameterExpression<SexoPet> sexoPet = construtor.parameter(SexoPet.class);

			criteria.where(construtor.equal(sexoPet, pet.getSexoPet()));

			petsDesseSexo = sessao.createQuery(criteria).setParameter(sexoPet, pet.getSexoPet()).getResultList();

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
		return petsDesseSexo;
	}

	public List<Pet> recuperarPetsEspecie(Pet pet) {

		Session sessao = null;
		List<Pet> petsDessaEspecie = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);

			ParameterExpression<EspeciePet> especiePet = construtor.parameter(EspeciePet.class);

			criteria.where(construtor.equal(especiePet, pet.getEspeciePet()));

			petsDessaEspecie = sessao.createQuery(criteria).setParameter(especiePet, pet.getEspeciePet())
					.getResultList();

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
		return petsDessaEspecie;
	}

	public List<Pet> recuperarPetsStatus(Pet pet) {

		Session sessao = null;
		List<Pet> petsDesseStatus = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);

			ParameterExpression<StatusPet> statusPet = construtor.parameter(StatusPet.class);

			criteria.where(construtor.equal(statusPet, pet.getStatusPet()));

			petsDesseStatus = sessao.createQuery(criteria).setParameter(statusPet, pet.getStatusPet()).getResultList();

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
		return petsDesseStatus;
	}

	public List<Pet> recuperarPetsEstado(Pet pet) {

		Session sessao = null;
		List<Pet> petsDesseEstado = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);

			ParameterExpression<EstadoPet> estadoPet = construtor.parameter(EstadoPet.class);

			criteria.where(construtor.equal(estadoPet, pet.getEstadoPet()));

			petsDesseEstado = sessao.createQuery(criteria).setParameter(estadoPet, pet.getEstadoPet()).getResultList();

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
		return petsDesseEstado;
	}

	public List<Pet> recuperarPetsPelagem(Pet pet) {

		Session sessao = null;
		List<Pet> petsDessaPelagem = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);

			ParameterExpression<PelagemPet> pelagemPet = construtor.parameter(PelagemPet.class);

			criteria.where(construtor.equal(pelagemPet, pet.getPelagemPet()));

			petsDessaPelagem = sessao.createQuery(criteria).setParameter(pelagemPet, pet.getPelagemPet())
					.getResultList();

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
		return petsDessaPelagem;
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
			Optional<SexoPet> sexoPet, Optional<PelagemPet> pelagemPet) {

		Session sessao = null;
		List<Pet> petsFiltrados = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);
			Root<Pet> raizPet = criteria.from(Pet.class);

			criteria.select(raizPet);

			List<Predicate> predicatos = new ArrayList<>();

			especiePet.ifPresent(especie -> predicatos.add(construtor.equal(raizPet.get("especiePet"), especiePet.get())));
			portePet.ifPresent(porte -> predicatos.add(construtor.equal(raizPet.get("portePet"), portePet.get())));
			sexoPet.ifPresent(sexo -> predicatos.add(construtor.equal(raizPet.get("sexoPet"), sexoPet.get())));
			pelagemPet.ifPresent(pelagem -> predicatos.add(construtor.equal(raizPet.get("pelagemPet"), pelagemPet.get())));

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
}
	