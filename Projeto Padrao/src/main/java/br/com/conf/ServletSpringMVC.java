package br.com.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.daos.ProdutosDAO;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Tem que colocar aqui para ser adicionado no carregamento da servlet
		// base
		return new Class[] { AppWebConfiguration.class,JPAConfiguration.class,ProdutosDAO.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String []{"/"};
	}
	
	
	
	

}
