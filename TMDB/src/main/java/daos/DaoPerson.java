package daos;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import model.Person;

public class DaoPerson extends BaseJPADao {
	
	public static List<Person> getAllActores(){
		
		List<Person> listaActores = new ArrayList<Person>();
		
		EntityManager em = getEntityManager();
		listaActores = em.createNamedQuery("Person.findAll",Person.class).getResultList();
		em.close();
		
		return listaActores;
		
	}
	
	public static Person getActorByID(long id) {
		
		Person actor = new Person();
		EntityManager em = getEntityManager();
		actor = em.find(Person.class, id);
		
		return actor;
		
	}
	
}
