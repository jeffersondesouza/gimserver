package br.com.gim.blog.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.gim.blog.model.entity.Usuario;

@Stateless
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	

	
	public List<Usuario> lista() {
		
		return manager.createQuery("from Usuario", Usuario.class).getResultList();
	}



	public void salvar(Usuario usuario) {
		manager.getTransaction().begin();
		
		if(!usuarioExiste(usuario)){
			manager.persist(usuario);
		}else{
			manager.merge(usuario);
		}
		
		
		manager.getTransaction().commit();
	}



	private boolean usuarioExiste(Usuario usuario) {
		return usuario.getId()!=null;
	}



	public void remove(Usuario usuario) {
		manager.getTransaction().begin();
		manager.remove(usuario);
		manager.getTransaction().commit();
		
	}



	public List<Usuario> listaComComentarios() {
		return manager.createQuery("select u from Usuario u join fetch u.comentarios", Usuario.class).getResultList();
	}



	public Usuario getById(long id) {
		return manager.find(Usuario.class, id);
	}

}
