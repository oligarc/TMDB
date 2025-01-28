package test;

import java.util.List;

import daos.DaoPerson;
import model.Movie;
import model.Person;

public class DaoPersonTest {

	public static void main(String[] args) {
		
		List<Person> listaActores = DaoPerson.getAllActores();
		
		/*for (Person person : listaActores) {
			System.out.println(person.getNombre());
		}
		*/
		
		Person actor = DaoPerson.getActorByID(500);
		System.out.println(actor.getNombre());
		
		System.out.println("----------------PELIS------------------");
		
		List<Movie> listaPeliculasActor = actor.getMovies();
		for (Movie movie : listaPeliculasActor) {
			System.out.println(movie.getTitulo());
		}
		

	}

}
