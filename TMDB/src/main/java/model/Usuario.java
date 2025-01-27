package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
@NamedQuery(name="Usuario.findByNick", query="SELECT u FROM Usuario u where u.nick= :nick") //El :nick es una forma de definir un valor dinámico, es un marcador de posicion
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String nick;

	private String pass;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="usuario")
	private List<Rating> ratings;

	public Usuario() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Rating addRating(Rating rating) {
		getRatings().add(rating);
		rating.setUsuario(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setUsuario(null);

		return rating;
	}

}