package br.com.gim.blog.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gim.blog.dao.ComentarioDAO;
import br.com.gim.blog.model.entity.Comentario;


@Stateless
public class ComentarioService {
	
	@Inject
	private ArtigoService artigoService;
	
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private ComentarioDAO comentarioDAO;

	public void fazerComentario(Comentario comentario) {
		artigoService.salvar(comentario.getArtigo());
		usuarioService.salvar(comentario.getAutor());
		
		comentarioDAO.salva(comentario);
		
			
	}

	
}
