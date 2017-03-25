package edu.cursor.u21.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by vk on 3/24/17.
 */
public class WebConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(
                WebMvcConfig.class,
                SecurityConfig.class,
                ContextConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        rootContext.setServletContext(servletContext);

        ServletRegistration.Dynamic servletDispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        servletDispatcher.setLoadOnStartup(1);
        servletDispatcher.addMapping("/");
    }
}
