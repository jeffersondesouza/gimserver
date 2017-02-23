package br.com.gim.blogserver.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gim.blogserver.dao.UsuarioDAO;
import br.com.gim.blogserver.model.entity.Usuario;

@Stateless
public class UsuarioService {

	
	@Inject
	private UsuarioDAO usuarioDAO;

	public void salvar(Usuario usuario) {
		usuarioDAO.salvar(usuario);
	}
}
