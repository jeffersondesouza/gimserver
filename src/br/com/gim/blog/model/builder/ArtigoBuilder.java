package br.com.gim.blog.model.builder;

import java.util.Calendar;

import javax.enterprise.inject.New;

import br.com.gim.blog.model.entity.Artigo;

public class ArtigoBuilder {
	
	private Artigo artigo = new Artigo();
	
	public ArtigoBuilder comTitulo(String titulo){
		this.artigo.setTitulo(titulo);
		return this;
	}
	
	public ArtigoBuilder comTexto(String texto){
		this.artigo.setTitulo(texto);
		return this;
	}
	
	
	public ArtigoBuilder naDataPublicacaoo(Calendar dataPublicacao){
		this.artigo.setDataPublicacao(dataPublicacao);
		return this;
	}
	
	public ArtigoBuilder isPublico(boolean isPublico){
		this.artigo.setPublico(isPublico);
		return this;
	}

	public Artigo build() {
		return this.artigo;
	}
	
	
	
		
}
