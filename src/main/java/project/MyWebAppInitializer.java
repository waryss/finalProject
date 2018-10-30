package project;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class MyWebAppInitializer implements WebApplicationInitializer {
    
	
	@Override
	public void onStartup(ServletContext container) throws ServletException {	
	    AnnotationConfigWebApplicationContext context
        = new AnnotationConfigWebApplicationContext();
      context.setConfigLocation("project.config");

      container.addListener(new ContextLoaderListener(context));
  }
}