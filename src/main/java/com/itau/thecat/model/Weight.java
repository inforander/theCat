package com.itau.thecat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the weight database table.
 * 
 */
@Entity
@Table(name="weight")
@NamedQuery(name="Weight.findAll", query="SELECT w FROM Weight w")
public class Weight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=15)
	private String metric;

	@Column(length=15)
	private String imperial;

	//bi-directional many-to-one association to Breed
	@OneToMany(mappedBy="weight")
	private List<Breed> breeds;

	public Weight() {
	}

	public String getMetric() {
		return this.metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getImperial() {
		return this.imperial;
	}

	public void setImperial(String imperial) {
		this.imperial = imperial;
	}

	public List<Breed> getBreeds() {
		return this.breeds;
	}

	public void setBreeds(List<Breed> breeds) {
		this.breeds = breeds;
	}

	public Breed addBreed(Breed breed) {
		getBreeds().add(breed);
		breed.setWeight(this);

		return breed;
	}

	public Breed removeBreed(Breed breed) {
		getBreeds().remove(breed);
		breed.setWeight(null);

		return breed;
	}

}