package cl.scrapp.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationInitializer.class);

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    private static final String DISPATCHER_SERVLET_MAPPING = "/";
    private static final String LOG4J_CONFIG_LOCATION = "log4jConfigLocation";
    private static final String LOG4J_CONFIG_LOCATION_VALUE = "/WEB-INF/spring/log4j.properties";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter(LOG4J_CONFIG_LOCATION, LOG4J_CONFIG_LOCATION_VALUE);
        Log4jConfigListener log4jListener = new Log4jConfigListener();
        servletContext.addListener(log4jListener);
        LOGGER.info("Log4j added");

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ApplicationContext.class, Spring.class, JPA.class);
        LOGGER.info("Registered to context ApplicationContext, Spring and JPA Beans");

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING);
        LOGGER.info("Dispatcher servlet mapping registered");

        servletContext.addListener(new ContextLoaderListener(rootContext));
        LOGGER.info("Context loader listener added");
    }

}
