package centralpet.modelo.dao.contato;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import centralpet.modelo.entidade.contato.Contato;
import centralpet.modelo.entidade.contato.Contato_;
import centralpet.modelo.entidade.usuario.Usuario;
import centralpet.modelo.entidade.usuario.Usuario_;
import centralpet.modelo.factory.conexao.ConexaoFactory;

public class ContatoDAOImpl implements ContatoDAO{

	private ConexaoFactory fabrica;
	
	public ContatoDAOImpl () {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirContato(Contato contato) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.save(contato);
			
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


	public void deletarContato(Contato contato) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.delete(contato);
			
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


	public void atualizarContato(Contato contato) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.update(contato);
			
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


	public List<Contato> recuperarTodosContatos() {
		
		Session sessao = null;
		List<Contato> contatos = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
			Root<Contato> raizContato = criteria.from(Contato.class);
			
			criteria.select(raizContato);
			
			contatos = sessao.createQuery(criteria).getResultList();
			
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
		
		return contatos;
	}


	public Contato recuperarContatoUsuario(Usuario usuario) {
		
		Session sessao = null;
		Contato contato = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
			Root<Contato> raizContato = criteria.from(Contato.class);
			
			Join<Contato, Usuario> juncaoUsuario = raizContato.join(Contato_.USUARIO);
			
			ParameterExpression<Long> idUsuario = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoUsuario.get(Usuario_.ID), idUsuario));

			contato = sessao.createQuery(criteria).setParameter(idUsuario, usuario.getId()).getSingleResult();
			
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
		
		return contato;
	}
	
}
