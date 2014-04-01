package com.programandojava.util;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

public class Util implements Serializable {
	private static final long serialVersionUID = -5371928597516312539L;

	public static EntityManager getEntityManager(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

		return ((EntityManager) request.getAttribute("entityManager"));
	}
}