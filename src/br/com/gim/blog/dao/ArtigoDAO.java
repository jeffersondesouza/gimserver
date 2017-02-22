package br.com.gim.blog.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.gim.blog.model.entity.Artigo;

@Stateless
public class ArtigoDAO {

	@PersistenceContext
	EntityManager manager;

	public void salvar(Artigo artigo) {
		manager.getTransaction().begin();

		if (!artigoExiste(artigo)) {
			manager.persist(artigo);
		} else {
			manager.merge(artigo);
		}

		manager.getTransaction().commit();
	}

	private boolean artigoExiste(Artigo artigo) {
		return artigo.getId() != null;
	}

	public List<Artigo> lista() {
		return manager.createQuery("from Artigo", Artigo.class).getResultList();
	}

	public void remove(Artigo artigo) {
		manager.getTransaction().begin();
		manager.remove(artigo);
		manager.getTransaction().commit();

	}

	public Artigo getById(long id) {
		
		return manager.find(Artigo.class, id);
	}

	public void curtir(Artigo artigo) {
		getById(artigo.getId());
		artigo.receberCurtida();
		salvar(artigo);
	}
	
	public void descurtir(Artigo artigo) {
		getById(artigo.getId());
		artigo.receberDescurtida();		
		salvar(artigo);		
	}
}
