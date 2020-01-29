package com.securiteS.box.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModel;


@Entity
@ApiModel("Product bean")
public class Product {
	
	  @Id
	  private Long id;
	  
	  private String libelle;
	  
	  private String description;
	  
	  private String image;
	  
	  private Long price;
	  
	  private int qte;
	  
	 @ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="id_cat")
	 private Category categorie;
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public int getQte() {
		return qte;
	}

	public Category getCategorie() {
		return categorie;
	}

	public void setCategorie(Category categorie) {
		this.categorie = categorie;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}
	  
	  

}
