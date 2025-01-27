package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the RATING database table.
 * 
 */
@Entity
@NamedQuery(name="Rating.findAll", query="SELECT r FROM Rating r")
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idrating;

	private Integer puntos;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="IDPERSON")
	private Person person;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="IDUSUARIO")
	private Usuario usuario;

	public Rating() {
	}

	public long getIdrating() {
		return this.idrating;
	}

	public void setIdrating(long idrating) {
		this.idrating = idrating;
	}

	public Integer getPuntos() {
		return this.puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}