package maven_hibernate.maven_hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	public static EntityManagerFactory factory = null;
	
	static {
		init();
	}
	
	private static void init() {  //faz a conexao com o BD atraves do xml do hibernate
		
		try {	
			if(factory == null) {	
				factory = Persistence.createEntityManagerFactory("maven-hibernate");	
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static EntityManager getEntityManager() {  //provê a parte de persistencia para o projeto
		return factory.createEntityManager();
	}
	
	public static Object getPrimaryKey(Object entity) { // Retorna a PK de um objeto
		return factory.getPersistenceUnitUtil().getIdentifier(entity);		
	}
	
	
	
}
