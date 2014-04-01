package com.programandojava.filter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = { "Faces Servlet" })
public class JPAFilter implements Filter{
	private EntityManagerFactory factory;
	
	@Override
	public void destroy() {
		this.factory.close();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
		EntityManager entityManager = this.factory.createEntityManager();
		req.setAttribute("entityManager", entityManager);
		
		entityManager.getTransaction().begin();
		fc.doFilter(req, res);
		
		try {
			if(entityManager.getTransaction().isActive())
				entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new ServletException(e.toString());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		this.factory = Persistence.createEntityManagerFactory("produtos");
	}
}