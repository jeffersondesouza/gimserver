package br.com.gim.blog.model.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.google.gson.Gson;

@Entity
public class Artigo {
	
	public Artigo() {
		init();
	}

	private void init() {
		this.curtidas=0;
		this.descurtidas=0;
		this.isPublico = false;
		this.dataPublicacao = Calendar.getInstance();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP) 
	private Calendar dataPublicacao;
	private Integer curtidas;
	private Integer descurtidas;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Comentario> comentarios = new ArrayList<>();
	
	@Column(name="artigo_publico")
	private boolean isPublico;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public boolean isPublico() {
		return isPublico;
	}

	public void setPublico(boolean isPublico) {
		this.isPublico = isPublico;
	}

	public Integer getCurtidas() {
		return curtidas;
	}

	public Integer getDescurtidas() {
		return descurtidas;
	}

	@Override
	public String toString() {
		return "Artigo [texto=" + texto + "]";
	}
	
	public List<Comentario> getComentarios() {
		return Collections.unmodifiableList(comentarios);
	}
	
	public void addComentario(Comentario comentario) {
		this.comentarios.add(comentario);		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artigo other = (Artigo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void receberCurtida() {
		this.curtidas++;
	}
	
	public void receberDescurtida() {
		this.curtidas--;
	}

	

}
