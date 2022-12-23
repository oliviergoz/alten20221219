package eshopRest.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import eshop.util.JpaContext;

/**
 * Application Lifecycle Listener implementation class ServerListener
 *
 */
@WebListener
public class ServerListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		JpaContext.DestroyJpaContext();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		JpaContext.getEntityManagerFactory();
	}
}
