package br.com.gim.blogserver.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gim.blogserver.dao.ComentarioDAO;
import br.com.gim.blogserver.model.entity.Comentario;


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
