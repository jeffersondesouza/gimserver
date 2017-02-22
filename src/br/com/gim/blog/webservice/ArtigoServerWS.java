package br.com.gim.blog.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.gim.blog.dao.ArtigoDAO;
import br.com.gim.blog.model.entity.Artigo;

@WebService
@Stateless
public class ArtigoServerWS {

	@Inject
	ArtigoDAO artigoDao;
	
	
	@WebResult(name="artigos")
	public List<Artigo> getArtigos(){
		return artigoDao.lista();
	}
	
	@WebResult(name="artigo")
	public Artigo getArtigoById(@WebParam(name="artigoId") Long id){
		return artigoDao.getById(id);
	}
	
	@WebResult(name="artigo")
	public void salvarArtigo(@WebParam(name="artigo") Artigo artigo){
		artigoDao.salvar(artigo);
	}
	
	@WebResult(name="artigo")
	public void curtirArtigo(@WebParam(name="curtir") Artigo artigo){
		artigoDao.curtir(artigo);
	}
	
	
}
