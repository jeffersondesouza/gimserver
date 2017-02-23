package br.com.gim.blog.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import br.com.gim.blog.dao.ArtigoDAO;
import br.com.gim.blog.model.entity.Artigo;

@Stateless
public class ArtigoService {
	
	@Inject
	ArtigoDAO artigoDao;
	
	
	public List<Artigo> lista(){
		return artigoDao.lista();
	}
	
	public Artigo getById(Long id){
		return artigoDao.getById(id);
	}
	
	public void salvar(Artigo artigo){
		artigoDao.salvar(artigo);
	}
	
	public void remove(Artigo artigo){
		artigoDao.remove(artigo);
	}
	
	public void curtir(Long artigoId){
		artigoDao.curtir(artigoId);
	}
	
	public void descurtir(Long artigoId){
		artigoDao.descurtir(artigoId);
	}

	public String getTexto(long artigoId) {
		return this.getById(artigoId).getTexto();
	}



}
