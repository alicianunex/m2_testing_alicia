package com.example.m2_testing_alicia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

	//  Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private Double duracion;

	// Constructores

	public Movie() {
	}

	public Movie(Long id, String name, Double duracion) {
		this.id = id;
		this.name = name;
		this.duracion = duracion;
	}
	// Métodos

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Return


	@Override
	public String toString() {
		return "Movie{" +
				"id=" + id +
				", name='" + name + '\'' +
				", duracion=" + duracion +
				'}';
	}
}
