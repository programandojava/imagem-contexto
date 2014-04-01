package com.programandojava.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import com.programandojava.entity.Produto;
import com.programandojava.util.Util;

public class ProdutoDAO implements Serializable {
	private static final long serialVersionUID = -8824478295052952158L;

	public Produto save(Produto produto) {
		EntityManager entityManager = Util.getEntityManager();
		
		return entityManager.merge(produto);
	}
	
	public List<Produto> listAll() {
		CriteriaQuery<Produto> query = Util.getEntityManager().getCriteriaBuilder().createQuery(Produto.class);
		
		return Util.getEntityManager().createQuery(query.select(query.from(Produto.class))).getResultList();
	}
}