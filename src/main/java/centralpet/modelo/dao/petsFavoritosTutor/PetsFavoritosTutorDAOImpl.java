package centralpet.modelo.dao.petsFavoritosTutor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import centralpet.modelo.entidade.favorito.PetsFavoritosTutor;
import centralpet.modelo.entidade.favorito.PetsFavoritosTutor_;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.tutor.Tutor;
import centralpet.modelo.factory.conexao.ConexaoFactory;

public class PetsFavoritosTutorDAOImpl implements PetsFavoritosTutorDAO{

	private ConexaoFactory fabrica;

	public PetsFavoritosTutorDAOImpl() {

		fabrica = new ConexaoFactory();
	}
	
	public void inserirPetsFavoritados(PetsFavoritosTutor petFavoritado) {
		
		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.save(petFavoritado);

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

	
	public void deletarPetsFavoritados(PetsFavoritosTutor petFavoritado) {
		
		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.delete(petFavoritado);

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

	
	public void atualizarPetsFavoritados(PetsFavoritosTutor petFavoritado) {
		
		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.update(petFavoritado);

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


	public PetsFavoritosTutor recuperarFavorito(Pet pet, Tutor tutor) {
		
		Session sessao = null;
		PetsFavoritosTutor petFavorito = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<PetsFavoritosTutor> criteria = construtor.createQuery(PetsFavoritosTutor.class);
			
			Root<PetsFavoritosTutor> raizPetsFavoritos = criteria.from(PetsFavoritosTutor.class);
			
			criteria.select(raizPetsFavoritos);
			
			criteria.where(construtor.and(
					construtor.equal(raizPetsFavoritos.get(PetsFavoritosTutor_.usuario), tutor.getId())),
					construtor.equal(raizPetsFavoritos.get(PetsFavoritosTutor_.pet), pet.getId()));
			
			petFavorito = sessao.createQuery(criteria).getSingleResult();
			
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if(sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		
		return petFavorito;
	}
	
}
