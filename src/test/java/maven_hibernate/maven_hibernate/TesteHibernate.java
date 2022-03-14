package maven_hibernate.maven_hibernate;

import java.util.ArrayList;

import org.junit.Test;

import java.util.List;

import javax.persistence.Table;

import dao.GenericDAO;
import model.TelefoneUsuario;
import model.Usuario;

public class TesteHibernate {

	@Test
	public void createUsuarioHibernate() {

		GenericDAO<Usuario> genericDAO = new GenericDAO<Usuario>();
		Usuario usuario = new Usuario();

		usuario.setNome("");
		usuario.setCidade("");
		usuario.setEmail("");
		usuario.setIdade(18);

		genericDAO.create(usuario);

	}

	@Test
	public void readUsuarioHibernate() {

		GenericDAO<Usuario> genericDAO = new GenericDAO<Usuario>();
		Usuario usuario = new Usuario();

		usuario = genericDAO.read(1L, Usuario.class);

		System.out.println(usuario);

	}
	
	@Test
	public void readAllUsuarioHibernate() {

		GenericDAO<Usuario> genericDAO = new GenericDAO<Usuario>();

		for (Usuario u : genericDAO.readAll(Usuario.class)) {
			System.out.println(u);
		}
	}

	@Test
	public void updateIdadeUsuarioHibernate() {

		GenericDAO<Usuario> genericDAO = new GenericDAO<Usuario>();
		Usuario usuario = new Usuario();

		usuario = genericDAO.read(1L, Usuario.class);

		usuario.setIdade(28);

		genericDAO.update(usuario);

		System.out.println(usuario);

	}

	@Test
	public void deleteUsuarioHibernate() {

		GenericDAO<Usuario> genericDAO = new GenericDAO<Usuario>();
		Usuario usuario = new Usuario();

		usuario = genericDAO.read(1L, Usuario.class);

		genericDAO.delete(usuario);

	}

	@Test
	public void readParameterUsuarioHibernate() {

		GenericDAO<Usuario> genericDAO = new GenericDAO<Usuario>();

		List<Usuario> list = genericDAO.getEntityManager()
				.createQuery("from Usuario where nome = :nome or nome = :nome2").setParameter("nome2", "")
				.setParameter("nome2", "").getResultList();

		for (Usuario u : list) {
			System.out.println(u);
		}

		// para usar o parametro em HQL é preciso colocar o dois pontos antes
		// chamar a classe ao inves da tabela

	}

	@Test
	public void readAllNamedQueryUsuarioHibernate() {

		GenericDAO<Usuario> genericDAO = new GenericDAO<Usuario>();

		List<Usuario> list = genericDAO.getEntityManager().createNamedQuery("Usuario.readAll").getResultList();

		for (Usuario u : list) {
			System.out.println(u);
		}

		// para usar o parametro em HQL é preciso colocar o dois pontos antes
		// chamar a classe ao inves da tabela

	}

	@Test
	public void readOneNamedQueryUsuarioHibernate() {

		GenericDAO<Usuario> genericDAO = new GenericDAO<Usuario>();

		List<Usuario> list = genericDAO.getEntityManager().createNamedQuery("Usuario.readOne")
				.setParameter("nome", "").getResultList();

		for (Usuario u : list) {
			System.out.println(u);
		}

		// para usar o parametro em HQL é preciso colocar o dois pontos antes
		// chamar a classe ao inves da tabela

	}

	@Test
	public void createTelefoneHibernate() {

		GenericDAO genericDAO = new GenericDAO(); // instanciar sem entidade pois vao ser usadas 2 diferentes

		Usuario usuario = (Usuario) genericDAO.read(1L, Usuario.class); // busca o usuario que va receber o telefone

		TelefoneUsuario telefone = new TelefoneUsuario();

		telefone.setNumero("98887777");
		telefone.setUsuarioTelefone(usuario);

		genericDAO.create(telefone);

	}
	
	@Test
	public void readTelefoneHibernate() {

		GenericDAO<TelefoneUsuario> genericDAO = new GenericDAO<TelefoneUsuario>();
		TelefoneUsuario telefone = new TelefoneUsuario();

		telefone = genericDAO.read(1L, TelefoneUsuario.class);

		System.out.println(telefone);

	}
	
	@Test
	public void readAllTenefoneHibernate() {

		GenericDAO<TelefoneUsuario> genericDAO = new GenericDAO<TelefoneUsuario>();

		for (TelefoneUsuario t : genericDAO.readAll(TelefoneUsuario.class)) {
			System.out.println(t);
		}
	}
	
	@Test
	public void updateTelefoneNumeroHibernate() {

		GenericDAO<TelefoneUsuario> genericDAO = new GenericDAO<TelefoneUsuario>();
		TelefoneUsuario telefone = new TelefoneUsuario();

		telefone = genericDAO.read(1L, TelefoneUsuario.class);

		telefone.setNumero("");

		genericDAO.update(telefone);

		System.out.println(telefone);

	}

	@Test
	public void deleteTelefoneHibernate() {

		GenericDAO<TelefoneUsuario> genericDAO = new GenericDAO<TelefoneUsuario>();
		TelefoneUsuario telefone = new TelefoneUsuario();

		telefone = genericDAO.read(1L, TelefoneUsuario.class);

		genericDAO.delete(telefone);

	}


	
	@Test
	public void readOneUsuarioTelefoneHibernate() {

		GenericDAO genericDAO = new GenericDAO(); // instanciar sem entidade pois vao ser usadas 2 diferentes

		Usuario usuario = (Usuario) genericDAO.read(1L, Usuario.class); // busca o usuario que va receber o telefone

		System.out.println(usuario.getNome());
		for (TelefoneUsuario u : usuario.getTelefone()) {
			System.out.println(u.getNumero());
		}
	}

}
