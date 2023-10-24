package centralpet.modelo.dao.usuario;

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

public class UsuarioDAOImpl implements UsuarioDAO {

	private ConexaoFactory fabrica;

	public UsuarioDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirUsuario(Usuario usuario) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(usuario);

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

	public void deletarUsuario(Usuario usuario) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(usuario);

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

	public void atualizarUsuario(Usuario usuario) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(usuario);

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

	public String recuperarEmailUsuario(Usuario usuario) {

		Session sessao = null;
		String email = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<String> criteria = construtor.createQuery(String.class);
			Root<Usuario> raizContato = criteria.from(Usuario.class);

			Join<Usuario, Contato> juncaoContato = raizContato.join(Contato_.EMAIL);

			ParameterExpression<Long> idUsusario = construtor.parameter(Long.class);

			criteria.where(construtor.equal(juncaoContato.get(Usuario_.ID), idUsusario));

			criteria.select(juncaoContato.get(Contato_.EMAIL));

			email = sessao.createQuery(criteria).setParameter(idUsusario, usuario.getId()).getSingleResult();

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
		return email;
	}

	public List<Usuario> recuperarTodosUsuarios() {
		Session sessao = null;
		List<Usuario> usuarios = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario);

			usuarios = sessao.createQuery(criteria).getResultList();

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

		return usuarios;

	}

	public Boolean verificarUsuario(String emailUsuario, String senhaUsuario) {

		Session sessao = null;

		Usuario usuario = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);

			Root<Contato> raizContato = criteria.from(Contato.class);

		    criteria.select(raizContato.get(Contato_.USUARIO)); 
		    
	        criteria.where(construtor.and(
	            construtor.equal(raizContato.get(Contato_.EMAIL), emailUsuario),
	            construtor.equal(raizContato.get(Contato_.USUARIO).get(Usuario_.SENHA), senhaUsuario)));

			usuario = sessao.createQuery(criteria).getSingleResult();

			if (usuario != null) {
				
				return true;
			}

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
		
		return false;

	}
	
	public Usuario recuperarUsuarioEmail(String emailUsuario) {
		Session sessao = null;
		Usuario usuario = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);

			Root<Contato> raizContato = criteria.from(Contato.class);

		    criteria.select(raizContato.get(Contato_.USUARIO)); 
		    
	        criteria.where(construtor.equal(raizContato.get(Contato_.EMAIL), emailUsuario));
			usuario = sessao.createQuery(criteria).getSingleResult();

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

		return usuario;
		
	}

}