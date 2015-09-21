package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.ws.spi.http.HttpContext;

/**
 * Created by workstation on 18.08.2015.
 */
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String contextUrl = servletContextEvent.getServletContext().getContextPath();
        if (contextUrl.equals("")){
            contextUrl = "http://localhost:8080/sp_final/";
        }
        servletContextEvent.getServletContext().setAttribute("CONTEXT", contextUrl);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
