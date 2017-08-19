package com.niit.collabackEnd.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class AppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {AppConfig.class};
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}