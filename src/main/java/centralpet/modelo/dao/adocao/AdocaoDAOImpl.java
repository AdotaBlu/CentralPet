package centralpet.modelo.dao.adocao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import centralpet.modelo.entidade.adocao.Adocao;
import centralpet.modelo.entidade.adocao.Adocao_;
import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.entidade.ong.Ong_;
import centralpet.modelo.entidade.tutor.Tutor;
import centralpet.modelo.entidade.tutor.Tutor_;
import centralpet.modelo.factory.conexao.ConexaoFactory;

public class AdocaoDAOImpl implements AdocaoDAO {

private ConexaoFactory fabrica;
	
	public AdocaoDAOImpl () {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirAdocao(Adocao adocao) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.save(adocao);
			
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


	public void deletarAdocao(Adocao adocao) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.delete(adocao);
			
			sessao.getTransaction().commit();
		
		} catch(Exception sqlException) {
			
			sqlException.printStackTrace();
			
			if(sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
			
		} finally {
			
			if(sessao != null) {
				sessao.close();
			}
		}
	}


	public void atualizarAdocao(Adocao adocao) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.update(adocao);
			
			sessao.getTransaction().commit();
			
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
	}

	public List<Adocao> recuperarTodasAdocoes() {
		
		Session sessao = null;
		List<Adocao> adocoes = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Adocao> criteria = construtor.createQuery(Adocao.class);
			Root<Adocao> raizAdocao = criteria.from(Adocao.class);
			
			criteria.select(raizAdocao);
			
			adocoes = sessao.createQuery(criteria).getResultList();
			
			sessao.getTransaction().commit();
		
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
		
		return adocoes;
	}

	
	public List<Adocao> recuperarAdocoesTutor(Tutor tutor) {
		
		Session sessao = null;
		List<Adocao> adocoes = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Adocao> criteria = construtor.createQuery(Adocao.class);
			Root<Adocao> raizAdocao = criteria.from(Adocao.class);
			
			Join<Adocao, Tutor> juncaoTutor = raizAdocao.join(Adocao_.TUTOR);
			
			ParameterExpression<Long> idTutor = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoTutor.get(Tutor_.ID), idTutor));

			adocoes = sessao.createQuery(criteria).setParameter(idTutor, tutor.getId()).getResultList();
			
			sessao.getTransaction().commit();

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
		
		return adocoes;
	}
	
	public List<Adocao> recuperarAdocoesOng(Ong ong) {
		
		Session sessao = null;
		List<Adocao> doacoes = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Adocao> criteria = construtor.createQuery(Adocao.class);
			Root<Adocao> raizAdocao = criteria.from(Adocao.class);
			
			Join<Adocao, Ong> juncaoOng = raizAdocao.join(Adocao_.ONG);
			
			ParameterExpression<Long> idOng = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoOng.get(Ong_.ID), idOng));

			doacoes = sessao.createQuery(criteria).setParameter(idOng, ong.getId()).getResultList();
			
			sessao.getTransaction().commit();

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
		
		return doacoes;
	}
	
	public Adocao recuperarAdocaoPendenteTutor(Tutor tutor) {
	    Session sessao = null;
	    Adocao adocao = null;

	    try {
	        sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();

	        CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	        CriteriaQuery<Adocao> criteria = construtor.createQuery(Adocao.class);
	        Root<Adocao> raizAdocao = criteria.from(Adocao.class);

	        raizAdocao.fetch("pet", JoinType.LEFT);  
	        raizAdocao.fetch("ong", JoinType.LEFT);
	        raizAdocao.fetch("termo", JoinType.LEFT);

	        criteria.where(construtor.equal(raizAdocao.get(Adocao_.tutor), tutor.getId()));
	        
	        adocao = sessao.createQuery(criteria).getSingleResult();

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

	    return adocao;
	}
	
	public Adocao recuperarAdocao(Long id) {
		
		Session sessao = null;
		Adocao adocao = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Adocao> criteria = construtor.createQuery(Adocao.class);
			Root<Adocao> raizAdocao = criteria.from(Adocao.class);
			
			criteria.where(construtor.equal(raizAdocao.get(Adocao_.id), id));

			adocao = sessao.createQuery(criteria).getSingleResult();
			
			sessao.getTransaction().commit();

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
		
		return adocao;
	}
}
