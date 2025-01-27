package test;

import java.util.List;

import daos.DaoPerson;
import model.Person;

public class DaoPersonTest {

	public static void main(String[] args) {
		
		List<Person> listaActores = DaoPerson.getAllActores();
		
		for (Person person : listaActores) {
			System.out.println(person.getNombre());
		}

	}

}
