package daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import model.Movie;

public class DaoMovie extends BaseJPADao {
	
	public static List<Movie> getAllMovies(){
		
		EntityManager em = getEntityManager();
		List<Movie> listaPeliculas = em.createNamedQuery("Movie.findAll",Movie.class).getResultList();
		return listaPeliculas;
		
	}

}
