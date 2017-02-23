package br.com.gim.blog.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gim.blog.dao.UsuarioDAO;
import br.com.gim.blog.model.entity.Artigo;
import br.com.gim.blog.model.entity.Comentario;
import br.com.gim.blog.model.entity.Usuario;

@Stateless
public class UsuarioService {

	
	@Inject
	private UsuarioDAO usuarioDAO;

	public void salvar(Usuario usuario) {
		usuarioDAO.salvar(usuario);
	}
}
