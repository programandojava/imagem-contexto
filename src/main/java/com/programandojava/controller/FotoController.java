package com.programandojava.controller;

import java.io.FileNotFoundException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.programandojava.util.FotoUtil;

@ManagedBean(name = "fotoMB")
@RequestScoped
public class FotoController implements Serializable {
	private static final long serialVersionUID = -2512806101450140965L;

	public StreamedContent getFoto() throws FileNotFoundException {
		String fotoNome = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("fotoNome");

		if(FacesContext.getCurrentInstance().getRenderResponse() || fotoNome == null)			
			return new DefaultStreamedContent();
		
		else
			return FotoUtil.recuperarFotoDisco(fotoNome);
	}
}