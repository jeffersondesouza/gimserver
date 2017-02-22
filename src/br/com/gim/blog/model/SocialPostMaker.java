package br.com.gim.blog.model;

import br.com.gim.blog.dao.ArtigoDAO;
import br.com.gim.blog.dao.UsuarioDAO;
import br.com.gim.blog.model.entity.Artigo;
import br.com.gim.blog.model.entity.Comentario;
import br.com.gim.blog.model.entity.Usuario;

public class SocialPostMaker {
	
	
	private UsuarioDAO usuarioDao;
	private ArtigoDAO artigoDao;

	public SocialPostMaker(UsuarioDAO usuarioDao, ArtigoDAO artigoDao) {
		this.usuarioDao = usuarioDao;
		this.artigoDao = artigoDao;

	
	}

	public void postar(Usuario usuario, Artigo artigo, String texto, SocialPost comentario) {

		comentario.setTexto(texto);
		comentario.setAutor(usuario);
		
		artigo.addComentario((Comentario) comentario);		
		
		usuarioDao.salvar(usuario);
		artigoDao.salvar(artigo);
	}

}
