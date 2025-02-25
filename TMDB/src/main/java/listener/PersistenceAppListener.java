package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import daos.PersistenceManagerSingleton;
/**
 * Application Lifecycle Listener implementation class PersistenceAppListener
 *
 */
@WebListener
public class PersistenceAppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public PersistenceAppListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { //Este método se ejecuta cuando la app web arrance
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    //cuando se destruye el contexto(se vueve a publicar el proyecto), se cierra la Factory 
    public void contextDestroyed(ServletContextEvent sce)  { 
         PersistenceManagerSingleton.getInstance().closeEntityManagerFactory();
    }
    
    //PersistenceAppListener gestiona el ciclo de vida de la conexión a la BBDD cuando la aplicación se inicia y se detiene
	
}