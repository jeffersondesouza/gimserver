package br.com.gim.blog.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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


	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salvar(Usuario usuario) {
		
		if(!usuarioExiste(usuario)){
			manager.persist(usuario);
		}else{
			manager.merge(usuario);
		}
	}

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void remove(Usuario usuario) {
		manager.remove(usuario);
	}


	private boolean usuarioExiste(Usuario usuario) {
		return usuario.getId()!=null;
	}





	public List<Usuario> listaComComentarios() {
		return manager.createQuery("select u from Usuario u join fetch u.comentarios", Usuario.class).getResultList();
	}



	public Usuario getById(long id) {
		return manager.find(Usuario.class, id);
	}

}
