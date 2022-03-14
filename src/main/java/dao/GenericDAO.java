package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import maven_hibernate.maven_hibernate.HibernateUtil;

public class GenericDAO<E> {  //E - define uma classe
	
	private EntityManager entityManager = HibernateUtil.getEntityManager(); // cria o gerenciador de entidade nesta classe a partir do Hibernate util
	
	public void create(E entidade) {
		EntityTransaction transition = entityManager.getTransaction();
		transition.begin(); // inicia transaçao
		
		entityManager.persist(entidade);  // salva no hibernate
		
		transition.commit(); // salva no BD
		
	}
	
	
	public E read(Long id, Class<E> entidade) {
		
		E e = (E) entityManager.find(entidade, id);  //procura o dado no BD pelo id ou outro parametro
		
		return e;
		
	}
	
	public List<E> readAll(Class<E> entidade) {
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		List<E> list = entityManager.createQuery("FROM " + entidade.getName()).getResultList();

		transaction.commit();
		
		return list;
		
	}
	
	public void update(E entidade) {  //mesmo que o create mas ao inves do metodo persist usamos o merge, precisa receber a entidde a ser alterada.
		
		EntityTransaction transition = entityManager.getTransaction();
		transition.begin(); // inicia transaçao
		
		entityManager.merge(entidade);  // salva no hibernate
		
		transition.commit(); // salva no BD
		
	}
	
	public void delete(E entidade) {
		
		EntityTransaction transaction = entityManager.getTransaction();  //cria transaçao
		transaction.begin();  //inicia a transacao
		
		entityManager.remove(entidade);  //deleta o objeto recebido
		
		transaction.commit();  //salva no BD
		
	}
	
	
	public EntityManager getEntityManager() {  //posso chamar o entityManager de qqr local do projeto
		return entityManager;
	}
	
	
	// .entityManager.createNativeQuery() ou .entityManager.createQuery() é possivel criar uma query HQL
	// .getResultList().setmaxresults() traz um numero maximo de resultados

}
