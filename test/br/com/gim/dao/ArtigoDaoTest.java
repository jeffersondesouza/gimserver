package br.com.gim.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.gim.blogserver.dao.ArtigoDAO;
import br.com.gim.blogserver.model.entity.Artigo;

public class ArtigoDaoTest {

	ArtigoDAO artigoDao;

	@Before
	public void iniciaArtigoDao() {
		artigoDao = new ArtigoDAO();
		assertTrue(artigoDao!=null);
	}
	
	
	@Test
	public void lerUmArtigo(){
		Artigo artigo = artigoDao.getById(1);
		
		
		
	}

}
