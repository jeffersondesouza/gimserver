package br.com.gim.blog.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.gim.blog.model.entity.Comentario;


@Stateless
public class ComentarioDAO {

	
	@PersistenceContext
	EntityManager manager;
	
	
	public List<Comentario> lista() {
		return manager.createQuery("from Comentario",Comentario.class).getResultList();
	}

	public void salva(Comentario comentario) {
		manager.getTransaction().begin();
		manager.persist(comentario);	
		manager.getTransaction().commit();
	}

}
