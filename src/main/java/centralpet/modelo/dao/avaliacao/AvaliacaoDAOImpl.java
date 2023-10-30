package centralpet.modelo.dao.avaliacao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import centralpet.modelo.entidade.avaliacao.Avaliacao;
import centralpet.modelo.entidade.avaliacao.Avaliacao_;
import centralpet.modelo.entidade.ong.Ong;
import centralpet.modelo.factory.conexao.ConexaoFactory;

public class AvaliacaoDAOImpl implements AvaliacaoDAO{

	private ConexaoFactory fabrica;
	
	public AvaliacaoDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirAvaliacao(Avaliacao avaliacao) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.save(avaliacao);
			
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

	public void deletarAvaliacao(Avaliacao avaliacao) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.delete(avaliacao);
			
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

	public List<Avaliacao> recuperarAvaliacoesOng(Ong ong) {
		
		Session sessao = null;
		List<Avaliacao> avaliacoesOng = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Avaliacao> criteria = construtor.createQuery(Avaliacao.class);
			Root<Avaliacao> raizAvaliacao = criteria.from(Avaliacao.class);
			
			criteria.select(raizAvaliacao);
			
			criteria.where(construtor.equal(raizAvaliacao.get(Avaliacao_.ong), ong.getId()));

			avaliacoesOng = sessao.createQuery(criteria).getResultList();
			
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
		
		return avaliacoesOng;
	}

	
	
}
