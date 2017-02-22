package br.com.gim.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.gim.blog.dao.ArtigoDAO;
import br.com.gim.blog.model.entity.Artigo;

public class PopulandoBancoTesteViaMain {

	@Inject
	static ArtigoDAO artigoDao;
	
	public static void main(String[] args) {
		List<Artigo> lista = artigoDao.lista();

	}

}
