package br.com.gim.blogserver.webservice;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.gim.blogserver.model.entity.Artigo;
import br.com.gim.blogserver.model.entity.Comentario;
import br.com.gim.blogserver.service.ArtigoService;
import br.com.gim.blogserver.service.ComentarioService;

@WebService
@Stateless
public class BlogServerWS implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	ArtigoService artigoService;

	@Inject
	ComentarioService comentarioService;	
	
	@WebResult(name="artigos")
	public List<Artigo> getArtigos(){
		return artigoService.lista();
	}
	
	@WebResult(name="artigo")
	public Artigo getArtigoById(@WebParam(name="artigoId") Long id){
		return artigoService.getById(id);
	}
	
	@WebResult(name="artigo")
	public void salvarArtigo(@WebParam(name="artigo") Artigo artigo){
		artigoService.salvar(artigo);
	}
	
	@WebResult(name="artigo")
	public void removerArtigo(@WebParam(name="artigo") Artigo artigo){
		artigoService.remove(artigo);
	}
	
	@WebResult(name="curtir")
	public void curtirArtigo(@WebParam(name="artigoId") Long artigoId){
		artigoService.curtir(artigoId);
	}
	
	@WebResult(name="descurtir")
	public void descurtirArtigo(@WebParam(name="artigoId") Long artigoId){
		artigoService.descurtir(artigoId);
	}
	
	public void criarComentario(@WebParam(name="comentario") Comentario comentario){
		comentarioService.fazerComentario(comentario);
	}
}
