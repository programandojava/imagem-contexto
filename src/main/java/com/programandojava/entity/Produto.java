package com.programandojava.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "TBL_PRODUTO")
public class Produto implements Serializable {
	private static final long serialVersionUID = -834851092508638127L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUTO_ID")
	private Long id;

	@OneToOne
	@JoinColumn(name = "FOTO_ID")
	@Cascade(value = CascadeType.ALL)
	private Foto foto;

	@Column(name = "PRODUTO_NOME")
	private String nome;
	
	public Produto() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", foto=" + foto + ", nome=" + nome + "]";
	}
}