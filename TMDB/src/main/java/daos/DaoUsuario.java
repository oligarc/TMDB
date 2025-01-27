package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Usuario;

public class DaoUsuario extends BaseJPADao {
	
	public static void insertarUsuario(Usuario u) {
		
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(u);
		tx.commit();
		em.close();
		
	}
	
	public static Usuario getUsuario(String nick) {
		
		EntityManager em = getEntityManager();
		TypedQuery<Usuario> q = em.createNamedQuery("Usuario.findByNick", Usuario.class); //TypedQuery crea una consulta tipada para que el resultado esté
		//directamente relacionado con la clase Usuario y luego usas la consulta creada en la clase Usuario
		q.setParameter("nick", nick); //Estableces el valor del parametro nombrado :nick que se usa en la consulta creada en Usuario
		Usuario u;
		try {
			u = q.getSingleResult();
		}catch(NoResultException e){
			u=null;
		}
		
		em.close();
		return u;
		
	}

}
