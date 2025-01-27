package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the PERSON database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String foto;

	private String nombre;

	private Integer popularidad;

	//bi-directional many-to-many association to Movie
	@ManyToMany
	@JoinTable(
		name="PERSONMOVIE"
		, joinColumns={
			@JoinColumn(name="IDPERSON")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDMOVIE")
			}
		)
	private List<Movie> movies;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="person")
	private List<Rating> ratings;

	public Person() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPopularidad() {
		return this.popularidad;
	}

	public void setPopularidad(Integer popularidad) {
		this.popularidad = popularidad;
	}

	public List<Movie> getMovies() {
		return this.movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Rating addRating(Rating rating) {
		getRatings().add(rating);
		rating.setPerson(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setPerson(null);

		return rating;
	}

}