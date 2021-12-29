package com.itau.thecat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@Table(name="image")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=30)
	private String id;

	private int height;

	@Column(nullable=false, length=60)
	private String url;

	private int width;

	//bi-directional many-to-one association to Breed
	@OneToMany(mappedBy="image")
	private List<Breed> breeds;

	public Image() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public List<Breed> getBreeds() {
		return this.breeds;
	}

	public void setBreeds(List<Breed> breeds) {
		this.breeds = breeds;
	}

	public Breed addBreed(Breed breed) {
		getBreeds().add(breed);
		breed.setImage(this);

		return breed;
	}

	public Breed removeBreed(Breed breed) {
		getBreeds().remove(breed);
		breed.setImage(null);

		return breed;
	}

}