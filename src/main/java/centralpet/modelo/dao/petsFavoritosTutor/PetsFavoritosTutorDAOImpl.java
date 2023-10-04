package centralpet.modelo.dao.petsFavoritosTutor;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import centralpet.modelo.entidade.favorito.PetsFavoritosTutor;
import centralpet.modelo.entidade.favorito.PetsFavoritosTutor_;
import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.entidade.usuario.Usuario;
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

	
	
	public List<Pet> petsFavoritadosTutor(Usuario usuario) {
		
		Session sessao = null;
		
		List<Pet> petsFavoritos = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Pet> criteria = construtor.createQuery(Pet.class);
			
			Root<PetsFavoritosTutor> raizFavaritos = criteria.from(PetsFavoritosTutor.class);
			
			Join<PetsFavoritosTutor, Usuario> juncaoTutor = raizFavaritos.join("usuario");
			
			criteria.select(raizFavaritos.get(PetsFavoritosTutor_.pet));
			
			criteria.where(construtor.equal(juncaoTutor, usuario.getId()));
			
			petsFavoritos = sessao.createQuery(criteria).getResultList();
			
			
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
		
		
		return petsFavoritos;
	}

	
	
}
