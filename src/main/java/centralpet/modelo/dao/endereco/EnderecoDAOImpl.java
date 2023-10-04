package centralpet.modelo.dao.endereco;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import centralpet.modelo.entidade.endereco.Endereco;
import centralpet.modelo.entidade.endereco.Endereco_;
import centralpet.modelo.entidade.tutor.Tutor;
import centralpet.modelo.entidade.usuario.Usuario;
import centralpet.modelo.entidade.usuario.Usuario_;
import centralpet.modelo.factory.conexao.ConexaoFactory;

//Classe EnderecoDAOImpl implementa a classe EnderecoDAO

public class EnderecoDAOImpl implements EnderecoDAO {

//Define a classe ConexaoFactory cujo é responsável pela conexão com o BD

	private ConexaoFactory fabrica;

//Cria o construtor

	public EnderecoDAOImpl() {

//Define o método fabrica

		fabrica = new ConexaoFactory();

	}

//Método de inserir endereço

	public void inserirEndereco(Endereco endereco) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.save(endereco);

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

//Método de deletar endereço

	public void deletarEndereco(Endereco endereco) {
		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.delete(endereco);

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

//Método de atualizar endereço

	public void atualizarEndereco(Endereco endereco) {

		org.hibernate.Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.update(endereco);

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

//Método de recuperar todos endereços

	public List<Endereco> recuperarTodosEnderecos() {

		org.hibernate.Session sessao = null;

		List<Endereco> enderecos = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);

			Root<Endereco> raizEndereco = criteria.from(Endereco.class);

			criteria.select(raizEndereco);

			enderecos = sessao.createQuery(criteria).getResultList();

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

		return enderecos;

	}

//Método de recuperar endereço do Usuário

	public Endereco recuperarEnderecoUsuario(Usuario usuario) {

		org.hibernate.Session sessao = null;

		Endereco endereco = null;
		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);

			Root<Endereco> raizEndereco = criteria.from(Endereco.class);

			Join<Endereco, Tutor> juncaoUsuario = raizEndereco.join(Endereco_.USUARIOS);

			ParameterExpression<Long> idUsuario = construtor.parameter(Long.class);

			criteria.where(construtor.equal(juncaoUsuario.get(Usuario_.ID), idUsuario));

			endereco = sessao.createQuery(criteria).setParameter(idUsuario, usuario.getId()).getSingleResult();

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

		return endereco;

	}

}