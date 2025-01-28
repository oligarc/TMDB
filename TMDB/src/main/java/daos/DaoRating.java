package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Rating;

public class DaoRating extends BaseJPADao {
	
	public static void addRating(Rating rating) {
		
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(rating);
		tx.commit();
		em.close();
	}

}
