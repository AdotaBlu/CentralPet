package centralpet.modelo.factory.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexaoFactory {

	public SessionFactory getConexao() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(centralpet.modelo.entidade.endereco.Endereco.class);
		configuracao.addAnnotatedClass(centralpet.modelo.entidade.contato.Contato.class);
		configuracao.addAnnotatedClass(centralpet.modelo.entidade.usuario.Usuario.class);
		configuracao.addAnnotatedClass(centralpet.modelo.entidade.ong.Ong.class);
		configuracao.addAnnotatedClass(centralpet.modelo.entidade.tutor.Tutor.class);
		configuracao.addAnnotatedClass(centralpet.modelo.entidade.pet.Pet.class);
		configuracao.addAnnotatedClass(centralpet.modelo.entidade.adocao.Adocao.class);
		configuracao.addAnnotatedClass(centralpet.modelo.entidade.termo.Termo.class);
		configuracao.addAnnotatedClass(centralpet.modelo.entidade.favorito.PetsFavoritosTutor.class);
		configuracao.addAnnotatedClass(centralpet.modelo.entidade.favorito.PetsFavoritosTutorId.class);
		configuracao.addAnnotatedClass(centralpet.modelo.entidade.acompanhamento.Acompanhamento.class);
		configuracao.addAnnotatedClass(centralpet.modelo.entidade.pendencia.Pendencia.class);
		configuracao.addAnnotatedClass(centralpet.modelo.entidade.visita.Visita.class);
		configuracao.addAnnotatedClass(centralpet.modelo.entidade.recolhimento.Recolhimento.class);
		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
				.build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
	}
}