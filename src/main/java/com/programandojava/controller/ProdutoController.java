package com.programandojava.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.programandojava.dao.ProdutoDAO;
import com.programandojava.entity.Produto;
import com.programandojava.util.FotoUtil;

@ManagedBean(name = "produtoMB")
@ViewScoped
public class ProdutoController implements Serializable {
	private static final long serialVersionUID = -4131203131879586886L;

	@ManagedProperty(value = "#{uploadMB}")
	private UploadController uploadController;
	
	private Produto produto;
	
	private Produto produtoCarregado;
	
	private List<Produto> produtos;
	
	private ProdutoDAO dao;
	
	@PostConstruct
	public void init() {
		if(this.dao == null)
			this.dao = new ProdutoDAO();
		
		if(this.produto == null)
			this.produto = new Produto();
		
		if(this.produtoCarregado == null)
			this.produtoCarregado = new Produto();
			
		this.produtos = this.dao.listAll();
	}
	
	public void salvar(){
		this.produto.setFoto(FotoUtil.handlePicture(this.uploadController.getImageBytes()));
		
		this.dao.save(this.produto);
		
		this.produtos.add(this.produto);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro", "Produto inserido com êxito !"));
		
		this.produto = new Produto();
	}
	
	public void carregarProduto(Produto produto){
		this.produtoCarregado = produto;
	}

	// 
	//	GETTERS / SETTERS
	//
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public UploadController getUploadController() {
		return uploadController;
	}

	public void setUploadController(UploadController uploadController) {
		this.uploadController = uploadController;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Produto getProdutoCarregado() {
		return produtoCarregado;
	}

	public void setProdutoCarregado(Produto produtoCarregado) {
		this.produtoCarregado = produtoCarregado;
	}
}