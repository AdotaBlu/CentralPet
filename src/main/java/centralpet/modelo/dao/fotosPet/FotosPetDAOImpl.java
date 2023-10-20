package centralpet.modelo.dao.fotosPet;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import centralpet.modelo.entidade.fotosPet.FotosPet;
import centralpet.modelo.entidade.fotosPet.FotosPet_;
import centralpet.modelo.factory.conexao.ConexaoFactory;

public class FotosPetDAOImpl implements FotosPetDAO {

	private ConexaoFactory fabrica;
	
	public FotosPetDAOImpl () {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirFotosPet(FotosPet fotos) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.save(fotos);

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
	
	public void deletarFotosPet(FotosPet fotos) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.delete(fotos);

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
	
	public List<FotosPet> recuperarFotosPet(Long id) {
		
		Session sessao = null;

		List<FotosPet> fotos= null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<FotosPet> criteria = construtor.createQuery(FotosPet.class);

			Root<FotosPet> raizFotoPet = criteria.from(FotosPet.class);
			
			criteria.select(raizFotoPet);
			
			criteria.where(construtor.equal(raizFotoPet.get(FotosPet_.pet), id));
			
			fotos = sessao.createQuery(criteria).getResultList();

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
		return fotos;
	}
	
	public FotosPet recuperarFotoId(Long id) {
		
		Session sessao = null;

		FotosPet foto = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<FotosPet> criteria = construtor.createQuery(FotosPet.class);

			Root<FotosPet> raizFotoPet = criteria.from(FotosPet.class);
			
			criteria.select(raizFotoPet);
			
			criteria.where(construtor.equal(raizFotoPet.get(FotosPet_.id), id));
			
			foto = sessao.createQuery(criteria).getSingleResult();

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
		return foto;
	}
	
	public List<FotosPet> recuperarTodasFotos() {
		
		Session sessao = null;

		List<FotosPet> fotos = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<FotosPet> criteria = construtor.createQuery(FotosPet.class);

			Root<FotosPet> raizFotoPet = criteria.from(FotosPet.class);
			
			criteria.select(raizFotoPet);
			
			fotos = sessao.createQuery(criteria).getResultList();

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
		return fotos;
	}


}
