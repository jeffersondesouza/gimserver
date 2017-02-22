package br.com.gim.blog.util.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	private static EntityManagerFactory factory ;
	
	public EntityManagerProducer() {
		factory = Persistence.createEntityManagerFactory("gimblog");
	}
	
	
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	
	public void close(EntityManager manager){
		manager.close();
	}

}
