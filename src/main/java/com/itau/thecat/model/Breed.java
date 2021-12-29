package com.itau.thecat.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the breed database table.
 * 
 */
@Entity
@Table(name = "breed")
@NamedQuery(name = "Breed.findAll", query = "SELECT b FROM Breed b")
public class Breed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 15)
	private String id;

	private int adaptability;

	@Column(name = "affection_level")
	private int affectionLevel;

	@Column(name = "alt_names", length = 25)
	private String altNames;

	@Column(name = "cfa_url", length = 60)
	private String cfaUrl;

	@Column(name = "child_friendly")
	private int childFriendly;

	@Column(name = "country_code", length = 4)
	private String countryCode;

	@Column(name = "country_codes", length = 45)
	private String countryCodes;

	@Column(length = 500)
	private String description;

	@Column(name = "dog_friendly")
	private int dogFriendly;

	@Column(name = "energy_level")
	private int energyLevel;

	private int experimental;

	private int grooming;

	private int hairless;

	@Column(name = "health_issues")
	private int healthIssues;

	private int hypoallergenic;

	private int indoor;

	private int intelligence;

	private int lap;

	@Column(name = "life_span", length = 10)
	private String lifeSpan;

	@Column(length = 45)
	private String name;

	@Column(name = "suppress_tail")
	private int suppressTail;

	@Column(name = "suppressed_tail")
	private int suppressedTail;

	@Column(length = 150)
	private String temperament;

	@Column(name = "vetstreet_url", length = 60)
	private String vetstreetUrl;

	private int vocalisation;

	@Column(name = "weight_imperial", length = 15)
	private String weightImperial;

	@Column(name = "wikipedia_url", length = 60)
	private String wikipediaUrl;

	// bi-directional many-to-one association to Image
	@ManyToOne
	@JoinColumn(name = "reference_image_id")
	private Image image;

	// bi-directional many-to-one association to Weight
	@ManyToOne
	@JoinColumn(name = "weight_metric")
	private Weight weight;

	@Enumerated(EnumType.STRING)
	private StatusBreed status;

	public Breed() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAdaptability() {
		return this.adaptability;
	}

	public void setAdaptability(int adaptability) {
		this.adaptability = adaptability;
	}

	public int getAffectionLevel() {
		return this.affectionLevel;
	}

	public void setAffectionLevel(int affectionLevel) {
		this.affectionLevel = affectionLevel;
	}

	public String getAltNames() {
		return this.altNames;
	}

	public void setAltNames(String altNames) {
		this.altNames = altNames;
	}

	public String getCfaUrl() {
		return this.cfaUrl;
	}

	public void setCfaUrl(String cfaUrl) {
		this.cfaUrl = cfaUrl;
	}

	public int getChildFriendly() {
		return this.childFriendly;
	}

	public void setChildFriendly(int childFriendly) {
		this.childFriendly = childFriendly;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCodes() {
		return this.countryCodes;
	}

	public void setCountryCodes(String countryCodes) {
		this.countryCodes = countryCodes;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDogFriendly() {
		return this.dogFriendly;
	}

	public void setDogFriendly(int dogFriendly) {
		this.dogFriendly = dogFriendly;
	}

	public int getEnergyLevel() {
		return this.energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public int getExperimental() {
		return this.experimental;
	}

	public void setExperimental(int experimental) {
		this.experimental = experimental;
	}

	public int getGrooming() {
		return this.grooming;
	}

	public void setGrooming(int grooming) {
		this.grooming = grooming;
	}

	public int getHairless() {
		return this.hairless;
	}

	public void setHairless(int hairless) {
		this.hairless = hairless;
	}

	public int getHealthIssues() {
		return this.healthIssues;
	}

	public void setHealthIssues(int healthIssues) {
		this.healthIssues = healthIssues;
	}

	public int getHypoallergenic() {
		return this.hypoallergenic;
	}

	public void setHypoallergenic(int hypoallergenic) {
		this.hypoallergenic = hypoallergenic;
	}

	public int getIndoor() {
		return this.indoor;
	}

	public void setIndoor(int indoor) {
		this.indoor = indoor;
	}

	public int getIntelligence() {
		return this.intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getLap() {
		return this.lap;
	}

	public void setLap(int lap) {
		this.lap = lap;
	}

	public String getLifeSpan() {
		return this.lifeSpan;
	}

	public void setLifeSpan(String lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSuppressTail() {
		return this.suppressTail;
	}

	public void setSuppressTail(int suppressTail) {
		this.suppressTail = suppressTail;
	}

	public int getSuppressedTail() {
		return this.suppressedTail;
	}

	public void setSuppressedTail(int suppressedTail) {
		this.suppressedTail = suppressedTail;
	}

	public String getTemperament() {
		return this.temperament;
	}

	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}

	public String getVetstreetUrl() {
		return this.vetstreetUrl;
	}

	public void setVetstreetUrl(String vetstreetUrl) {
		this.vetstreetUrl = vetstreetUrl;
	}

	public int getVocalisation() {
		return this.vocalisation;
	}

	public void setVocalisation(int vocalisation) {
		this.vocalisation = vocalisation;
	}

	public String getWeightImperial() {
		return this.weightImperial;
	}

	public void setWeightImperial(String weightImperial) {
		this.weightImperial = weightImperial;
	}

	public String getWikipediaUrl() {
		return this.wikipediaUrl;
	}

	public void setWikipediaUrl(String wikipediaUrl) {
		this.wikipediaUrl = wikipediaUrl;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Weight getWeight() {
		return this.weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public StatusBreed getStatus() {
		if (status == null) {
			return StatusBreed.PENDENTE;
		}
		return status;
	}

	public void setStatus(StatusBreed status) {
		if (status == null) {
			this.status = StatusBreed.PENDENTE;
		} else {
			this.status = status;
		}
	}

	public boolean isPendente() {
		return StatusBreed.PENDENTE.equals(this.status);
	}

}