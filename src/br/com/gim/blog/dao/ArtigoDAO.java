package br.com.gim.blog.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.gim.blog.model.entity.Artigo;

@Stateless
public class ArtigoDAO {

	@PersistenceContext
	EntityManager manager;

	
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salvar(Artigo artigo) {

		if (!artigoExiste(artigo)) {
			manager.persist(artigo);
		} else {
			manager.merge(artigo);
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void remove(Artigo artigo) {
		manager.remove(artigo);
	}

	private boolean artigoExiste(Artigo artigo) {
		return artigo.getId() != null;
	}

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void curtir(Long artigoId) {
		Artigo artigo = getById(artigoId);
		artigo.receberCurtida();
		salvar(artigo);
	}
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void descurtir(Long artigoId) {
		Artigo artigo = getById(artigoId);
		artigo.receberDescurtida();		
		salvar(artigo);
	}
	
	public List<Artigo> lista() {
		return manager.createQuery("from Artigo", Artigo.class).getResultList();
	}

	public Artigo getById(long id) {
		
		String jpql = "select a from Artigo a join fetch a.comentarios where a.id = :pId";
		Artigo artigo = manager.createQuery(jpql, Artigo.class)
			.setParameter("pId", id)
			.getSingleResult();
		
		
		return artigo;
	}

	
}
